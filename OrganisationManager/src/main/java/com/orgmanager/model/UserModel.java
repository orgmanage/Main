package com.orgmanager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapping;

public class UserModel  {
	
	private Long userId;	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private Long phoneNumber;
	private Long mobileNumber;
	private Long emergContactNum;
	private Long faxNumber;
	private String bloodGroup;
	private String emailId;
	@Mapping("user")
	private UserModel superVisor;	
	private CredentialModel credential;
	private DesignationModel designation;	
	@Mapping("userRoleMappings")
	private List<UserRoleModel> roles;
		
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Long getEmergContactNum() {
		return emergContactNum;
	}
	public void setEmergContactNum(Long emergContactNum) {
		this.emergContactNum = emergContactNum;
	}
	public Long getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(Long faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserModel getSuperVisor() {
		if(null==superVisor)
			superVisor= new UserModel();
		return superVisor;
	}
	
	public List<UserRoleModel> getRoles() {
		if(null==roles)
			roles= new ArrayList<UserRoleModel>();
		return roles;
	}		
	public DesignationModel getDesignation() {
		if(null==designation)
			designation=new DesignationModel();
		return designation;
	}	
	public CredentialModel getCredential() {
		if(null==credential)
			credential=new CredentialModel();
		return credential;
	}
	public void setSuperVisor(UserModel superVisor) {
		this.superVisor = superVisor;
	}
	public void setCredential(CredentialModel credential) {
		this.credential = credential;
	}
	public void setDesignation(DesignationModel designation) {
		this.designation = designation;
	}
	public void setRoles(List<UserRoleModel> roles) {
		this.roles = roles;
	}
}