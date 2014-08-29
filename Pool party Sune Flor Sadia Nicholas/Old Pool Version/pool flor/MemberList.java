import java.util.*;
import java.io.*;

public class MemberList {
  
   ArrayList<Member> memberList = new ArrayList<Member>(); 
   ArrayList<Elite> eliteList = new ArrayList<Elite>();
   
   //add regular member to the members list
   public void createNewMember(Member member){
      System.out.println("adding regular member");
      memberList.add(member);
   }
   public void createNewMember(String name, String birthDate, String address, int phoneNo, String email, boolean active){
      System.out.println("adding regular member");
      int memberID = 0;
      for (int i = 0;i< memberList.size();i++){
         Member member = memberList.get(i);
         if (member.getMemberID() > memberID){
            memberID = member.getMemberID();
         }      
      }
      for (int i = 0;i< eliteList.size();i++){
         Elite elite = eliteList.get(i);
         if (elite.getMemberID() > memberID){
            memberID = elite.getMemberID();
         }      
      }
      Member member = new Member(memberID + 1,name,birthDate,address,phoneNo,email,active);
      memberList.add(member);
   }
   
   
   //add elite member to the elite list
   public void createNewMember(Elite elite){
      System.out.println("adding elite member");
      eliteList.add(elite);
   }
   public void createNewMember(String name, String birthDate, String address, int phoneNo, String email, boolean active, String coach, String team){
      System.out.println("adding elite member");
      int memberID = 0;
      for (int i = 0;i< memberList.size();i++){
         Member member = memberList.get(i);
         if (member.getMemberID() > memberID){
            memberID = member.getMemberID();
         }      
      }
      for (int i = 0;i< eliteList.size();i++){
         Elite elite = eliteList.get(i);
         if (elite.getMemberID() > memberID){
            memberID = elite.getMemberID();
         }      
      }
      Elite elite = new Elite(memberID + 1,name,birthDate,address,phoneNo,email,active,coach,team);
      eliteList.add(elite);
   }
   public int searchMember(String name){
      for (int i = 0;i< memberList.size();i++){
         System.out.println("Search name from members list: " + memberList.size());
         Member member = memberList.get(i);
         if (name.equals(member.getName())){
            return i;
         }      
      }  
      return -1; 
   }
   
  /* public int searchMember(int memberID){
      for (int i = 0;i< memberList.size();i++){
         System.out.println("Search member ID from members list: " + memberList.size());
         Member member = memberList.get(i);
         if (member.getMemberID() == memberID){
            return i;
         }      
      }  
      return -1; 
   }*/
   
   public int searchElite(String name){
      for (int i = 0;i< eliteList.size();i++){
         System.out.println("Search name from Elite list: " + eliteList.size());
         Elite elite = eliteList.get(i);
         if (name.equals(elite.getName())){
            return i;
         }      
      }  
      return -1;   
   } 
   /*
   public int searchElite(int memberID){
      for (int i = 0;i< eliteList.size();i++){
         System.out.println("Search memberID from elite list: " + eliteList.size());
         Elite elite = eliteList.get(i);
         if (elite.getMemberID() == memberID){
            return i;
         }      
      }  
      return -1;   
   }*/
   
   public Member getMember(int arrayNumber){
      return memberList.get(arrayNumber);
   }
   public Elite getElite(int arrayNumber){
      return eliteList.get(arrayNumber);
   }
   
   
   public boolean deleteMember(int arrayNumber){
      memberList.remove(arrayNumber);
      return true;
   }
   
   
   public boolean deleteElite(int arrayNumber){
      eliteList.remove(arrayNumber);
      return true;
   }
   
 /*  public boolean deleteMemberID(int memberID){
      int arrayNumber = searchMember(memberID);
      if (arrayNumber > -1 ){
         return deleteMember(arrayNumber);      
      }
      else{      
         arrayNumber = searchElite(memberID);
         if (arrayNumber > -1){
            return deleteElite(arrayNumber);
         }
      }
      return false;      
   } */
   public void saveAllMembers(){
      System.out.println("saving members");
      try {
         PrintStream outputMember = new PrintStream(new File("Member.dat"));
         for (int i = 0;i< memberList.size();i++){
            Member member = memberList.get(i);
            member.writeMember(outputMember);
         }
         PrintStream outputElite = new PrintStream(new File("Elite.dat"));
         for (int i = 0;i< eliteList.size();i++){
            Elite elite = eliteList.get(i);
            elite.writeElite(outputElite);
         } 
      }
      catch (FileNotFoundException e) {
         System.out.println("Error reading file: " + e);
      }     
   }
   public void readAllMembers(){
      try {
         Scanner inputMember = new Scanner(new File("Member.dat"));   
         while (inputMember.hasNextLine()){
            inputMember.nextLine(); 
            if (inputMember.hasNextLine()){
               Member member = new Member();
               member.readMember(inputMember);
               memberList.add(member);
            }   
         }
         Scanner inputElite = new Scanner(new File("Elite.dat"));   
         while (inputElite.hasNextLine()){
            inputElite.nextLine();
            if (inputElite.hasNextLine()){
               Elite elite = new Elite();
               elite.readElite(inputElite);
               eliteList.add(elite);
            }
         }      
      }
      catch (FileNotFoundException e) {
         System.out.println("Error reading file: " + e);
      }     
   }
      
     
   public void printAllMembers(){
      System.out.println("Print all regular Members: " + memberList.size());
      for (int i = 0;i< memberList.size();i++){
         Member member = memberList.get(i);
         member.printMember();
      }
      
      System.out.println("Print all elite Members: " + eliteList.size());
      for (int i = 0;i< eliteList.size();i++){
         Elite elite = eliteList.get(i);
         elite.printElite();
      }  
   }
}
