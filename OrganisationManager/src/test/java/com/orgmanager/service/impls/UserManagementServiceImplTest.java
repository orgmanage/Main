package com.orgmanager.service.impls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.orgmanager.BaseTest;
import com.orgmanager.model.CredentialModel;
import com.orgmanager.model.DesignationModel;
import com.orgmanager.model.RoleModel;
import com.orgmanager.model.UserModel;
import com.orgmanager.model.UserRoleModel;
import com.orgmanager.web.controller.UserManagementController;

public class UserManagementServiceImplTest extends BaseTest {
	@Autowired UserManagementController userManagementController;

	@Test
	public void testCreateUserDetail(){
		UserModel userModel = populateUserModel();
		userManagementController.createUserDetails(userModel, new ModelMap());
	}

	public UserModel populateUserModel(){
		UserModel userModel = new UserModel();
		userModel.setFirstName("Firstname");
		userModel.setLastName("Lastname");
		userModel.setAddress1("Address1");
		userModel.setAddress2("address2");
		userModel.setBloodGroup("A");
		userModel.setCity("city");
		userModel.setCountry("country");
		CredentialModel credential = new CredentialModel();
		credential.setUserName("userName");
		credential.setPassword("password");
		userModel.setCredential(credential);
		userModel.setDateOfBirth(new Date());
		DesignationModel designation = new DesignationModel();
		designation.setDesignationId(1L);
		userModel.setDesignation(designation);
		userModel.setEmailId("emailId");
		userModel.setEmergContactNum(123456789L);
		userModel.setFaxNumber(7894654132L);
		userModel.setMobileNumber(7894561230L);
		userModel.setPhoneNumber(4478945612L);
		List<UserRoleModel> roles = populateRoles();
		userModel.setRoles(roles);
		userModel.setState("state");
		userModel.setZipcode("123456");
		return userModel;
	}

	public List<UserRoleModel> populateRoles(){
		List<UserRoleModel> roles = new ArrayList<UserRoleModel>();
		UserRoleModel userRole = new UserRoleModel();
		RoleModel role = new RoleModel();
		role.setRoleId(4L);
		userRole.setRole(role);
		roles.add(userRole);
		return roles;
	}
}
