import java.io.*;

public class MemberMain{
   public static void main(String [] args)throws FileNotFoundException {
   
      Member member = new Member(11234,"Flor", "02-02-1987","Ugandavej 11, 2770 Kastrup",
                              1234567,"cuteKo@yahoo.com", true);
      Elite elite = new Elite(01234,"Kenneth","02-02-1987", "Ugandavej 11, 2770 Kastrup",
                             1234567, "cutegggKo@yahoo.com", true, "Nicholas", "Senior team");
                              
                              
   
   // System.out.println(member.calculateAge("02-03-2012"));
   //  System.out.println(member.isJunior("02-03-2012"));
   //  System.out.println(member.calculateAge("02-03-2002"));
   //  System.out.println(member.isJunior("02-03-2002"));
   //  System.out.println(member.calculateAge("02-02-2052"));
   //  System.out.println(member.isPensionist("02-02-2052"));
   
                              
      MemberList memberList = new MemberList();
      memberList.createNewMember(member); 
      memberList.createNewMember(elite);
      memberList.printAllMembers();
      memberList.saveAllMembers();
      System.out.println(memberList.searchElite("Kenneth"));
      int a = memberList.searchMember("Flor");
   //  memberList.deleteMember(a);
   //  int b = memberList.searchElite("Flor");
   //  memberList.deleteElite(a);
      memberList.readAllMembers();   
      memberList.printAllMembers();
      
   }
}
