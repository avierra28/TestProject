package com.tony.HibernateProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int addC;

	public MainWindow() 
	{
		addC = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hibernate Database");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 6, 226, 23);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 28, 520, 12);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("View Table");
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ViewEntries vEntries = new ViewEntries();
				vEntries.setVisible(true);
			}
		});
		btnNewButton.setBounds(157, 52, 141, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Entry");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				addC++;
				if(addC > 1)
					App.getSession().beginTransaction();
				AddEntry addEntry = new AddEntry();
				addEntry.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(16, 52, 141, 60);
		contentPane.add(btnNewButton_1);
		
		JButton delete = new JButton("Remove Entry");
		delete.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DeleteEntry deleteEntry = new DeleteEntry();
				deleteEntry.setVisible(true);

			}
		});
		delete.setBounds(157, 112, 141, 60);
		contentPane.add(delete);
		
		JButton specialized = new JButton("Specialized Search");
		specialized.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				SpecificEntry specificEntry = new SpecificEntry();
				specificEntry.setVisible(true);
			}
		});
		specialized.setBounds(16, 112, 141, 60);
		contentPane.add(specialized);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 41, 171, 230);
		contentPane.add(scrollPane);
		
		JTextArea txtrMyHibernateDemo = new JTextArea();
		txtrMyHibernateDemo.setLineWrap(true);
		txtrMyHibernateDemo.setText("My Hibernate Demo.\nThis GUI will interact with a database table \"Faculty\" where there will be 4 options.\n\nAdd Entry: Adds an entry into the table.\nView Table: Views all the entries.\nRemove Entry: Delete one entry based on the users choice and the id\nSpecialized Search: Search the table based on a condition.");
		txtrMyHibernateDemo.setEditable(false);
		scrollPane.setViewportView(txtrMyHibernateDemo);
	}
}








