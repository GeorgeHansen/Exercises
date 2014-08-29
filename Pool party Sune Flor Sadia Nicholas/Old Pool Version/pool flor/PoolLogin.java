import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoolLogin implements ActionListener
{
   //JLabels
   JLabel userName = new JLabel ("User Name:");
   JLabel password = new JLabel ("Password:");
   
   //Fields   
   JTextField userNameField = new JTextField(8);
   JPasswordField passwordField = new JPasswordField(8); //hides characters typed
   
   //Buttons
   JButton submit = new JButton("Submit");
   JButton guest = new JButton("Guest Login");
   
   //Panels   
   JPanel north = new JPanel(new GridLayout (4,2));
   JPanel south = new JPanel(new GridLayout(1,2));
   JFrame frame = new JFrame("Pool Party Login");

     
   
   public PoolLogin()
   {
      frame.setSize(250,155);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      frame.setResizable(false);
      
      frame.add(north, BorderLayout.NORTH);
      
      
      north.add(userName);
      north.add(userNameField);
      north.add(password);
      north.add(passwordField);
      
      frame.add(south);
      south.add(submit);
      south.add(guest);
      submit.addActionListener(this);
      guest.addActionListener(this); 
      
      frame.setVisible(true);
   
   }
   
   public void actionPerformed(ActionEvent event)
   {
      String userName = userNameField.getText();
      String pass = new String(passwordField.getPassword());
      
      if(event.getSource() == submit && userName.equals("admin") && pass.equals("admin")) //Admin or Chair window
      {
         AdminMain adMain = new AdminMain();
         frame.dispose(); //closes frame after opening admin  Window
      }
     /* else if(event.getSource() == submit && userName.equals("recept") && pass.equals("recept")) //Receptionist window
      {
         ReceptMain rcptMain = new ReceptMain();
         frame.dispose();
      }
      else if(event.getSource() == submit && userName.equals("treasure") && pass.equals("treasure"))//Treasurer window
      {
         TreasureMain treasureMain = new TreasureMain();
         frame.dispose();
      }
      else if(event.getSource() == submit && userName.equals("coach") && pass.equals("coach"))//coach window
      {
         CoachMain coachMain = new CoachMain();
         frame.dispose();
      }
      else if(event.getSource() == guest) //window for guest no login required
      {
         GuestMain guestMain = new GuestMain();
         frame.dispose();
      }*/
      
   
   }

   

}