package com.orgmanager.model;


public class UserRoleModel {
	
	private RoleModel role;

	public RoleModel getRole() {
		if(role == null)
			role = new RoleModel();
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}
	
}
