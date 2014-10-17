package com.orgmanager.mapper;

import java.io.IOException;

import org.apache.catalina.util.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orgmanager.entity.UserImageMapping;
import com.orgmanager.model.UserImageMappingModel;
import com.orgmanager.model.UserModel;
import com.orgmanager.repo.UserImageMappingRepo;

@Component
public class UserImageMappingMapper {

	@Autowired UserImageMappingRepo userCodeMappingRepo;
	
    private static final Logger log = Logger.getLogger(UserImageMappingMapper.class);

	public static UserImageMapping translate(UserModel userModel, byte[] userCode){
		UserImageMapping userImageMapping = null;
		try {
			userImageMapping = new UserImageMapping();
			userImageMapping.setUserId(userModel.getUserId());
			userImageMapping.setUserCode(userCode);
			userImageMapping.setUserPortrait(userModel.getUserImage().getBytes());
		} catch (IOException e) {
			log.warn(e);
		}
		return userImageMapping;
	}

	public UserModel translate(UserModel userModel){
		if (userModel != null) {
			UserImageMapping userImageMapping = userCodeMappingRepo.findOne(userModel.getUserId());
			UserImageMappingModel userImageMappingModel = new UserImageMappingModel();
			userImageMappingModel.setUserId(userImageMapping.getUserId());
			userImageMappingModel.setUserCode(userImageMapping.getUserCode());
			userImageMappingModel.setEncodedUserCode(Base64.encode(userImageMapping.getUserCode()));
			userImageMappingModel.setUserPortrait(userImageMapping.getUserPortrait());
			userImageMappingModel.setEncodedUserPortrait(Base64.encode(userImageMapping.getUserPortrait()));
			
			userModel.setUserImageMapping(userImageMappingModel);
		}
		return userModel;
	}

}
