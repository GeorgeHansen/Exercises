import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class SubmitSwimTime implements ActionListener
{
   MemberList member = new MemberList();     
   public int mem;

   JFrame frame = new JFrame("Add Swim Times"); 
    
   
   JLabel id = new JLabel (" Member ID");
   JLabel swimTime = new JLabel("Swim Time"); 
   JLabel raceName = new JLabel(" Race Name");
   JLabel discipline = new JLabel(" Discipline");  
    
   
   
   //JTextField memberIDField = new JTextField (8);
   JTextField idField = new JTextField (8);
   JTextField swimTimeField = new JTextField(8);
   JTextField raceNameField = new JTextField(8);
   
   
   //change to drop down
   JComboBox<String> disciplineBox;
      
    
   
   
   
   JButton submit = new JButton("Submit");
   JButton cancel = new JButton("Cancel");
   JButton clear = new JButton("Clear");
   
   

   
   
   public SubmitSwimTime()
   {
      this.member = member;
      frame.setSize(400,300);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      //label
      JPanel west = new JPanel(new GridLayout(5,1));
      //west.add(memberID);
      west.add(id);
      west.add(swimTime);
      west.add(raceName);
      west.add(discipline);
           
      frame.add(west,BorderLayout.WEST);
      cancel.addActionListener(this);
      submit.addActionListener(this);
      clear.addActionListener(this);
     
      
      JPanel center = new JPanel(new GridLayout(5,1));
      
      String[] disciplines = { "Butterfly", "BackStroke", "Freestyle", "BreastStroke", };
      disciplineBox = new JComboBox<String>(disciplines);
      center.add(idField);
      center.add(swimTimeField);
      center.add(raceNameField);
      center.add(disciplineBox);
           
      


      
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
         
        //Non Functional           
      }      
      if(event.getSource() == clear)
      {
         idField.setText("");
         swimTimeField.setText("");
         raceNameField.setText("");   
      }
     }
} 
