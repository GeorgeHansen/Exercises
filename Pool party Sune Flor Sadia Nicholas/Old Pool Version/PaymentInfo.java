import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class PaymentInfo implements ActionListener
{
   JFrame frame = new JFrame("Payment info");
   JTextArea area = new JTextArea(15,40);
   
   JPanel north = new JPanel();
   JLabel name = new JLabel("Name");
   JLabel id = new JLabel("ID");
   JLabel paymentStatus = new JLabel("Payment Status");
   JLabel empty = new JLabel();
   
    
   JPanel east = new JPanel();
   JButton delayedPay = new JButton(" DelayedPay");
   JButton makePayment =new JButton(" Make Payment");  

    
    
   
   public PaymentInfo()
   {
     
      frame.setSize(500,350);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      
      north.setLayout(new GridLayout(1,4));
      area.setEditable(true); 
      north.add(name);
      north.add(id); 
      north.add(paymentStatus);
      north.add(empty);
      
      frame.add(north,BorderLayout.NORTH);
      
      frame.add(area, BorderLayout.CENTER);
      
      east.setLayout(new GridLayout(8,1));
      east.add(delayedPay);
      east.add(makePayment);
      
      frame.add(east, BorderLayout.EAST);
            
      JScrollPane scrollPane = new JScrollPane(area);
      frame.add(scrollPane);
      
      //Action Listeners
      delayedPay.addActionListener(this);
      makePayment.addActionListener(this);
      
                
      frame.setVisible(true);
   
   }
   
   public void actionPerformed(ActionEvent event)
   {
      ArrayList<String> payDelay = new ArrayList<String>();
      if(event.getSource() == makePayment)
      {
         PaymentGui pay = new PaymentGui();
      }
      //small program that shows who has paid or not, but only a demo
      if(event.getSource() == delayedPay)
      {
      
         Payment p = new Payment();
         try
         {
            p.loadPayments(p);
         }
         catch(FileNotFoundException e)
         {
            System.out.println("error");
         }
         int o = 1;
         for(Payment pa : p.paymentList)
         {
            boolean b = Boolean.parseBoolean(p.hasPayed());
            if(b == true && !pa.getID().equals("null"))
            {
               payDelay.add("ID:                                    " + o + "                                       has payed");  
               //area.setText("ID:" + p.getID() + "has payed");
            }
            else if(b == true && !pa.getID().equals("null"))
            {
               payDelay.add("ID:                                    " + o + "                                       not payed");
               //area.setText("ID:" + p.getID() + "not payed");
            }
            o++;
         }
      
         //System.out.println("Print all Payments: " + payDelay.size());
         for (int i = 0;i< payDelay.size();i++)
         {
            //area.add(payDelay.get(i));
           // area.setPrefRowCount(payDelay.size());            
            area.append(payDelay.get(i)+"\n");
         }

      }

   
   }
}