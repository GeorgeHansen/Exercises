import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
      if(event.getSource() == makePayment)
      {
         PaymentGui pay = new PaymentGui();
      }
   
   
   }
}