package com.tony.HibernateProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ViewEntries extends JFrame {

	private JPanel contentPane;
	private List<Faculty> myList; 
	private String masterString;
	private App obj1;

	public ViewEntries() 
	{
		// Call the setup function to have everything set up.
		setUp();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Faculty Table Contents");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 6, 287, 29);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 33, 506, 12);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 47, 481, 314);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(masterString);
	}
	
	// Define a method to set everything up.
	public void setUp()
	{
		myList = new ArrayList<Faculty>();
		masterString = "";
		
		//obj1.getSession().beginTransaction();
				
		// Use HQL to retrieve the contents from the table.
		Query query = obj1.getSession().createQuery("from faculty_table");
		myList = query.list();
		
		// Set up advanced for loop.
		for(int i = 0; i < myList.size(); i++)
		{
			masterString += "Id #" + myList.get(i).getFac_id() + "\n" +
					"First Name: " + myList.get(i).getfNameString() + "\n" +
					"Last Name: " + myList.get(i).getLastNameString() + "\n" +
					"Salary: " + myList.get(i).getSalary() + "\n\n";
		}
		
	}
}



















