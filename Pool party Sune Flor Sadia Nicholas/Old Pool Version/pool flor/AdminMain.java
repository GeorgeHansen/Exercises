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
   JButton saveMember = new JButton("Save Member List");
   
   
   JLabel memberList = new JLabel("Member List");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   
   MemberList member = new MemberList();
   
   
   public AdminMain()
   {
      
      member.readAllMembers();
      frame.setSize(600,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(6,1,0,5));
      infoBox.setEditable(true); 
      rightBox.add(addMember);
      rightBox.add(searchMember);
      rightBox.add(saveMember);
      
      
      frame.add(rightBox,BorderLayout.EAST);

      frame.add(infoBox, BorderLayout.CENTER);
      
      
      //Action Listeners
      searchMember.addActionListener(this);
      addMember.addActionListener(this); 
      saveMember.addActionListener(this);
      JScrollPane scrollPane = new JScrollPane(infoBox);
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      
      frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent event)
   {  
      if(event.getSource() == addMember){
         CreateMember createMem = new CreateMember(member);
      }
      if(event.getSource() == searchMember)
      {
         Search search = new Search(member);
      }
      if(event.getSource() == saveMember)
      {
         member.saveAllMembers();
         infoBox.setText("Memberlist saved");
      }
   }
}