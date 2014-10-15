package com.orgmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orgmanager.entity.Designation;

@Repository
public interface DesignationRepo extends CrudRepository<Designation,Long> {

}
