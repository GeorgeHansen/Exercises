import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View
{
   JFrame frame = new JFrame("View Swimming Times");
   public View()
   {
      
      frame.setSize(400,300);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      
      JPanel area = new JPanel(new GridLayout(1,1));
      area.add(new JTextArea(15,25));
      
      frame.add(area,BorderLayout.WEST);
      //frame.add(new JScrollPane(area));
      
      JPanel east = new JPanel(new GridLayout(5,1));
      east.add(new JButton("Free"));
      east.add(new JButton("Breast"));
      east.add(new JButton("Back"));
      east.add(new JButton("Butterfly"));
      //east.add(new JButton("Search"));
      
      frame.add(east,BorderLayout.CENTER);
      
      JPanel south = new JPanel(new GridLayout(1,2));
      south.add(new JLabel());
      south.add(new JLabel());
      south.add(new JButton("Junior"));
      //south.add(new JLabel());
      south.add(new JButton("Senior"));
      //south.add(new JLabel());
   
      
      frame.add(south,BorderLayout.SOUTH);
   
      
      
      
      frame.setVisible(true);
   }
}