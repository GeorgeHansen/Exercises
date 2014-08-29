import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Search implements ActionListener
{
  
   JFrame frame = new JFrame("Search");
   JLabel name = new JLabel (" Name");
   JLabel id = new JLabel(" ID");
   JLabel address = new JLabel(" Address");
   JLabel email = new JLabel(" e-mail");
   JLabel pasActive = new JLabel("Check for Active");
   JLabel eliteEx = new JLabel("Check for Elite");

   
   JLabel phoneNum = new JLabel(" Phone Number");
   JCheckBox passive = new JCheckBox();
   JCheckBox standard = new JCheckBox();
   
   
   JTextField nameField = new JTextField (8);
   JTextField idField = new JTextField(8);
   JTextField addressField = new JTextField(8);
   JTextField emailField = new JTextField(8);
   
   JTextField phoneNumField = new JTextField(8);
   
   
   JButton search = new JButton("search");
   JButton cancel = new JButton("Cancel");

   
   
   public Search()
   {
      frame.setSize(400,500);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      //label
      JPanel west = new JPanel(new GridLayout(12,1));
      west.add(name);
      west.add(id);
      west.add(address);
      west.add(phoneNum);
      west.add(email);
      west.add(passive);
      west.add(standard);
      west.add(pasActive);
      west.add(eliteEx);

     
      frame.add(west,BorderLayout.WEST);
      
      JPanel center = new JPanel(new GridLayout(12,1));
      center.add(nameField);
      center.add(idField);
      center.add(addressField);
      center.add(emailField);
      center.add(phoneNumField);
      center.add(passive);
      center.add(standard);
      
      
      cancel.addActionListener(this);
      frame.add(center,BorderLayout.CENTER);
      
      JPanel south = new JPanel(new GridLayout(1,4));
      south.add(new JLabel());
      south.add(new JLabel());
      south.add(search);
      south.add(cancel);
      
      frame.add(south,BorderLayout.SOUTH);
      
      
      frame.setVisible(true);
   } 
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == cancel)
      {
         frame.dispose();
      }
   }

   



}
