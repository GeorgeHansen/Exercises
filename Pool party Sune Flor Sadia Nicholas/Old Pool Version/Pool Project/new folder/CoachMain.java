import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoachMain implements ActionListener
{
   
   JFrame frame = new JFrame("Pool Party:  Coach Login");
   JTextArea infoBox = new JTextArea(5,20);
   
   JPanel rightBox = new JPanel();    
   JButton viewSwimTimes = new JButton("View SwimTimes");
   JButton addSwimTime = new JButton("Add Swim Times");
   JLabel memberList = new JLabel("Member List");
   JButton searchSwimmer = new JButton("Search Swimmer");
   JLabel fill = new JLabel("----------------------------------------------------------------");
   
   
   public CoachMain()
   {
      
      frame.setSize(600,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      rightBox.setLayout(new GridLayout(6,1,0,5));
      //rightBox.setLayout(new BoxLayout(rightBox, BoxLayout.PAGE_AXIS));
      infoBox.setEditable(true); 
      
      
      rightBox.add(viewSwimTimes);
      rightBox.add(addSwimTime);  
      rightBox.add(searchSwimmer);
      
      frame.add(rightBox,BorderLayout.EAST);
      
       
      frame.add(infoBox, BorderLayout.CENTER);
      
      searchSwimmer.addActionListener(this);
      viewSwimTimes.addActionListener(this);
      addSwimTime.addActionListener(this);
      
      
      JScrollPane scrollPane = new JScrollPane(infoBox);
      frame.add(scrollPane);
      
      frame.add(memberList,BorderLayout.NORTH);
      frame.add(fill, BorderLayout.SOUTH);
      
      frame.setVisible(true);

   }
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == viewSwimTimes)
      {
         View view = new View();
      }
      else if(event.getSource() == searchSwimmer)
      {
         SearchSwimmer searchSwim = new SearchSwimmer();         
      }
      else if(event.getSource() == addSwimTime)
      {
         AddSwimTime addSwimTime = new AddSwimTime();
      }

   }
}