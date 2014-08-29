import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReceptMain implements ActionListener
{
   
   JFrame frame = new JFrame("Pool Party  Receptionist Login");
   JTextArea infoBox = new JTextArea(5,20);
   
   
   JPanel rightBox = new JPanel();
   JButton addMember = new JButton("Add Member");
   JButton searchMember = new JButton("Search Member");
   JButton searchSwimmer = new JButton("Search Swimmer");
   
   JButton viewSwimTimes = new JButton("View SwimTimes");
   
   JLabel memberList = new JLabel("Member List");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   
   
   public ReceptMain()
   {
      
      frame.setSize(600,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(6,1,0,5));
      //rightBox.setLayout(new BoxLayout(rightBox, BoxLayout.PAGE_AXIS));
      infoBox.setEditable(true); 
      rightBox.add(addMember);
      rightBox.add(searchMember);
      rightBox.add(searchSwimmer);
      
      rightBox.add(viewSwimTimes);
      
      
      frame.add(rightBox,BorderLayout.EAST);
      
       
      frame.add(infoBox, BorderLayout.CENTER);
      
      
      JScrollPane scrollPane = new JScrollPane(infoBox);
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      searchMember.addActionListener(this);
      addMember.addActionListener(this);
      viewSwimTimes.addActionListener(this);
      searchSwimmer.addActionListener(this);
   
      
      frame.setVisible(true);
   
   }
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == searchMember)
      {
         Search search = new Search();
      }
      else if(event.getSource() == addMember)
      {
         Add add = new Add();
      }
      else if(event.getSource() == viewSwimTimes)
      {
         View view = new View();
      }
      else if(event.getSource() == searchSwimmer)
      {
         SearchSwimmer searchSwim = new SearchSwimmer();         
      }
   
   
   }
}