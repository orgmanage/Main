package com.orgmanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgmanager.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
	
	@Query("select u from User u where (lower(u.firstName) like %:searchString% or " +
			"lower(u.lastName) like %:searchString% or " +
			"lower(u.dateOfBirth) like %:searchString% or " +
			"lower(u.emailId) like %:searchString% or " +
			"lower(u.mobileNumber) like %:searchString% or " +
			"lower(u.address1) like %:searchString% or " +
			"lower(u.address2) like %:searchString% or " +
			"lower(u.city) like %:searchString% or " +
			"lower(u.bloodGroup) like %:searchString% or " +
			"lower(u.country) like %:searchString% or " +
			"lower(u.state) like %:searchString% or " +
			"lower(u.zipcode) like %:searchString% )" )
	public List<User> searchUser(@Param("searchString") String searchString);
	
	public User findByUserId(@Param("userId") Long userId);

}
