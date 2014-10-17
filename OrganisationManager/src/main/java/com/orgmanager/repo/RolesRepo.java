package com.orgmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orgmanager.entity.Role;

@Repository
public interface RolesRepo extends CrudRepository<Role,Long> {

}
