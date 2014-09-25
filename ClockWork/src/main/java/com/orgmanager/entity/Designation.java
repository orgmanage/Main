package com.orgmanager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the designations database table.
 * 
 */
@Entity
@Table(name="designations")
public class Designation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DESIGNATION_ID")
	private long designationId;

	@Column(name="DESIGNATION_DESC")
	private String designationDesc;

	@Column(name="DESIGNATION_NAME")
	private String designationName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="designation")
	private List<User> users;

	public Designation() {
	}

	public long getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public String getDesignationDesc() {
		return this.designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
	}

	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setDesignation(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setDesignation(null);

		return user;
	}

}