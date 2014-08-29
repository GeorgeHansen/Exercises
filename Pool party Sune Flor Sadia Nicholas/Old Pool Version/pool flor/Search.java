import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Search implements ActionListener
{
   MemberList member = new MemberList();
   JFrame frame = new JFrame("Search");
   JLabel name = new JLabel (" Name");
   JLabel id = new JLabel(" ID");
   JLabel birthDay = new JLabel("Date of Birth"); 
   JLabel address = new JLabel(" Address");
   JLabel email = new JLabel(" e-mail");  
   JLabel phoneNum = new JLabel(" Phone Number");
   JLabel active = new JLabel("Active Member");   
   JLabel elite = new JLabel("Elite Member");   
   JLabel coach = new JLabel(" e-mail");  
   JLabel team = new JLabel(" e-mail");  
   
   
   JLabel eliteEx = new JLabel("Check for Elite");
   
   JTextField nameField = new JTextField (8);
   JTextField idField = new JTextField(8);
   JTextField birthdayField = new JTextField(8);
   JTextField addressField = new JTextField(8);
   JTextField emailField = new JTextField(8);
   JTextField phoneNumField = new JTextField(8);
   JCheckBox activeBox = new JCheckBox();  
   JCheckBox eliteBox = new JCheckBox();  
   JTextField coachField = new JTextField(8);
   JTextField teamField = new JTextField(8);
   
   JButton search = new JButton("Search");
   JButton cancel = new JButton("Cancel");

   
   
   public Search(MemberList member)
   {
      this.member = member;
      frame.setSize(400,500);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      //label
      JPanel west = new JPanel(new GridLayout(12,1));
      west.add(name);
      west.add(id);
      west.add(birthDay);    
      west.add(address);
      west.add(email);
      west.add(phoneNum);
      west.add(active);
      west.add(elite);
      west.add(coach);
      west.add(team);
      
      
      frame.add(west,BorderLayout.WEST);
      
      JPanel center = new JPanel(new GridLayout(12,1));
      center.add(nameField);
      center.add(idField);
      center.add(birthdayField);     
      center.add(addressField);    
      center.add(emailField);     
      center.add(phoneNumField);     
      center.add(activeBox);     
      center.add(eliteBox);     
      center.add(coachField);     
      center.add(teamField);     
           
      cancel.addActionListener(this);
      search.addActionListener(this);
      frame.add(center,BorderLayout.CENTER);
      
      JPanel south = new JPanel(new GridLayout(1,4));
      south.add(new JLabel());
      south.add(new JLabel());
      south.add(search);
      south.add(cancel);
      
      frame.add(south,BorderLayout.SOUTH);
      
      
      frame.setVisible(true);
   } 
   public void actionPerformed(ActionEvent event)
   {
      if(event.getSource() == cancel)
      {
         frame.dispose();
      }
      if(event.getSource() == search)
      {
         if (member.searchMember(nameField.getText()) > -1){
            System.out.println("member found");
            Member seMember = new Member();
            seMember = member.getMember(member.searchMember(nameField.getText()));
            idField.setText(Integer.toString(seMember.getMemberID()));
            birthdayField.setText(seMember.getBirthDate());
            addressField.setText(seMember.getAddress());
            emailField.setText(seMember.getEmail());
            phoneNumField.setText(Integer.toString(seMember.getPhoneNo()));
            activeBox.setSelected(seMember.isActive());
            eliteBox.setSelected(false);
            //System.out.println(seMember.getMemberID());
         }
         else if (member.searchElite(nameField.getText()) > -1){
            System.out.println("elite found");
            Elite seElite = new Elite();
            seElite = member.getElite(member.searchElite(nameField.getText()));
            idField.setText(Integer.toString(seElite.getMemberID()));
            birthdayField.setText(seElite.getBirthDate());
            addressField.setText(seElite.getAddress());
            emailField.setText(seElite.getEmail());
            phoneNumField.setText(Integer.toString(seElite.getPhoneNo()));
            activeBox.setSelected(seElite.isActive());
            eliteBox.setSelected(true);
            coachField.setText(seElite.getCoach());
            teamField.setText(seElite.getTeam());
            //System.out.println(seElite.getMemberID());
         }
         else{
            System.out.println("member not found");
            idField.setText("");
            birthdayField.setText("");
            addressField.setText("");
            emailField.setText("");
            phoneNumField.setText("");
            activeBox.setSelected(false);
            eliteBox.setSelected(false);
            coachField.setText("");
            teamField.setText("");            
         }

      }
   
   }

   



}
