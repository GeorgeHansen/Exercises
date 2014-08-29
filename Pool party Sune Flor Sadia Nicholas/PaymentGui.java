import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class PaymentGui implements ActionListener
{
   private int idd;
   String birthDate;
   
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
   
   //searches member arraylist for the name or id entered
   public void searchMem()
   {
      // 
//       try
//       {
         list.readAllMembers();
         
         for(Member m : list.memberList)
         {
            
            if (textId.getText().equals(Integer.toString(m.getMemberID())) || textName.getText().equalsIgnoreCase(m.getName()))
            {
               area.setText(m.getName() + "\t  " + m.getAddress()+ "\t  " + m.getBirthDate() + m.getMemberID());
               String id = Integer.toString(m.getMemberID());
               godsHandList.add(0,id);
               godsHandList.add(1,m.getBirthDate());
               //System.out.println(m.getBirthDate());
               //email and phone seem to be mixed up
            }
            else
            {
               //System.out.print("goop");
            }
         }
      //}
     //  catch (FileNotFoundException e)
//       {
//          System.out.println("search Mem error");
//       }
   }
   
   //searches elite arraylist for the name or id entered
   public void searchElite()
   {
   //    try
//       {
         list.readAllMembers();
         for(Elite e: list.eliteList)
         {
            if (textId.getText().equals(Integer.toString(e.getMemberID())) || textName.getText().equalsIgnoreCase(e.getName()))
            {  
               area.setText(e.getName() + " " + e.getAddress() + " " + e.getBirthDate() + e.getMemberID());
               String id = Integer.toString(e.getMemberID());
               godsHandList.add(0,id);
               godsHandList.add(1,e.getBirthDate());
               //System.out.println(e.getBirthDate());
               
            }
            else
            {
               //System.out.print("ummpaloompa");
            }
         }  
      // }
//       catch (FileNotFoundException e)
//       {
//          System.out.println("poop");
//       }
//       
   }            
   //adds elite payment to arraylist        
   public void payElite(ArrayList<String> godsHandList, Payment paymentList)
   {  
            idd = Integer.parseInt(godsHandList.get(0));
            birthDate = godsHandList.get(1);
            //System.out.println(birthDate);   
                  Elite e = new Elite();           
                  Payment p = new Payment(idd, birthDate);  
                  p.fee(e);
                  p.hasPayed();
                  p.pay();
                  payList.addPayment(p);
                        
   }
   
   //adds member payment to arraylist
   public void payMember(ArrayList<String> godsHandList, Payment paymentList)
   {
            birthDate = godsHandList.get(1);
            idd = Integer.parseInt(godsHandList.get(0));
            //System.out.println(birthDate);                       
                  Member m = new Member();            
                  Payment g = new Payment(idd, birthDate);  
                  g.fee(m);
                  g.hasPayed();
                  g.pay();
                  payList.addPayment(g);
      
   }
     
   
   //actions preformed on button click
   public void actionPerformed(ActionEvent event)
   {
      Payment paymentList = new Payment();
   
      if (event.getSource() == search)
      {
         searchMem();
         searchElite();        
      }
      
      else if(event.getSource() == pay)
      {
         try
         {
            paymentList.loadPayments(paymentList);
         }
         catch(FileNotFoundException e) 
            {
              System.out.println("alskdjasdklj");
            }
         int ppp = 0;
         for(Elite e: list.eliteList)
         {
            if (godsHandList.get(0).equals(Integer.toString(e.getMemberID())))
            {  
               ppp = 2;
            }
            else
            {
               

            }
         }
         for(Member m: list.memberList)
         {
            if (godsHandList.get(0).equals(Integer.toString(m.getMemberID())))
            {  
               ppp = 1; 
            }
            else
            {
               
               
            }
         }
         if(ppp == 1) 
         {
            payMember(godsHandList, payList);
         }
         else if(ppp == 2)
         {
            payElite(godsHandList, payList);
         }
         else
         {                      
            System.out.println("poop");
         }
         try
         {
            payList.savePayments();
         }
         catch(FileNotFoundException e) 
            {
              System.out.println("alskdjasdklj");
            }
            
      }
       
   }
}
       
  
  
  
  

