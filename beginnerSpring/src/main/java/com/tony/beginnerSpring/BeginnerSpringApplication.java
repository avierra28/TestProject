package com.tony.beginnerSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BeginnerSpringApplication
{

	public static void main(String[] args) 
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("employee.xml");
        Employee myBean= (Employee)context.getBean("emp2");
        Client myBean2 = (Client)context.getBean("cl2");
        
		System.out.println(myBean);
		System.out.println(myBean2);
	}

}
