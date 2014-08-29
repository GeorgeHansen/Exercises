import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Add implements ActionListener 

{
   
   public int mem;
   MemberID memID = new MemberID(); //creates the class for adding Member IDs
   //send counter number to file and load everytime used.
   JFrame frame = new JFrame("Add");
   
   JLabel name = new JLabel (" Name");
   JLabel birthDay = new JLabel("Date of Birth"); 
   JLabel address = new JLabel(" Address");
   JLabel email = new JLabel(" e-mail");
   
   JLabel phoneNum = new JLabel(" Phone Number");
   
   JLabel eliteEx = new JLabel("Check for Elite");
   
   
   
   JTextField nameField = new JTextField (8);
   JTextField birthdayField = new JTextField(8);
   JTextField idField = new JTextField(8);
   JTextField addressField = new JTextField(8);
   JTextField emailField = new JTextField(8);
   JTextField phoneNumField = new JTextField(8);
   
    
   
   
   JCheckBox standard = new JCheckBox(); //change to standard basic 
   
   JButton add = new JButton("Add");
   JButton cancel = new JButton("Cancel");

   
   
   public Add() 
   {
      
      frame.setSize(400,300);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      //label
      JPanel west = new JPanel(new GridLayout(8,1));
      west.add(name);
      west.add(birthDay);
      west.add(address);
      west.add(phoneNum);
      west.add(email);
      west.add(eliteEx);
      
      frame.add(west,BorderLayout.WEST);
      cancel.addActionListener(this);
      
      JPanel center = new JPanel(new GridLayout(8,1));
      center.add(nameField);
      center.add(birthdayField);
      center.add(addressField);
      center.add(emailField);
      
      center.add(phoneNumField);
      
      center.add(standard);
      
      
      add.addActionListener(this);
      standard.addActionListener(this);
      frame.add(center,BorderLayout.CENTER);
      
      JPanel south = new JPanel(new GridLayout(1,4));
      south.add(new JLabel());
      south.add(new JLabel());
      south.add(add);
      south.add(cancel);
      
      frame.add(south,BorderLayout.SOUTH);     
      
      frame.setVisible(true);
   
      
   }
   public void actionPerformed(ActionEvent event) 
      {
      MemberList memberList = new MemberList();
      MemberList eliteList = new MemberList();
      MemberList allMemberList = new MemberList();
     
      if(event.getSource() == cancel)
      {
         frame.dispose();
        
      }
      else if(event.getSource() == add) 
      {
         try //loads members from files and add them to arrayLists
         {       
            if(!standard.isSelected())
            {
               memberList.readMembers();             
            }
            else if(standard.isSelected())
            {
               eliteList.readElite();
            }
            allMemberList.readAllMembers();
            
         }
         catch(FileNotFoundException e) //can't seem to be able to throw an exception here. Try, Catch solves problem
         {
            System.out.println("problem");
         }
      
         
         if(!standard.isSelected()) //Not selected will give you basic member
         {
            try
            {
               memID.loadID(); //loads the Member ID file. Allows us to continue counting
            }
            catch(FileNotFoundException e)
            {
                System.out.println("problem");
            }
            mem = memID.assignMemberID();
            Member member = new Member(nameField.getText(), birthdayField.getText() ,addressField.getText(), phoneNumField.getText(), emailField.getText(), Integer.toString(mem));
            //Member member2 = member;
            memberList.createNewMember(member); //adds to arraylist in Member class
            allMemberList.createNewMemberAll(member);
            
            
              try
            {
               memID.saveID(); // saves the last recorded member ID. 
            }
            catch(FileNotFoundException e)
            {
               System.out.println("problem");
            }

            
           
         }
         else if(standard.isSelected())//Selected gives you elite Member
         { 
             try
            {
               memID.loadID();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("problem");
            } 
            mem = memID.assignMemberID();
            Elite elite = new Elite(nameField.getText(),birthdayField.getText(), addressField.getText(), phoneNumField.getText(), emailField.getText(), Integer.toString(mem));
            Member member = new Member(nameField.getText(),birthdayField.getText(), addressField.getText(), phoneNumField.getText(), emailField.getText(), Integer.toString(mem));
            eliteList.createNewElite(elite); //adds to arrayList of elite
            allMemberList.createNewMemberAll(member);
            
              try
            {
               memID.saveID();
            }
            catch(FileNotFoundException e)
            {
               System.out.println("problem");
            }
               
            
         }
         
         try //saves all the members created into text files
         {
            if(!standard.isSelected())
            {
               memberList.saveMembers();
            }
            else if(standard.isSelected())
            {
               eliteList.saveElite();
            } 
            allMemberList.saveAllMembers();    
         }
         catch(FileNotFoundException e)
         {
            System.out.println("big problem");
         }
          
         //clears fields so we can enter new data                 
         nameField.setText(""); 
         birthdayField.setText("");
         addressField.setText("");
         phoneNumField.setText("");
         emailField.setText("");
         
         //prompt confirmation box to be added
        
         
      }
   }

}