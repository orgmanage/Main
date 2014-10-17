package com.orgmanager.service;

import java.util.List;

import com.orgmanager.entity.User;
import com.orgmanager.model.UserModel;

public interface UserManagementService {

	public List<User> searchUsers(String searchString);

	public UserModel getUserDetails(Long userId);

	public UserModel createUserDetail(UserModel userModel);

	public UserModel editUserDetail(UserModel userModel);

	public void deleteUserDetail(Long userId);

	public void createUserImage(UserModel userModel);
}
