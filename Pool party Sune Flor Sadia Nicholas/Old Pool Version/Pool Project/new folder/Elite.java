import java.io.*;
import java.util.*;

public class Elite extends Member{

   protected String coach;
   
   
   
   
   public Elite()
   {
   
   }
   
   public Elite(String name,String birthDate, String address, String phoneNo, String email, String ID){
      super(name, birthDate,address, phoneNo,email,ID);
            
      this.coach = assignCoach();
      this.active = "true";  
   }
   
   
   public String assignCoach()
   {
      int age = Member.calculateAge(birthDate);
      if(age <= 18)
      {
         this.coach = "Peter Pan";
      }
      else
      {
         this.coach = "John Smith";
      }
      return coach;
      
   }
   
   public String getCoach(){
      return coach;  
   }
   
  
   public void setCoach(String coach){
      this.coach = coach;  
   }
   
   
   
   public void printElite(){
      super.printMember();
      System.out.println("Coach Name: " + coach);
      
   }
   public void writeElite(PrintStream output){
      output.print("Member\n");
      output.print(this.name + "\n"); 
      output.print(this.birthDate + "\n");
      output.print(this.address + "\n");
      output.print(this.phoneNo + "\n");
      output.print(this.email + "\n");
      output.print(this.coach + "\n");
      output.print(this.ID + "\n");
      output.print(this.active + "\n");
      output.print("--------------------------------------\n");       
   }
      
   public void readElite(Scanner input){
      input.nextLine();
      this.name         = input.nextLine();
      this.birthDate    = input.nextLine();
      this.address      = input.nextLine();
      this.phoneNo      = input.nextLine();
      //input.nextLine(); 
      this.email        = input.nextLine();
      this.coach = input.nextLine();
      this.ID = input.nextLine();
      this.active = input.nextLine(); 
       
      input.nextLine();
      //input.nextLine();    
      
          
   }

}