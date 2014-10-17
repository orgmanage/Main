package com.orgmanager.repo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orgmanager.BaseTest;

public class RolesRepoTest extends BaseTest{

	@Autowired DesignationRepo designationRepo;
	
	@Test
	public void findOne(){
		designationRepo.findOne(1L);
	}

}
