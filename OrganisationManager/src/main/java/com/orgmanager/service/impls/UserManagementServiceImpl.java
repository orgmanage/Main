package com.orgmanager.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgmanager.entity.User;
import com.orgmanager.mapper.UserMapper;
import com.orgmanager.repo.UserRepo;
import com.orgmanager.service.UserManagementService;

@Service
@Transactional
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired UserRepo userRepo;

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
		user = userRepo.save(user);
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
