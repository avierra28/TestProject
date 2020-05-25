package com.tony.code.hibernateDemo;

import java.util.ArrayList;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	// Create a new owner and car object.
	
    public static void main( String[] args )
    {
//    	ArrayList<Owner> myList = new ArrayList<Owner>();
//    	Owner myOwner = new Owner();
//    	int i = 101;
    	//Car myCar = new Car(102, "Jeep", "White");
		
//		  Owner objOwner = new Owner(101, "Tony", "Vierra", "Castro Valley",
//		  "510-760-2505", 29), objOwner2 = new Owner(102, "Karnavi", "Joshi",
//		  "Union City", "xxx-xxx-xxxx", 24);
    	Random random = new Random();
		 
    	
    	
    	Configuration myConfiguration = new Configuration().configure()
    			.addAnnotatedClass(Owner.class)
    			.addAnnotatedClass(Car.class);
    	SessionFactory myFactory = myConfiguration.buildSessionFactory();
    	Session mySession = myFactory.openSession();
    	
    	Transaction tx = mySession.beginTransaction();
    			
		
		//mySession.save(objOwner);

//    	
//    	//myOwner = (Owner)mySession.get(Owner.class, 101);
    	
    	for(int i = 110; i <= 1000; i++)
    	{
    		Car car = new Car();
    		
    		car.setCarId(i);
    		car.setMake("Make # " + random.nextInt(1000) + 100);
    		car.setColor("Color #" + random.nextInt(10) + 1);
    		
    		// Save this.
    		mySession.save(car);
    	}
    	
//    	
    	tx.commit();
//    	
//    	for(int q = 0; q < myList.size(); q++)
//    	{
//    		System.out.println("id: " + myList.get(q).getOwnder_id() + "\n" +
//    				"First name: " + myList.get(q).getFirstName() + "\n" +
//    				"Last name: " + myList.get(q).getLastName() + "\n" +
//    				"Address: " + myList.get(q).getAddress() + "\n" +
//    				"Phone number: " + myList.get(q).getPhoneNumber() + "\n" +
//    				"Age: " + myList.get(q).getAge() + "\n\n");
//    	}
    }
}

/*
 * Java Annotations.
 * @Table(name = "<table name>") Will switch the table name to whatever is in the quotes but leave
 * the actual java variable alone.
 * 
 * @Id Will assign the table id to whatever is directly below it (must be int).
 * 
 * @Transient will not include a specific column.
 * 
 * (NOTE: All annotations must go directly above the class attribute you want it to represent.)
 * Example
 * @Transient
 * private String column_name3
 * ...
 * 
 * 
*/












