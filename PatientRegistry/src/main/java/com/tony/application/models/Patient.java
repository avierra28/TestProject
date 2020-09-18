package com.tony.application.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "patients")
@Component
public class Patient {
	
	

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", dateOfBirth=" + dateOfBirth + ", condition=" + condition + ", comments=" + comments
				+ ", seriousnes=" + seriousnes + ", roomNumber=" + roomNumber + ", added=" + added + "]";
	}

	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "date_of_birth")
	@Type(type = "date")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;
	
	@Column(name = "their_condition")
	private String condition;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "seriousness")
	private int seriousnes;
	
	@Column(name = "room_number")
	private int roomNumber;
	
	@Column(name = "added_by")
	private String added;

	public Patient(int id, String firstName, String lastName, int age, Date dateOfBirth, String condition,
			String comments, int seriousnes, int roomNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.condition = condition;
		this.comments = comments;
		this.seriousnes = seriousnes;
		this.roomNumber = roomNumber;
	}

	public Patient() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getSeriousnes() {
		return seriousnes;
	}

	public void setSeriousnes(int seriousnes) {
		this.seriousnes = seriousnes;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}
	
	
	
}













