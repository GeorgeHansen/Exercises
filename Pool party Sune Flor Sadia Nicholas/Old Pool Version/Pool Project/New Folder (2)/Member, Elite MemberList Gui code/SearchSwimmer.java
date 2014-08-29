import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchSwimmer implements ActionListener 

{
   JFrame frame = new JFrame("Search Swimmer");
   //buttons
   JButton cancel = new JButton("Cancel");
   
   //text fields
   
   JTextField nameField = new JTextField(20);
   JTextField idField = new JTextField(20);
   
  //drop down list
   JComboBox<String> discipline;
   
   //Labels
   JLabel name = new JLabel (" Name");
   JLabel id = new JLabel(" ID");
   JLabel disciplines = new JLabel(" Discipline");
   
  
   public SearchSwimmer() 
   {
      //frame settings
      frame.setSize(400,250);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      
      //label
      JPanel west = new JPanel(new GridLayout(3,1));
      
      
      west.add(name);
      west.add(id);
      west.add(disciplines);
      
             
      frame.add(west,BorderLayout.WEST);
      String[] disciplines = { "Butterfly", "BackStroke", "Freestyle", "BreastStroke", };
      
      JPanel north = new JPanel(new GridLayout(3,1));
      north.add(nameField);
      north.add(idField);
      discipline = new JComboBox<String>(disciplines);
   
      north.add(discipline);
      
      
      
      JPanel panel = new JPanel();
      panel.add(west);
      panel.add(north);
     
      
      frame.add(panel,BorderLayout.NORTH);
      
      
      
      JPanel south = new JPanel(new GridLayout(1,2));
      south.add(new JLabel());
      south.add(new JButton("search"));
      //south.add(new JLabel());
      south.add(cancel);
      south.add(new JLabel());
      
      frame.add(south,BorderLayout.SOUTH);
   
      //Action Listeners
      
      cancel.addActionListener(this);
      //search.addActionListener(this);
      
      frame.setVisible(true);
      
   }
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == cancel)
      {
         frame.dispose();
      }
   }

}
