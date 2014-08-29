import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddSwimTime implements ActionListener
{
   JFrame frame = new JFrame("Add Swimming Time");
   
   
   public AddSwimTime()
   {
      
      frame.setSize(200,150);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      
      //label
      JPanel west = new JPanel(new GridLayout(2,1));
      west.add(new JLabel(" Style"));
      west.add(new JLabel(" Time"));
      
      frame.add(west,BorderLayout.WEST);
      
      JPanel north = new JPanel(new GridLayout(2,1));
      north.add(new JTextField(10));
      north.add(new JTextField(10));
      
      JPanel panel = new JPanel();
      panel.add(west);
      panel.add(north);
      
      frame.add(panel,BorderLayout.NORTH);
      
      frame.setVisible(true);
   }
   public void actionPerformed(ActionEvent event)
   {
     //  if(event.getSource() == cancel)
//       {
//          frame.dispose();
//       }
   }

}