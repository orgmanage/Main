package com.orgmanager.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgmanager.entity.User;
import com.orgmanager.mapper.UserMapper;
import com.orgmanager.repo.UserRepo;
import com.orgmanager.service.IdCardGeneratorService;

@Service
@Transactional
public class IdCardGeneratorServiceImpl implements IdCardGeneratorService {

	@Autowired UserRepo userRepo;
	@Autowired UserMapper userMapper;

	@Override
	public void generateUserIdCard(Long userId){
		User user = userRepo.findOne(userId);
		System.out.println(user);
		
	}

}
