package com.orgmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orgmanager.entity.UserCodeMapping;
import com.orgmanager.model.UserCodeModel;
import com.orgmanager.model.UserModel;
import com.orgmanager.repo.UserCodeMappingRepo;

@Component
public class UserCodeMapper {

	@Autowired UserCodeMappingRepo userCodeMappingRepo;

	public static UserCodeMapping translate(Long userId, byte[] userCode){
		UserCodeMapping userCodeMapping = new UserCodeMapping();
		userCodeMapping.setUserId(userId);
		userCodeMapping.setUserCode(userCode);
		return userCodeMapping;
	}

	public UserModel translate(UserModel userModel){
		if (userModel != null) {
			UserCodeMapping userCodeMapping = userCodeMappingRepo.findOne(userModel.getUserId());
			UserCodeModel userCodeModel = new UserCodeModel();
			userCodeModel.setUserId(userCodeMapping.getUserId());
			userCodeModel.setUserCode(userCodeMapping.getUserCode());
			userCodeModel.setByteArrayString(userCodeMapping.toString());
			userModel.setUserCode(userCodeModel);
		}
		return userModel;
	}

}
