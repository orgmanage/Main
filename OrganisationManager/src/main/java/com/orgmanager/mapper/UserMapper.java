package com.orgmanager.mapper;

import static com.orgmanager.util.OrgManagerUtil.isNull;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orgmanager.entity.Credential;
import com.orgmanager.entity.Designation;
import com.orgmanager.entity.Role;
import com.orgmanager.entity.User;
import com.orgmanager.entity.UserRoleMapping;
import com.orgmanager.model.CredentialModel;
import com.orgmanager.model.DesignationModel;
import com.orgmanager.model.RoleModel;
import com.orgmanager.model.UserModel;
import com.orgmanager.model.UserRoleModel;
import com.orgmanager.repo.DesignationRepo;

@Component
public class UserMapper {
	@Autowired DesignationRepo designationRepo;
	private static final Logger log = Logger.getLogger(UserMapper.class);

	public UserModel translate(UserModel userModel, User user){
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setAddress1(user.getAddress1());
		userModel.setAddress2(user.getAddress2());
		userModel.setBloodGroup(user.getBloodGroup());
		userModel.setCity(user.getCity());
		userModel.setCountry(user.getCountry());
		userModel.setEmailId(user.getEmailId());
		if (!isNull(user.getEmergContact()))
			userModel.setEmergContactNum(user.getEmergContact().longValue());
		if (!isNull(user.getFaxNumber()))
			userModel.setFaxNumber(user.getFaxNumber().longValue());
		if (!isNull(user.getMobileNumber()))
			userModel.setMobileNumber(user.getMobileNumber().longValue());
		if (!isNull(user.getPhoneNumber()))
			userModel.setPhoneNumber(user.getPhoneNumber().longValue());
		userModel.setState(user.getState());
		userModel.setUserId(user.getUserId());
		userModel.setZipcode(user.getZipcode());
		if (null != userModel && null != userModel.getSuperVisor() && null != userModel.getSuperVisor().getUserId())
			translate(userModel.getSuperVisor(), user.getUser());
		if (null != userModel && null != userModel.getCredential() && null != userModel.getCredential().getCredentialId())
			translate(userModel, user.getCredential());
		if (null != userModel && null != userModel.getDesignation() && null != userModel.getDesignation().getDesignationId())
			translate(userModel, user.getDesignation());
		return userModel;
	}

	public static void translate(UserModel userModel, Credential credential){
		CredentialModel model = userModel.getCredential();
		model.setCredentialId(credential.getCredentialId());
		model.setUserName(credential.getUserName());
		model.setPassword(credential.getPassword());
	}

	public static void translate(UserModel userModel, Designation designation){
		DesignationModel model = userModel.getDesignation();
		model.setDesignationId(designation.getDesignationId());
		model.setDesignationName(designation.getDesignationName());
		model.setDesignationDesc(designation.getDesignationDesc());
	}

	public static void translate(UserModel userModel, List<UserRoleMapping> roles){
		for (UserRoleMapping roleMapping : roles) {
			userModel.getRoles().add(translate(roleMapping.getRole()));
		}
	}

	public static UserRoleModel translate(Role role){
		UserRoleModel userRoleModel = new UserRoleModel();
		RoleModel model = new RoleModel();
		model.setRoleId(role.getRoleId());
		model.setRoleName(role.getRoleName());
		model.setRoleDesc(role.getRoleDesc());
		userRoleModel.setRole(model);
		return userRoleModel;
	}

	public User translate(UserModel userModel){
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setAddress1(userModel.getAddress1());
		user.setAddress2(userModel.getAddress2());
		user.setBloodGroup(userModel.getBloodGroup());
		user.setCity(userModel.getCity());
		user.setCountry(userModel.getCountry());
		user.setEmailId(userModel.getEmailId());
		user.setEmergContact(BigDecimal.valueOf(userModel.getEmergContactNum()));
		user.setFaxNumber(BigDecimal.valueOf(userModel.getFaxNumber()));
		user.setMobileNumber(BigDecimal.valueOf(userModel.getMobileNumber()));
		user.setPhoneNumber(BigDecimal.valueOf(userModel.getPhoneNumber()));
		user.setState(userModel.getState());
		user.setDateOfBirth(userModel.getDateOfBirth());
		user.setUserId(userModel.getUserId());
		user.setZipcode(userModel.getZipcode());
		if (userModel.getSuperVisor().getUserId() != null)
			user.setUser(translate(userModel.getSuperVisor()));
		user.setCredential(translate(userModel.getCredential()));
		Long designationId = userModel.getDesignation().getDesignationId();
		
		Designation designation = designationRepo.findOne(designationId);
		user.setDesignation(designation);
		log.info("user :" + user);
		return user;

	}

	public static Designation translate(DesignationModel model){
		Designation designation = new Designation();
		designation.setDesignationId(model.getDesignationId());
		designation.setDesignationName(model.getDesignationName());
		designation.setDesignationDesc(model.getDesignationDesc());
		return designation;
	}

	public static Credential translate(CredentialModel model){
		Credential credential = new Credential();
		// credential.setCredentialId(model.getCredentialId());
		credential.setUserName(model.getUserName());
		credential.setPassword(model.getPassword());
		return credential;
	}
}
