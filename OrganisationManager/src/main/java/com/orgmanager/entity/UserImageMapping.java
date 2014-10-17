package com.orgmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the user_code_mapping database table.
 * 
 */
@Entity
@Table(name = "user_image_mapping")
public class UserImageMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "user_id") private Long userId;

	@Lob @Column(name = "user_code") private byte[] userCode;

	@Lob @Column(name = "user_portrait") private byte[] userPortrait;

	public UserImageMapping() {
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

	public byte[] getUserPortrait(){
		return userPortrait;
	}

	public void setUserPortrait(byte[] userPortrait){
		this.userPortrait = userPortrait;
	}

}