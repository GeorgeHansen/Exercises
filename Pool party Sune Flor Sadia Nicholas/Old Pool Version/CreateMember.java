import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class CreateMember implements ActionListener
{
   MemberList member = new MemberList();     
   public int mem;

   JFrame frame = new JFrame("Add Members"); 
    
   //JLabel memberID = new JLabel (" Member ID");
   JLabel name = new JLabel (" Name");
   JLabel birthDay = new JLabel("Date of Birth"); 
   JLabel address = new JLabel(" Address");
   JLabel email = new JLabel(" e-mail");  
   JLabel phoneNum = new JLabel(" Phone Number");
   JLabel active = new JLabel("Active Member");   
   JLabel elite = new JLabel("Elite Member");   
   JLabel coach = new JLabel("Coach");  
   JLabel team = new JLabel("Team");  
   
   
   //JTextField memberIDField = new JTextField (8);
   JTextField nameField = new JTextField (8);
   JTextField birthdayField = new JTextField(8);
   JTextField addressField = new JTextField(8);
   JTextField emailField = new JTextField(8);
   JTextField phoneNumField = new JTextField(8);
   JTextField coachField = new JTextField(8);
   JTextField teamField = new JTextField(8);
   
    
   
   
   JCheckBox activeBox = new JCheckBox(); //Click for Active 
   JCheckBox eliteBox = new JCheckBox(); //Click for Elite 
   
   JButton submit = new JButton("Submit");
   JButton cancel = new JButton("Cancel");
   JButton clear = new JButton("Clear");
   JButton print = new JButton("Print");
   

   
   
   public CreateMember(MemberList member)
   {
      this.member = member;
      frame.setSize(400,500);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); //destroys frame so the program doesn't finish
      
      frame.setLayout(new BorderLayout());
      //label
      JPanel west = new JPanel(new GridLayout(12,1));
            west.add(name);
      west.add(birthDay);
      west.add(address);
      west.add(phoneNum);
      west.add(email);
      west.add(active);
      west.add(elite);
      west.add(coach);
      west.add(team);
      
      frame.add(west,BorderLayout.WEST);
      cancel.addActionListener(this);
      submit.addActionListener(this);
      clear.addActionListener(this);
      print.addActionListener(this);
      
      JPanel center = new JPanel(new GridLayout(12,1));
      
      center.add(nameField);
      center.add(birthdayField);
      center.add(addressField);
      center.add(phoneNumField);
      center.add(emailField);    
      center.add(activeBox);
      center.add(eliteBox);
      center.add(coachField);
      center.add(teamField);
      
      
      
      frame.add(center,BorderLayout.CENTER);
      
      JPanel south = new JPanel(new GridLayout(1,6));
      south.add(new JLabel());
      
      south.add(submit);
      south.add(cancel);
      south.add(clear);
      south.add(print);
      
      frame.add(south,BorderLayout.SOUTH);     
      
      frame.setVisible(true);
   
      
   }
   public void actionPerformed(ActionEvent event) 
   {
      if(event.getSource() == cancel)
      {
         frame.dispose();
      }
   
      if(event.getSource() == submit){
        
         if (eliteBox.isSelected()){//creation of elite member
         member.createNewMember(nameField.getText(),birthdayField.getText(),addressField.getText(), Integer.parseInt(phoneNumField.getText()),emailField.getText(),true,coachField.getText(),teamField.getText());
         }
         else{ // create of regular member
         member.createNewMember(nameField.getText(),birthdayField.getText(),addressField.getText(), Integer.parseInt(phoneNumField.getText()),emailField.getText(),true);
         }
           
      }      
      if(event.getSource() == clear) // resets text fields
      {
         
         nameField.setText(""); 
         birthdayField.setText("");
         addressField.setText("");
         phoneNumField.setText("");
         emailField.setText(""); 
      }
      if(event.getSource() == print) //testing method, prints to console
      {
         member.printAllMembers();
      } 
   }
} 
