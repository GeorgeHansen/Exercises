package test;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class MainMenu implements ActionListener
{
   JFrame frame = new JFrame("Pool Party  Chair Administration");
   JTextArea infoBox = new JTextArea(5,20);
   
   
   JPanel rightBox = new JPanel();
   JButton addMember = new JButton("Create Member");
   JButton searchMember = new JButton("Search Member");
   
   
   JLabel memberList = new JLabel("Member List");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   ArrayList<String> printCust = new ArrayList<String>();
   
   
   
   
   public MainMenu() throws SQLException
   {
      readArray();
      setText();
      frame.setSize(600,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(8,1,0,5));
      infoBox.setEditable(true); 
      rightBox.add(addMember);
      rightBox.add(searchMember);
        
      
      
      frame.add(rightBox,BorderLayout.EAST);
   
      frame.add(infoBox, BorderLayout.CENTER);
      
      
      //Action Listeners
      searchMember.addActionListener(this);
      addMember.addActionListener(this); 
      
      

      
      JScrollPane scrollPane = new JScrollPane(infoBox);
      
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      
      frame.setVisible(true);
      

   }
   public void readArray() throws SQLException 
   {
       dataBase db = new dataBase();
       
       for(Customer c: db.displayEveryone())
       {
	   String name = c.getFname();
	   String lname = c.getLname();
	   String phone = Integer.toString(c.getPhoneNo());
	   String email = c.getEmail();
	   
	   printCust.add(name + " "+ lname + " " + phone + " " + email);
       }
   }
   public void setText()
   {
       for (int i = 0;i< printCust.size();i++)
       {
          infoBox.append(printCust.get(i)+"\n");
       }
   }
   public void actionPerformed(ActionEvent event)
   {  
      if(event.getSource() == addMember)
      {
         new AddPerson();
         
      }
      if(event.getSource() == searchMember)
      {
         new Search();
         
      }
   }
}