package com.tony.code.hibernateDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car
{
	// Private attributes of the class.
	@Id
	//@GeneratedValue(strategy = )
	private int id;
	private String make, color;
	
	
	public Car() 
	{
		super();
	}
	
	public Car(int carId, String make, String color) 
	{
		super();
		this.id = carId;
		this.make = make;
		this.color = color;
	}
	
	public int getCarId() {
		return id;
	}
	public void setCarId(int carId) {
		this.id = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [carId=" + id + ", make=" + make + ", color=" + color + "]";
	}
	
	

}
