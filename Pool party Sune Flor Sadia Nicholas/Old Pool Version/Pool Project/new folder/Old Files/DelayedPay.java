import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DelayedPay implements ActionListener
{
    JFrame frame = new JFrame("Delayed Pay");
    
    
   
   public DelayedPay()
   {
     
      frame.setSize(500,350);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      
      JPanel north = new JPanel(new GridLayout(1,2));
      north.add(new JLabel(" Name"));
      north.add(new JLabel(" Payment Due"));
      
      frame.add(north,BorderLayout.NORTH);
      
      JPanel area = new JPanel(new FlowLayout());
      area.add(new JTextArea(15,40));
      
      frame.add(area,BorderLayout.CENTER);
      frame.add(new JScrollPane(area));           
      frame.setVisible(true);
   
   }
   public void actionPerformed(ActionEvent event)
   {
   
   }
}