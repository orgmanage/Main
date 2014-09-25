package com.orgmanager.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the credentials database table.
 * 
 */
@Entity
@Table(name="credentials")
public class Credential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CREDENTIAL_ID")
	private long credentialId;

	private String password;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="credential")
	private User user;

	public Credential() {
	}

	public long getCredentialId() {
		return this.credentialId;
	}

	public void setCredentialId(long credentialId) {
		this.credentialId = credentialId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}