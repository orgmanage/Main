package com.orgmanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgmanager.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
	
	@Query("select u from User u where (" +
			"lower(u.firstName) like lower('%:searchString%') or " +
			"lower(u.lastName) like lower('%:searchString%') or " +
			"lower(u.dateOfBirth) like lower('%:searchString%') or " +
			"lower(u.emailId) like lower('%:searchString%') or " +
			"lower(u.mobileNumber) like lower('%:searchString%') or " +
			"lower(u.address1) like lower('%:searchString%') or " +
			"lower(u.address2) like lower('%:searchString%') or " +
			"lower(u.bloodGroup) like lower('%:searchString%') or " +
			"lower(u.city) like lower('%:searchString%') or " +
			"lower(u.country) like lower('%:searchString%') or " +
			"lower(u.state) like lower('%:searchString%') or " +
			"lower(u.zipcode) like lower('%:searchString%') " +
			")")
	public List<User> searchUser(@Param("searchString") String searchString);

}
