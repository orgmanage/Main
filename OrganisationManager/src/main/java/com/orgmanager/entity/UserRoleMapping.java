package com.orgmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the user_role_mapping database table.
 * 
 */
@Entity
@Table(name="user_role_mapping")
public class UserRoleMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ROLE_MAPPING_ID")
	private long userRoleMappingId;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public UserRoleMapping() {
	}

	public long getUserRoleMappingId() {
		return this.userRoleMappingId;
	}

	public void setUserRoleMappingId(long userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}