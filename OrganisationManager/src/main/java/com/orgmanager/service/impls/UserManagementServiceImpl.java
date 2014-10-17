package com.orgmanager.service.impls;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.WriterException;
import com.orgmanager.entity.User;
import com.orgmanager.entity.UserImageMapping;
import com.orgmanager.mapper.UserImageMappingMapper;
import com.orgmanager.mapper.UserMapper;
import com.orgmanager.model.UserModel;
import com.orgmanager.repo.UserImageMappingRepo;
import com.orgmanager.repo.UserRepo;
import com.orgmanager.service.UserManagementService;
import com.orgmanager.util.QRCodeGenerator;

@Service
@Transactional
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired UserRepo userRepo;
	@Autowired UserImageMappingRepo userCodeMappingRepo;
	@Autowired UserMapper userMapper;
	@Autowired UserImageMappingMapper userImageMappingMapper;

	@Override
	public List<User> searchUsers(String searchString){
		System.out.println("Search Streing " + searchString);
		List<User> userList = userRepo.searchUser(searchString);
		return userList;
	}

	@Override
	public UserModel getUserDetails(Long userId){
		User user = userRepo.findByUserId(userId);
		UserModel userModel = userMapper.translate(new UserModel(), user);
		userImageMappingMapper.translate(userModel);
		return userModel;
	}

	@Override
	public UserModel createUserDetail(UserModel userModel){
		User user = userMapper.translate(userModel);
		user = userRepo.save(user);
		userModel.setUserId(user.getUserId());
		return userModel;
	}
	
	public void createUserImage(UserModel userModel){
		try {
			byte[] userQrCode = QRCodeGenerator.generateQrCode(userModel.getUserId()+"_"+userModel.getFirstName()+"_"+userModel.getLastName());
			UserImageMapping userImageMapping = UserImageMappingMapper.translate(userModel, userQrCode);
			userCodeMappingRepo.save(userImageMapping);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserModel editUserDetail(UserModel userModel){
		User user = userMapper.translate(userModel);
		user = userRepo.save(user);
		return userModel;
	}

	@Override
	public void deleteUserDetail(Long userId){
		userRepo.delete(userId);
	}

}
