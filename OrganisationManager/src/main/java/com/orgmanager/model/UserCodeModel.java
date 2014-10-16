package com.orgmanager.model;

public class UserCodeModel {

	private Long userId;

	private byte[] userCode;
	private String byteArrayString;

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public byte[] getUserCode(){
		return userCode;
	}

	public void setUserCode(byte[] userCode){
		this.userCode = userCode;
	}

	public String getByteArrayString(){
		return byteArrayString;
	}

	public void setByteArrayString(String byteArrayString){
		this.byteArrayString = byteArrayString;
	}

}
