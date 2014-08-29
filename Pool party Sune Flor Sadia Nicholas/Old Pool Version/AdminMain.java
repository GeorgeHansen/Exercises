import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMain implements ActionListener
{
   JFrame frame = new JFrame("Pool Party  Chair Administration");
   JTextArea infoBox = new JTextArea(5,20);
   
   
   JPanel rightBox = new JPanel();
   JButton addMember = new JButton("Create Member");
   JButton searchMember = new JButton("Search Member");
   JButton saveMember = new JButton("Save members to File");
   JButton paymentInfo = new JButton("Payment Info");
   JButton searchSwim = new JButton("Search Swimmer");
   JButton viewSwimResult = new JButton("View Swim Results");
   JButton submitSwimTime = new JButton("Submit Swim Times");
   JButton updateMember = new JButton("Update Member");   
   
   JLabel memberList = new JLabel("Member List");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   
   MemberList member = new MemberList();
   
   
   public AdminMain()
   {
      
      member.readAllMembers();
      frame.setSize(600,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(8,1,0,5));
      infoBox.setEditable(true); //will be set to false in the full version 
      rightBox.add(addMember);
      rightBox.add(searchMember);
      rightBox.add(saveMember);
      rightBox.add(updateMember);
      rightBox.add(paymentInfo);
      rightBox.add(searchSwim);
      rightBox.add(viewSwimResult);
      rightBox.add(submitSwimTime);
      
      
      
      frame.add(rightBox,BorderLayout.EAST);
   
      frame.add(infoBox, BorderLayout.CENTER);
      
      
      //Action Listeners
      searchMember.addActionListener(this);
      addMember.addActionListener(this); 
      saveMember.addActionListener(this);
      updateMember.addActionListener(this);
      paymentInfo.addActionListener(this);
      searchSwim.addActionListener(this);
      viewSwimResult.addActionListener(this);
      submitSwimTime.addActionListener(this);
      
      JScrollPane scrollPane = new JScrollPane(infoBox);
      
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      
      frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent event)
   {  
      if(event.getSource() == addMember)
      {
         CreateMember createMem = new CreateMember(member);
      }
      if(event.getSource() == searchMember)
      {
         Search search = new Search(member);
      }
      if(event.getSource() == updateMember)
      {
         infoBox.setText("Not Functioning");
      }
      if(event.getSource() == saveMember)
      {
         member.saveAllMembers();
         infoBox.setText("Memberlist saved");
      }
      if(event.getSource() == paymentInfo)
      {
         PaymentInfo payInfo = new PaymentInfo();
      }
      if(event.getSource() == searchSwim)
      {
         SearchSwimmer searchSwim = new SearchSwimmer();
      }
      if(event.getSource() == viewSwimResult)
      {
         View swimResult = new View();
      }
      if(event.getSource() == submitSwimTime)
      {
         SubmitSwimTime sst = new SubmitSwimTime();
      }
      
   }
}
   
