package com.tony.HibernateProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.hibernate.query.Query;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SpecificEntry extends JFrame
{

	private JPanel contentPane;
	private JTextField answer;
	private App obj6;

	public SpecificEntry()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Specific Entry Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 6, 182, 28);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 33, 438, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Enter where clause here:");
		lblNewLabel_1.setBounds(23, 57, 174, 28);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 46, 185, 214);
		contentPane.add(scrollPane);
		
		final JTextArea displayArea = new JTextArea();
		displayArea.setEditable(false);
		scrollPane.setViewportView(displayArea);
		
		answer = new JTextField();
		answer.setBounds(23, 85, 153, 36);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JButton retrieveList = new JButton("Retrieve List");
		retrieveList.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				displayArea.setText("");
				// Run function.
				displaySpecific(answer.getText().toString(), displayArea);
			}
		});
		retrieveList.setBounds(23, 133, 153, 64);
		contentPane.add(retrieveList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 200, 160, 60);
		contentPane.add(scrollPane_1);
		
		JTextArea txtrNoteTableColumns = new JTextArea();
		scrollPane_1.setViewportView(txtrNoteTableColumns);
		txtrNoteTableColumns.setLineWrap(true);
		txtrNoteTableColumns.setText("Note: Table columns for you reference. \nfac_id (Primary key)\nfNameString\nlastNameString\nsalary");
		txtrNoteTableColumns.setEditable(false);
		
		
		
		
	}
	
	public void displaySpecific(String field, JTextArea area)
	{
		List<Faculty> myList = new ArrayList<Faculty>();
		String masterString = "";
		
				
		Query query = obj6.getSession().createQuery("from faculty_table " + field);
		myList = query.list();
		
		// Set up advanced for loop.
		for(int i = 0; i < myList.size(); i++)
		{
			masterString += "Id #" + myList.get(i).getFac_id() + "\n" +
				"First Name: " + myList.get(i).getfNameString() + "\n" +
				"Last Name: " + myList.get(i).getLastNameString() + "\n" +
				"Salary: " + myList.get(i).getSalary() + "\n\n";
		}
		
		// Set the area.
		area.setText(masterString);
	}

}















