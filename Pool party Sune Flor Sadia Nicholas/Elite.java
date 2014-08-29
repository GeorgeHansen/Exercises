import java.io.*;
import java.util.*;

public class Elite extends Member{

   private String coach;
   private String team;
   
   public Elite(){
   
   }
   
   public Elite(int memberID, String name,String birthDate, String address, int phoneNo, String email,
                boolean active, String coach, String team){
      super(memberID, name, birthDate,address, phoneNo, email, active);
      super.elite = true;
      this.coach = coach;
      this.team = team;    
   }

   
   public String getCoach(){
      return coach;  
   }
   
   public String getTeam(){
      return team;
   }
   public void setCoach(String coach){
      this.coach = coach;  
   }
   
   public void setTeam(String team){
      this.team = team;
   }
   
   public void printElite(){ //for testing. Prints to console
      super.printMember();
      System.out.println("Coach Name: " + coach);
      System.out.println("Which team? " + team);
   }
   public void writeElite(PrintStream output){ //writes to a file
      super.writeMember(output);
      output.print("Elite\n");
      output.print(this.coach + "\n");
      output.print(this.team + "\n");
      output.print("--------------------------------------\n");      
   }
   public void readElite(Scanner input){ //reads from a file
      super.readMember(input);
      input.nextLine();
      this.coach        = input.nextLine();
      this.team         = input.nextLine();
      input.nextLine();      
   }

}