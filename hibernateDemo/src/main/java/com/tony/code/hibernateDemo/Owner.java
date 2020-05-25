package com.tony.code.hibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "owner_table")
public class Owner 
{
	// Declare the variables.
	@Id
	private int id;
	private String firstName, lastName, address, phoneNumber;
	private int age;
	
	
	
	public Owner() 
	{
		super();
	}
	
	public Owner(int ownder_id, String firstName, String lastName, String address, String phoneNumber, int age) {
		super();
		this.id = ownder_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
	
	public int getOwnder_id() {
		return id;
	}
	public void setOwnder_id(int ownder_id) {
		this.id = ownder_id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Owner [ownder_id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", age=" + age + "]";
	}
	
	
	

}
