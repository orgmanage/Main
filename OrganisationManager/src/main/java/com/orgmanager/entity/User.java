package com.orgmanager.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "USER_ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private Long userId;

	@Column(name = "ADDRESS_1") private String address1;

	@Column(name = "ADDRESS_2") private String address2;

	@Column(name = "BLOOD_GROUP") private String bloodGroup;

	@Column(name = "CITY") private String city;

	@Column(name = "COUNTRY") private String country;

	@Column(name = "DATE_OF_BIRTH") private Date dateOfBirth;

	@Column(name = "EMAIL_ID") private String emailId;

	@Column(name = "EMERG_CONTACT") private BigDecimal emergContact;

	@Column(name = "FAX_NUMBER") private BigDecimal faxNumber;

	@Column(name = "FIRST_NAME") private String firstName;

	@Column(name = "LAST_NAME") private String lastName;

	@Column(name = "MOBILE_NUMBER") private BigDecimal mobileNumber;

	@Column(name = "PHONE_NUMBER") private BigDecimal phoneNumber;

	@Column(name = "STATE") private String state;

	@Column(name = "ZIPCODE") private String zipcode;

	// bi-directional many-to-one association to UserRoleMapping
	@OneToMany(mappedBy = "user") private List<UserRoleMapping> userRoleMappings;

	// bi-directional many-to-one association to Designation
	@ManyToOne @JoinColumn(name = "DESIGNATION_ID") private Designation designation;

	// bi-directional many-to-one association to User
	@ManyToOne @JoinColumn(name = "SUPERVISOR_ID") private User user;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "user") private List<User> users;

	// bi-directional one-to-one association to Credential
	@OneToOne (cascade = {CascadeType.ALL}) @JoinColumn(name = "CREDENTIAL_ID") private Credential credential;

	public User() {
	}

	public Long getUserId(){
		return this.userId;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public String getAddress1(){
		return this.address1;
	}

	public void setAddress1(String address1){
		this.address1 = address1;
	}

	public String getAddress2(){
		return this.address2;
	}

	public void setAddress2(String address2){
		this.address2 = address2;
	}

	public String getBloodGroup(){
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup){
		this.bloodGroup = bloodGroup;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCountry(){
		return this.country;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId(){
		return this.emailId;
	}

	public void setEmailId(String emailId){
		this.emailId = emailId;
	}

	public BigDecimal getEmergContact(){
		return this.emergContact;
	}

	public void setEmergContact(BigDecimal emergContact){
		this.emergContact = emergContact;
	}

	public BigDecimal getFaxNumber(){
		return this.faxNumber;
	}

	public void setFaxNumber(BigDecimal faxNumber){
		this.faxNumber = faxNumber;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public BigDecimal getMobileNumber(){
		return this.mobileNumber;
	}

	public void setMobileNumber(BigDecimal mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public BigDecimal getPhoneNumber(){
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigDecimal phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getState(){
		return this.state;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getZipcode(){
		return this.zipcode;
	}

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public List<UserRoleMapping> getUserRoleMappings(){
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(List<UserRoleMapping> userRoleMappings){
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping){
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setUser(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping){
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setUser(null);

		return userRoleMapping;
	}

	public Designation getDesignation(){
		return this.designation;
	}

	public void setDesignation(Designation designation){
		this.designation = designation;
	}

	public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public List<User> getUsers(){
		return this.users;
	}

	public void setUsers(List<User> users){
		this.users = users;
	}

	public User addUser(User user){
		getUsers().add(user);
		user.setUser(this);

		return user;
	}

	public User removeUser(User user){
		getUsers().remove(user);
		user.setUser(null);

		return user;
	}

	public Credential getCredential(){
		return this.credential;
	}

	public void setCredential(Credential credential){
		this.credential = credential;
	}

	@Override
	public String toString(){
		return "User [userId=" + userId + ", address1=" + address1 + ", address2=" + address2 + ", bloodGroup=" + bloodGroup
				+ ", city=" + city + ", country=" + country + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", emergContact=" + emergContact + ", faxNumber=" + faxNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", phoneNumber=" + phoneNumber + ", state=" + state
				+ ", zipcode=" + zipcode + ", userRoleMappings=" + userRoleMappings + ", designation=" + designation + ", user="
				+ user + ", users=" + users + ", credential=" + credential + "]";
	}

}