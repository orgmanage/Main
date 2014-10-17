package com.orgmanager.repo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orgmanager.BaseTest;
import com.orgmanager.entity.Role;
import com.sun.istack.internal.logging.Logger;

public class DesignationRepoTest extends BaseTest {

	@Autowired RolesRepo rolesRepo;

	final static Logger log = Logger.getLogger(DesignationRepoTest.class);

	@Test
	public void findAll(){
		Iterable<Role> findAll = rolesRepo.findAll();
		for (Role role : findAll) {
			log.info("Role :"+role.getRoleName());
		}
	}

}
