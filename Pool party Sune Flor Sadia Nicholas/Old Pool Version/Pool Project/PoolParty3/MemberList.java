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
   
   //add elite member to the elite list
   public void createNewElite(Elite elite){
      System.out.println("adding elite member");
      eliteList.add(elite);
   }
   
   
   public int searchMember(String name){
      for (int i = 0;i< memberList.size();i++){
         System.out.println("Search name from members list: " + memberList.size());
         Member member = memberList.get(i);
         if (member.getName() == name){
            return i;
         }      
      }  
      return -1; 
   }
    
   public int searchElite(String name){
      for (int i = 0;i< eliteList.size();i++){
         System.out.println("Search name from Elite list: " + eliteList.size());
         Elite elite = eliteList.get(i);
         if (elite.getName() == name){
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
   public void saveMembers() throws FileNotFoundException {
      PrintStream outputMember = new PrintStream(new File("Member.dat"));
      for (int i = 0;i< memberList.size();i++){
         Member member = memberList.get(i);
         member.writeMember(outputMember);
      }
   }
   public void saveElite() throws FileNotFoundException
   {
      PrintStream outputElite = new PrintStream(new File("Elite.dat"));
      for (int i = 0;i< eliteList.size();i++){
         Elite elite = eliteList.get(i);
         elite.writeElite(outputElite);
      }      
   }
   public void readMembers() throws FileNotFoundException
   {
      Scanner inputMember = new Scanner(new File("Member.dat"));   
      while (inputMember.hasNextLine()){
         Member member = new Member();
         member.readMember(inputMember);
         memberList.add(member);
      }
   }
      
   public void loadElite() throws FileNotFoundException
   {
      Scanner inputElite = new Scanner(new File("Elite.dat"));   
      while (inputElite.hasNextLine()){
         Elite elite = new Elite();
         elite.readElite(inputElite);
         eliteList.add(elite);
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
