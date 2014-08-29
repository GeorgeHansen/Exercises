import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class makePayment
{
   JFrame frame = new JFrame("Make Payment");
   JPanel north = new JPanel(new BorderLayout());
   
   JLabel name = new JLabel("name");
   JLabel id = new JLabel("ID");
   JLabel longInfo = new JLabel("blaaa      blaaa     blaaaa    blaaa");
   
   JTextField nameField = new JTextField(8);
   JTextField idField = new JTextField(8);
   
   JTextField longInfoField = new JTextField();
   
   JButton search = new JButton("search");
   JButton pay = new JButton("pay");
   
   
   
   public makePayment()
   {
      frame.setSize(400,250);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      
      frame.add(north, BorderLayout.NORTH);
      
      
      
      
      
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