import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    
    
   
   public PaymentGui()
   {
     
      frame.setSize(400,175);
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
      
      search.addActionListener(this);
      
      frame.add(south, BorderLayout.SOUTH);
   
      
     
      
      //frame.pack();
      frame.setVisible(true);
   }
   public void actionPerformed(ActionEvent event)
   {
       if(event.getSource() == search)
       {
         MemberList memberList = new MemberList();
         memberList.searchMember();
       }
   }

}