import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class PaymentGui implements ActionListener
{
   JFrame frame = new JFrame("Payment");
   JTextField area = new JTextField(10);
    
   JPanel west = new JPanel();
   JLabel nameField = new JLabel(" Name");
   JLabel idField = new JLabel(" id");
    
   JPanel north = new JPanel();
   JTextField textName = new JTextField(8);
   JTextField textId = new JTextField(8);
     
   JPanel east = new JPanel();
   JButton search = new JButton("Search");
   JLabel empty = new JLabel();
       
   JPanel center = new JPanel();
   JLabel name = new JLabel("Name");
   JLabel address = new JLabel("Address");
   JLabel phoneNumber = new JLabel("Phone");
   JLabel email = new JLabel("E-mail");
   
   JPanel south = new JPanel();
   JButton pay = new JButton("Pay");
   //JLabel empty = new JLabel();
    
   MemberList list = new MemberList();
   Payment payList = new Payment();
   ArrayList<String> godsHandList = new ArrayList<String>();
   
   
   
   public PaymentGui()
   {
     
      frame.setSize(600,175);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      
      west.setLayout(new GridLayout(2,1));
      west.add(nameField);
      west.add(idField);
            
      frame.add(west,BorderLayout.WEST);
      
      
      north.setLayout(new GridLayout(2,1));
      north.add(textName);
      north.add(textId);
   
      frame.add(north,BorderLayout.NORTH);
      
      east.setLayout(new FlowLayout());
      east.add(search);
      east.add(empty);
      
      frame.add(east,BorderLayout.EAST);
   
      
      JPanel panel = new JPanel();
      panel.add(west);
      panel.add(north);
      panel.add(east);
      
      frame.add(panel,BorderLayout.NORTH);
      
           
      center.setLayout(new GridLayout(1,4));
      area.setEditable(true); 
      center.add(name);
      center.add(address); 
      center.add(phoneNumber);
      center.add(email);
      
    
      
      frame.add(center,BorderLayout.CENTER);
      
      frame.add(area, BorderLayout.SOUTH);
      
      JPanel epanel = new JPanel(new BorderLayout());
      epanel.add(center, BorderLayout.NORTH);
      epanel.add(area, BorderLayout.SOUTH);
      
      frame.add(epanel, BorderLayout.CENTER);
      
      south.setLayout(new FlowLayout());
      south.add(pay);
      
      frame.add(south, BorderLayout.SOUTH);
   
      search.addActionListener(this);
      pay.addActionListener(this);
      
          
       
     
      
      frame.setVisible(true);
   
   }
   public void searchMem()
   {
      
      try
      {
         list.readMembers();
         
         for(Member m : list.memberList)
         {
            
            if (textId.getText().equals(m.getId()) || textName.getText().equalsIgnoreCase(m.getName()))
            {
               area.setText(m.getName() + "\t  " + m.getAddress()+ "\t  " + m.getBirthDate() + m.getId());
              
               godsHandList.add(0,m.getId());
               godsHandList.add(1,m.getBirthDate());
               System.out.println(m.getBirthDate());
               //email and phone seem to be mixed up
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("search Mem error");
      }
   }
   public void searchElite()
   {
      try
      {
         list.readMembers();
         list.loadElite();
         for(Elite e: list.eliteList)
         {
            if (textId.getText().equals(e.getId()) || textName.getText().equalsIgnoreCase(e.getName()))
            {  
               area.setText(e.getName() + " " + e.getAddress() + " " + e.getEmail() + e.getPhoneNo());
            }
         }  
      }
      catch (FileNotFoundException e)
      {
         System.out.println("poop");
      }
      
   }            
           
   public void payElite()
   {  
              
   }
   public void payMember(ArrayList<String> godsHandList)
   {
            
      for(Member m: list.memberList)
      {
         if (textId.getText().equals(m.getId()))
         {
            String birthDate = m.getBirthDate();
            int id = Integer.parseInt(godsHandList.get(0));
                
               
               
            Payment payment = new Payment(id, birthDate);
            
            try{
               payment.readpayment(); //load from File 
               payment.addPayment(payment); //add to Payment Arraylist
               payment.savePayments();  //save to file
               //System.out.println(payment.paymentList.get(1));
               }
            catch(FileNotFoundException e) 
            {
              System.out.println("alskdjasdklj");
            }            
          //prompt verification     
         }
         else
         {
            System.out.println("just passing through");
         }
               
      }
   }
     
   
   
   public void actionPerformed(ActionEvent event)
   {
      if (event.getSource() == search)
      {
         searchMem();
         searchElite();        
      }
      
      else if(event.getSource() == pay)
      {
         
         payMember(godsHandList);                      
         System.out.println("poop");
      }
   
       
   
       
       
   }
}
       
  
  
  
  

