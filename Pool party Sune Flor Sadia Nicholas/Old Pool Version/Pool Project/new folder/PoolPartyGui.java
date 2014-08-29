import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoolPartyGui implements ActionListener
{
   JFrame frame = new JFrame("Pool Party Administration");
   JTextArea infoBox = new JTextArea();
   JPanel rightBox = new JPanel();
   JButton addMember = new JButton("add Member");
   JButton searchMember = new JButton("Search Member");
   JButton viewResults = new JButton("View Results");


   
   public PoolPartyGui()
   {
      frame.setSize(500,350);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new BoxLayout(rightBox, BoxLayout.PAGE_AXIS));
            
      rightBox.add(addMember);
      rightBox.add(searchMember);
      rightBox.add(viewResults);
      
      frame.add(rightBox,BorderLayout.EAST);
       
      frame.add(infoBox, BorderLayout.CENTER);
      
      
      frame.setVisible(true);

   }
   public void actionPerformed(ActionEvent event)
   {
      //empty for now
   }
}