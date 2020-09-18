package com.tony.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@Table(name = "medical_employees")
@Component
public class MedicalStaff {

	@Id
	@Column(name = "med_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "years_exp")
	private int yearsExp;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "biography")
	@Type(type = "text")
	private String biography;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name = "pager_number")
	private String pager_number;
	
	@Column(name = "address")
	private String address;

	public MedicalStaff(int id, String firstName, String lastName, String position, int yearsExp, String comments,
			String emailId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.yearsExp = yearsExp;
		this.comments = comments;
		this.userName = emailId;
		this.password = password;
	}
	
	

	public MedicalStaff(int id, String firstName, String lastName, String position, int yearsExp, String comments,
			String userName, String password, String biography, String phone_number, String pager_number, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.yearsExp = yearsExp;
		this.comments = comments;
		this.userName = userName;
		this.password = password;
		this.biography = biography;
		this.phone_number = phone_number;
		this.pager_number = pager_number;
		this.address = address;
	}



	public MedicalStaff() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYearsExp() {
		return yearsExp;
	}

	public void setYearsExp(int yearsExp) {
		this.yearsExp = yearsExp;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmailId() {
		return userName;
	}

	public void setEmailId(String emailId) {
		this.userName = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPager_number() {
		return pager_number;
	}

	public void setPager_number(String pager_number) {
		this.pager_number = pager_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "MedicalStaff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", position="
				+ position + ", yearsExp=" + yearsExp + ", comments=" + comments + ", userName=" + userName
				+ ", password=" + password + ", biography=" + biography + ", phone_number=" + phone_number
				+ ", pager_number=" + pager_number + ", address=" + address + "]";
	}
	
	
	
}
