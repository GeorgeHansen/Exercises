package test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Search implements ActionListener
{
   

   JFrame frame = new JFrame("Add Members"); 
   
   JLabel name = new JLabel (" Name");
   JLabel familyName = new JLabel("Family Name"); 
   JLabel phoneNum = new JLabel(" Phone Number");
   JLabel email = new JLabel(" e-mail");  
   
   JTextField nameField = new JTextField (8);
   JTextField familyNameField = new JTextField(8);
   JTextField phoneNumField = new JTextField(8);
   JTextField emailField = new JTextField(8);
  
   JButton submit = new JButton("Submit");
   JButton cancel = new JButton("Cancel");
   JButton clear = new JButton("Clear");

     
   public Search()
   {
     
      frame.setSize(400,500);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); //destroys frame so the program doesn't finish
      
      frame.setLayout(new BorderLayout());
      //label
      JPanel west = new JPanel(new GridLayout(12,1));
      west.add(name);
      west.add(familyName);
      west.add(phoneNum);
      west.add(email);
 

      
      frame.add(west,BorderLayout.WEST);
      cancel.addActionListener(this);
      submit.addActionListener(this);
      clear.addActionListener(this);
      
      
      JPanel center = new JPanel(new GridLayout(12,1));
      
      center.add(nameField);
      center.add(familyNameField);
      center.add(phoneNumField);
      center.add(emailField);   
      
      frame.add(center,BorderLayout.CENTER);
      
      JPanel south = new JPanel(new GridLayout(1,6));
      south.add(new JLabel());
      
      south.add(submit);
      south.add(cancel);
      south.add(clear);

      
      frame.add(south,BorderLayout.SOUTH);     
      
      frame.setVisible(true);
   
   }
   public void actionPerformed(ActionEvent event) 
   {
      if(event.getSource() == cancel)
      {
         frame.dispose();
      }
   
      if(event.getSource() == submit)
      {
        try
	{
	    ResultSet results =new dataBase().searchPerson(nameField.getText());
	    while (results.next())
	    {
		familyNameField.setText(results.getString("last_name"));
		phoneNumField.setText(results.getString("phone"));
		emailField.setText(results.getString("email"));
	    }
	} catch (SQLException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	  
           
      }      
      if(event.getSource() == clear) // resets text fields
      {
         
         nameField.setText(""); 
         familyNameField.setText("");
         phoneNumField.setText("");
         emailField.setText(""); 
      }
   }
}