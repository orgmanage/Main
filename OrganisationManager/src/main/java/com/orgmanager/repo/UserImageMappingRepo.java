package com.orgmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orgmanager.entity.UserImageMapping;

@Repository
public interface UserImageMappingRepo extends CrudRepository<UserImageMapping,Long> {

}
