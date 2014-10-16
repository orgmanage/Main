package com.orgmanager.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user_code_mapping database table.
 * 
 */
@Entity
@Table(name = "user_code_mapping")
public class UserCodeMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "user_id") private Long userId;

	@Lob @Column(name = "user_code") private byte[] userCode;

	public UserCodeMapping() {
	}

	public Long getUserId(){
		return this.userId;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public byte[] getUserCode(){
		return this.userCode;
	}

	public void setUserCode(byte[] userCode){
		this.userCode = userCode;
	}

}