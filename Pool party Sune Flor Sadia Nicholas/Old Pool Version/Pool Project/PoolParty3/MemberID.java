import java.io.*;
import java.util.*;
public class MemberID
{
   //Fields
   public int MemberID;
   
   //Constructor
   public MemberID()
   {
      this.MemberID = 0;
   }
   //methods
   public int assignMemberID()
   {
      MemberID++;
      return MemberID;
   }
   public void saveID() throws FileNotFoundException
   {
      PrintStream outputID = new PrintStream(new File("ID.txt"));
      outputID.print(MemberID);
   }
   public void loadID() throws FileNotFoundException
   {
      Scanner loadID = new Scanner(new File("ID.txt"));
      while (loadID.hasNextLine())
      {
         MemberID = loadID.nextInt();
      }
         

   
   }

}