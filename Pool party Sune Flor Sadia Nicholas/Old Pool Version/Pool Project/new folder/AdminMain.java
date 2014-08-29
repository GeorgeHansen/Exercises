import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMain implements ActionListener
{
   JFrame frame = new JFrame("Pool Party  Chair Administration");
   JTextArea infoBox = new JTextArea(5,20);
   
   
   JPanel rightBox = new JPanel();
   JButton addMember = new JButton("Add Member");
   JButton searchMember = new JButton("Search Member");
   JButton paymentInfo = new JButton("Payment Info");
   JButton viewSwimTimes = new JButton("View SwimTimes");
   JButton searchSwimmer = new JButton("Search Swimmer");
   
   JLabel memberList = new JLabel("Member List");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   
   
   public AdminMain()
   {
      frame.setSize(600,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(6,1,0,5));
      infoBox.setEditable(true); 
      rightBox.add(addMember);
      rightBox.add(searchMember);
      rightBox.add(paymentInfo);
      rightBox.add(searchSwimmer);
      rightBox.add(viewSwimTimes);
      
      
      frame.add(rightBox,BorderLayout.EAST);
      
       
      frame.add(infoBox, BorderLayout.CENTER);
      
      
      //Action Listeners
      searchMember.addActionListener(this);
      paymentInfo.addActionListener(this);
      addMember.addActionListener(this);
      searchSwimmer.addActionListener(this);
      viewSwimTimes.addActionListener(this);
      
      JScrollPane scrollPane = new JScrollPane(infoBox);
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      
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
      else if(event.getSource() == addMember)
      {
         Add add = new Add();
      }
      else if(event.getSource() == searchSwimmer)
      {
         SearchSwimmer searchSwim = new SearchSwimmer();         
      }
      else if(event.getSource() == viewSwimTimes)
      {
         View view = new View();
      }
   }
}