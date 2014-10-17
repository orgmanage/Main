package com.orgmanager.model;

public class UserImageMappingModel {

	private Long userId;

	private byte[] userCode;
	private String encodedUserCode;
	private byte[] userPortrait;
	private String encodedUserPortrait;

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

	public String getEncodedUserCode(){
		return encodedUserCode;
	}

	public void setEncodedUserCode(String encodedUserCode){
		this.encodedUserCode = encodedUserCode;
	}

	public String getEncodedUserPortrait(){
		return encodedUserPortrait;
	}

	public void setEncodedUserPortrait(String encodedUserPortrait){
		this.encodedUserPortrait = encodedUserPortrait;
	}

	public byte[] getUserPortrait(){
		return userPortrait;
	}

	public void setUserPortrait(byte[] userPortrait){
		this.userPortrait = userPortrait;
	}

}
