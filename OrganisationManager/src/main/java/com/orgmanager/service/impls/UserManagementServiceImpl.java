package com.orgmanager.service.impls;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.WriterException;
import com.orgmanager.entity.User;
import com.orgmanager.entity.UserCodeMapping;
import com.orgmanager.mapper.UserCodeMapper;
import com.orgmanager.mapper.UserMapper;
import com.orgmanager.repo.UserCodeMappingRepo;
import com.orgmanager.repo.UserRepo;
import com.orgmanager.service.UserManagementService;
import com.orgmanager.util.QRCodeGenerator;

@Service
@Transactional
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired UserRepo userRepo;
	@Autowired UserCodeMappingRepo userCodeMappingRepo;

	@Override
	public List<User> searchUsers(String searchString){
		System.out.println("Search Streing " + searchString);
		List<User> userList = userRepo.searchUser(searchString);
		return userList;
	}

	@Override
	public User getUserDetails(Long userId){
		return userRepo.findByUserId(userId);
	}

	@Override
	public User createUserDetail(User user){
		try {
			user = userRepo.save(user);
			byte[] userQrCode = QRCodeGenerator.generateQrCode(user.getUserId()+"_"+user.getFirstName()+"_"+user.getLastName());
			UserCodeMapping userCodeMapper = UserCodeMapper.translate(user.getUserId(), userQrCode);
			userCodeMappingRepo.save(userCodeMapper);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User createdUser = userRepo.findOne(user.getUserId());
		return createdUser;
	}

	@Override
	public User editUserDetail(User user){
		
		user = userRepo.save(user);
		return user;
	}

	@Override
	public void deleteUserDetail(Long userId){
		userRepo.delete(userId);
	}

}
