package com.tony.HibernateProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "faculty_table")
public class Faculty 
{
	// Create out variables.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fac_id;
	private String fNameString, lastNameString;
	private double salary;
	
	
	public Faculty() 
	{
		super();
	}
	
	
	public Faculty(String fNameString, String lastNameString, double salary) 
	{
		super();
		this.fNameString = fNameString;
		this.lastNameString = lastNameString;
		this.salary = salary;
	}


	public Faculty(int fac_id, String fNameString, String lastNameString, double salary) 
	{
		super();
		this.fac_id = fac_id;
		this.fNameString = fNameString;
		this.lastNameString = lastNameString;
		this.salary = salary;
	}
	public int getFac_id() {
		return fac_id;
	}
	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}
	public String getfNameString() {
		return fNameString;
	}
	public void setfNameString(String fNameString) {
		this.fNameString = fNameString;
	}
	public String getLastNameString() {
		return lastNameString;
	}
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Faculty [fac_id=" + fac_id + ", fNameString=" + fNameString + ", lastNameString=" + lastNameString
				+ ", salary=" + salary + "]";
	}
	
	

}
