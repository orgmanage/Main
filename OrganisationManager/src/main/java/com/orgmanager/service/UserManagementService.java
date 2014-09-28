package com.orgmanager.service;

import java.util.List;

import com.orgmanager.entity.User;

public interface UserManagementService {

	public List<User> searchUsers(String searchString);
	public User getUserDetails(Long userId);
	
}
