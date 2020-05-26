package com.tony.HibernateProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AddEntry extends JFrame
{

	private JPanel contentPane;
	private JTextField fName;
	private JTextField lName;
	private JTextField salary;
	private Faculty faculty;
	private static int addCounter;


	public AddEntry()
	{
		addCounter = 0;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 379, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Entry Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 6, 298, 27);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 32, 389, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Enter First Name:");
		lblNewLabel_1.setBounds(16, 45, 124, 27);
		contentPane.add(lblNewLabel_1);
		
		fName = new JTextField();
		fName.setBounds(16, 68, 130, 26);
		contentPane.add(fName);
		fName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Last Name:");
		lblNewLabel_2.setBounds(16, 97, 124, 27);
		contentPane.add(lblNewLabel_2);
		
		lName = new JTextField();
		lName.setBounds(16, 121, 130, 26);
		contentPane.add(lName);
		lName.setColumns(10);
		
		JLabel label3 = new JLabel("Enter Salary:");
		label3.setBounds(16, 148, 124, 27);
		contentPane.add(label3);
		
		salary = new JTextField();
		salary.setBounds(16, 179, 130, 26);
		contentPane.add(salary);
		salary.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 50, 169, 155);
		contentPane.add(scrollPane);
		
		final JTextArea addedEntry = new JTextArea();
		addedEntry.setEditable(false);
		scrollPane.setViewportView(addedEntry);
		
		JButton add = new JButton("Add Entry");
		add.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				addCounter++;
				if(addCounter >1)
					App.getSession().beginTransaction();
				// Call function to add.
				addToTable(fName, lName, salary, addedEntry);
			}
		});
		add.setBounds(16, 217, 137, 49);
		contentPane.add(add);
		
		
	}
	
	// Declare the function.
	public void addToTable(JTextField fn, JTextField ln, JTextField sa, JTextArea area)
	{
		String masterString = "";
		String firstString = fn.getText().toString();
		String secondString = ln.getText().toString();
		double salaryString = Double.parseDouble(sa.getText().toString());
								
		// Create a new object.
		faculty = new Faculty(firstString, secondString, salaryString);
		
		// Save the object.
		App.getSession().persist(faculty);
		masterString += "Entry added: \n" + "First Name: " + firstString + "\n" +
				"Last Name: " + secondString + "\n" +
				"Salary: " + salaryString;
		area.setText(masterString);
		
		// Commit this.
		App.getSession().getTransaction().commit();
		
		// Close the window.
	}
}















