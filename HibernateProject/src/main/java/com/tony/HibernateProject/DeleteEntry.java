package com.tony.HibernateProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteEntry extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String masString;


	public DeleteEntry()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete an Entry");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(130, 6, 189, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 28, 438, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Choose entry by Id#");
		lblNewLabel_1.setBounds(16, 52, 138, 25);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 56, 196, 122);
		contentPane.add(scrollPane);
		
		final JTextArea deleteTextField = new JTextArea();
		deleteTextField.setEditable(false);
		scrollPane.setViewportView(deleteTextField);
		
		final JComboBox deleteSpinner = new JComboBox();
		deleteSpinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String strnum = deleteSpinner.getSelectedItem().toString();
				// Call fill area function.
				fillArea(strnum, deleteTextField);
			}
		});
		deleteSpinner.setBounds(6, 82, 164, 27);
		contentPane.add(deleteSpinner);
		fillSpinner(deleteSpinner);
		
		
		JButton finalizeButton = new JButton("Delete Entry");
		finalizeButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				// Call final button.
				deletion(deleteSpinner.getSelectedItem().toString());
				
			}
		});
		finalizeButton.setBounds(37, 149, 117, 56);
		contentPane.add(finalizeButton);
	}
	
	public void fillSpinner(JComboBox spinnerBox)
	{
		// Define a list.
		List<Faculty> tempFaculties = new ArrayList<Faculty>();
		String query1 = "select fac_id from faculty_table";

		
		Query<Faculty> query = App.getSession().createQuery(query1);
		tempFaculties = query.list();
		
		// Add this to the spinnerbox.
		for(int q = 0; q < tempFaculties.size(); q++)
			spinnerBox.addItem(tempFaculties.get(q));
	}
	
	public void fillArea(String strnum, JTextArea deleteTextField)
	{
		// Set string to empty.
		masString = "";
		
		// Construct the query.
		Query query = App.getSession().createQuery("from faculty_table where fac_id = " + strnum);
		Faculty fac = (Faculty)query.uniqueResult();
		
		// Fill the master string and change the text area.
		masString = "Entry Id#" + fac.getFac_id() + "\n" +
			"First Name: " + fac.getfNameString() + "\n" +
			"Last Name: " + fac.getLastNameString() + "\n" +
			"Salary: " + fac.getSalary();
		
		deleteTextField.setText(masString);
	}
	
	public void deletion(String strnum2)
	{
		// Begin with the deletion.
		Query query = App.getSession().createQuery("from faculty_table where fac_id = " + strnum2);
		Faculty fac = (Faculty)query.uniqueResult();
		App.getSession().delete(fac);
		App.getSession().getTransaction().commit();
		
	}
	
	
	
	
	
	
	
}
















