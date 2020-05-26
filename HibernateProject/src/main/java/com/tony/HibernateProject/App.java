package com.tony.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;

public class App 
{
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
    public static void main( String[] args )
    {	
    	openConnection();
    	
        // Run the constructor from the new class.
    	MainWindow mainWindow = new MainWindow();
    	mainWindow.setVisible(true);;
    	
    }

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		App.session = session;
	}
    
    public static void openConnection()
    {
    	// Set up the configuration.
    	configuration = new Configuration().addAnnotatedClass(Faculty.class).configure();
    	serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	session = sessionFactory.openSession();
    	session.beginTransaction();
    }
    
}




//Faculty obj1 = new Faculty(1, "Steve", "Smith", 67580.50),
//obj2 = new Faculty(2, "Bruce", "Wayne", 150000.75);
//
//// Set up a configuration.
//Configuration myConfiguration = new Configuration().configure()
//.addAnnotatedClass(Faculty.class);
//
//// Now set up a session.
//SessionFactory myFactory = myConfiguration.buildSessionFactory();
//Session mySession = myFactory.openSession();
//Transaction transaction = mySession.beginTransaction();
//
//mySession.save(obj1);
//mySession.save(obj2);
//
//
//transaction.commit();
