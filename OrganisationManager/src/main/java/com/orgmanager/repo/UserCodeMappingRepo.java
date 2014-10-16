package com.orgmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orgmanager.entity.UserCodeMapping;

@Repository
public interface UserCodeMappingRepo extends CrudRepository<UserCodeMapping,Long> {

}
