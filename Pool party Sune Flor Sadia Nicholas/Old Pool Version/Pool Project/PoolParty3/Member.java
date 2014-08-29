import java.io.*;
import java.util.*;

public class Member {

   protected String name; 
   protected String birthDate;  
   protected String address;
   protected String phoneNo;
   protected String email;
   protected int memID;
   protected String ID;
   protected boolean active = true;
   protected boolean paid;
   
   
   
   
   public Member(){
   
   }
     
   public Member(String name, String birthDate, String address, String phoneNo, 
                String email, String ID){
      
      this.name = name;
      this.birthDate = birthDate;
      this.address = address;
      this.phoneNo = phoneNo;
      this.email = email;
      this.ID = ID;
      
      
   }
   public boolean hasPaid()
   {
      return this.paid;
   }
   public void setPaid()
   {
      this.paid = true;
   }
   public boolean isActive()
   {
      return active;
   } 
   public void setInActive()
   {
      this.active = false;
   }  
   public String getId()
   {
      return this.ID;
   }
   public String getName(){
      return this.name;
   }
   
      
   public String getBirthDate(){
      return birthDate;
   } 
   
         
   public String getAddress(){
      return address;
   }
   public String getPhoneNo(){
      return phoneNo;
   }
   
   public String getEmail(){
      return email;
   }
   
   
   public boolean isJunior(String date){
      return calculateAge(date) < 18;
   }
   
   public boolean isPensionist(String date){
      return calculateAge(date) >= 65;
   }
   
   public int getAge(String date){
      return calculateAge(date);
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
   public void setPhoneNo(String phoneNo){
      this.phoneNo = phoneNo;
   }
   
      
   public void setEmail(String email){
      this.email = email;
   }
   
   

   
   public void printMember(){
      System.out.println("Name: " + name);
      System.out.println("Birthday: " + birthDate);    
      System.out.println("Address: " + address);
      System.out.println("Contact number: " + phoneNo); 
      System.out.println("Email address: " + email);
      
      
   }  
   
   public static int calculateAge(String date)
   {
     int age;
        Calendar now = Calendar.getInstance();

        // Year calculations
        int year;
        if ((int)date.charAt(6)-48<5)
           year = 1900;
        else year = 2000;
        year+=Integer.parseInt(date.substring(4,6));

        age = now.get(Calendar.YEAR) - year;

        //Month Calculation
        int month = Integer.parseInt(date.substring(2,4));
        month = now.get(Calendar.MONTH)+1- month;

        //Day Calculation
        int days = Integer.parseInt(date.substring(0,2));
        days = now.get(Calendar.DAY_OF_MONTH) - days;

        if (month<0) {
            age--;
        }
        else {
            if (month == 0) {
                if (days < 0) {
                    age--;
                }
            }
        }
        return age;
    }
          
   public void writeMember(PrintStream output){
      output.print("Member\n");
      output.print(this.name + "\n"); 
      output.print(this.birthDate + "\n");
      output.print(this.address + "\n");
      output.print(this.phoneNo + "\n");
      output.print(this.email + "\n");
      output.print(this.ID + "\n");
      output.print("--------------------------------------\n");      
   }
   public void readMember(Scanner input){
      input.nextLine();
      this.name         = input.nextLine();
      this.birthDate    = input.nextLine();
      this.address      = input.nextLine();
      this.phoneNo      = input.nextLine();
      //input.nextLine(); asshole line
      this.email        = input.nextLine();
      this.ID        = input.nextLine();
           
      input.nextLine();
       
   }
    
} 
