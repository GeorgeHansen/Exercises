import java.io.*;
import java.util.*;

public class Member {
   
   protected int memberID;
   protected String name; 
   protected String birthDate;  
   protected String address;
   protected int phoneNo;
   protected String email;
   protected boolean active;
   protected boolean elite;
   
   
   public Member(){
   
   }
     
   public Member(int memberID, String name, String birthDate, String address, int phoneNo, String email, boolean active){
      this.memberID = memberID;
      this.name = name;
      this.birthDate = birthDate;
      this.address = address;
      this.phoneNo = phoneNo;
      this.email = email;
      this.active = active;
      this.elite = false;
      
   } 
   
   public int getMemberID(){
      return memberID;
      
   }
   
   public String getName(){
      return name;
   }
   
      
   public String getBirthDate(){
      return birthDate;
   } 
   
         
   public String getAddress(){
      return address;
   }
   public int getPhoneNo(){
      return phoneNo;
   }
   
   public String getEmail(){
      return email;
   }
   
   public boolean isElite(){
      return elite;
   }
   
   public boolean isJunior(String date){
      return calculateAge(date) < 18;
   }
   
   public boolean isSenior(String date){
      return calculateAge(date) >= 18 ;
   }
   
   public boolean isPensionist(String date){
      return calculateAge(date) >= 65;
   }
   
   public int getAge(String date){
      return calculateAge(date);
   }
   
   
   public boolean isActive(){
      return active;
   }
   
   public void setMemberID(int memberID){
      this.memberID = memberID;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setBirthDate(){
      this.birthDate = birthDate;
   } 
   
    
   public void setAddress(String address){
      this.address = address;
      
   }
   public void setPhoneNo(int phoneNo){
      this.phoneNo = phoneNo;
   }
   
      
   public void setEmail(String email){
      this.email = email;
   }
   
   public void setActive(boolean active){
      this.active = active;
   }

   
   public void printMember(){
      System.out.println("Member ID: " + memberID);
      System.out.println("Name: " + name);
      System.out.println("Birthday: " + birthDate);    
      System.out.println("Address: " + address);
      System.out.println("Contact number: " + phoneNo); 
      System.out.println("Email address: " + email);
      System.out.println("Is Active? " + active);
      System.out.println("Is elite? " + elite);
      
   }  
   
   public int calculateAge(String date){
      int dayDate = Integer.parseInt(date.substring(0,2));
      int monthDate = Integer.parseInt(date.substring(3,5));
      int yearDate = Integer.parseInt(date.substring(6,10));
      int dayBirthDate = Integer.parseInt(this.birthDate.substring(0,2));
      int monthBirthDate = Integer.parseInt(this.birthDate.substring(3,5));
      int yearBirthDate = Integer.parseInt(this.birthDate.substring(6,10));
      
      if (monthDate > monthBirthDate){
         return yearDate - yearBirthDate;
      }  
      if (monthDate < monthBirthDate) {
         return yearDate - yearBirthDate - 1;
      }
      if (monthDate == monthBirthDate){
         if (dayDate > dayBirthDate) {
            return yearDate - yearBirthDate;
         }
         if (dayDate < dayBirthDate) {
            return yearDate - yearBirthDate - 1;
         }
         if (dayDate == dayBirthDate) {
            return yearDate - yearBirthDate;
         }
      }
      return 0;
   }

    
    
   public void writeMember(PrintStream output){
      output.print("Member\n");
      output.print(this.memberID + "\n");
      output.print(this.name + "\n"); 
      output.print(this.birthDate + "\n");
      output.print(this.address + "\n");
      output.print(this.phoneNo + "\n");
      output.print(this.email + "\n");
      output.print(this.active + "\n");
      output.print(this.elite + "\n");
      output.print("--------------------------------------\n"); 
      output.print(" ");     
   }
   public void readMember(Scanner input){
      //input.nextLine();
      this.memberID      = input.nextInt();
      input.nextLine();
      this.name         = input.nextLine();
      this.birthDate    = input.nextLine();
      this.address      = input.nextLine();
      this.phoneNo      = input.nextInt();
      input.nextLine();
      this.email        = input.nextLine();
      this.active       = input.nextBoolean();
      this.elite        = input.nextBoolean();
      input.nextLine();
      input.nextLine();
         
   }
    
} 
