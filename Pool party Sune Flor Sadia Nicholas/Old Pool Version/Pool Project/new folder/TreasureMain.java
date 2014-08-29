import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TreasureMain implements ActionListener
{

   //Panels/Frame
   JFrame frame = new JFrame("Pool Party  Treasurer Login");
   JPanel rightBox = new JPanel();
   
   
   JTextArea infoBox = new JTextArea(5,20); // Text Area
   
   
   //JButtons
   JButton paymentInfo = new JButton("Payment Info");
   JButton searchMember = new JButton("Search Member");
   JButton viewSwimTimes = new JButton("View SwimTimes");
   
   //JLabels
   JLabel memberList = new JLabel("Member List");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   
   
   public TreasureMain()
   {
      frame.setSize(600,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(6,1,0,5)); //the 0 and 5 is the horizontal and vertical spacing between buttons.
      
      
      infoBox.setEditable(true); //set to false and you wont be able to enter data into the infobox
      rightBox.add(paymentInfo);
      rightBox.add(viewSwimTimes);
      rightBox.add(searchMember);
      
      
      frame.add(rightBox,BorderLayout.EAST);
      
       
      frame.add(infoBox, BorderLayout.CENTER);
      
      
      JScrollPane scrollPane = new JScrollPane(infoBox); //adds a scroll bar that becomes visible when there is too much info
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      
      //Action Listners
      searchMember.addActionListener(this);
      paymentInfo.addActionListener(this);
      viewSwimTimes.addActionListener(this);
      frame.setVisible(true);
   
   }
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == searchMember)
      {
         Search search = new Search();
      }
      else if(event.getSource() == paymentInfo)
      {
         PaymentInfo pi = new PaymentInfo();
      }
      else if(event.getSource() == viewSwimTimes)
      {
         View view = new View();
      }


      
   }
      
}