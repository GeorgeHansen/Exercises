import java.io.*;
import java.util.*;
public class payment extends Member
{
   //fields
   private int MemberID;
   public int Amount;
   public int age;
   public boolean hasPay;
   public String payDate;
   
   Calendar date = Calendar.getInstance();
   public int dayPay = (date.get(Calendar.DAY_OF_MONTH));
   public int monthPay = (date.get(Calendar.MONTH));
   public int yearPay = (date.get(Calendar.YEAR));
   File memID = new File("memberID.dat");
   File payDat = new File("payment.dat");
   //Scanner memscan = new Scanner(memID);
   //Scanner payscan = new Scanner(payment);
   ArrayList<payment> paymentList = new ArrayList<payment>();
   
   //constructor
   public payment(int MemberID, String birthDate)
   {   
      this.ID = ID;
      this.birthDate = birthDate;
      this.Amount = Amount;
      this.payDate = payDate;
      this.hasPay = hasPay;
   }
   
   //methods 
   public void addPayment(payment Payment)
   {
      int i =0;
      fee();
      hasPayed();
      pay();
      System.out.println("adding payment");
      paymentList.add(i,Payment);
      i++;
   }
   
   
   //calculates Anual fee by age and activity
   public int fee()
   {
      Member mem = new Member();
      mem.calculateAge(birthDate);
      if (age>18 && age<60 )//&& isActive() = true)
      {
         Amount = 1600;
      }
      else if(age<=18) //&& isActive() = true )
      {
         Amount = 1000;
      }
      else if(age>=60 )//&& isActive() = true)
      {
         Amount = 1600*3/4;
      }
      else
      {
         Amount = 500;
      }
      return Amount;
   }
   
   //pays bill
   public String pay()
   {
      payDate = Integer.toString(dayPay)+"-"+Integer.toString(monthPay)+"-"+Integer.toString(yearPay);
   
      return payDate;
   }
   
   //checks payment status
   public boolean hasPayed()
   {
      if(dayPay == date.get(Calendar.DAY_OF_MONTH) && monthPay == date.get(Calendar.MONTH) && yearPay == (date.get(Calendar.YEAR)+1))
      {
         System.out.print("needs to pay ");
         hasPay = false;
      }
      else
      {
         System.out.print("has payed ");
         hasPay = true;
      }
      return hasPay;
   }
   
   //saves payments
   public void savePayments()throws FileNotFoundException 
   {
      PrintStream outputpayment = new PrintStream(payDat);
      for (int i = 0;i< paymentList.size();i++)
      {
         payment Payment = paymentList.get(i);
         Payment.writepayment(outputpayment);
      }      
   }
   
   public void writepayment(PrintStream output)
   {
      output.print("MemberID\n");
      output.print(this.MemberID + "\n");
      output.print("Amount\n");
      output.print(this.Amount + "\n");
      output.print("Pay Date\n");
      output.print(this.payDate + "\n");
      output.print("Has Payed\n");;
      output.print(this.hasPay + "\n");
      output.print("--------------------------------------\n");      
    }
    
    public void readMemberInfo(Scanner input)
    {
      input.nextLine();
      input.nextLine();
      this.birthDate    = input.nextLine();
      input.nextLine();
      input.nextLine();
      input.nextLine();
      input.nextLine();
      this.ID = input.nextLine();        
      input.nextLine();  
    }
    public void readPayment(Scanner input)
    {
      input.nextLine();
      this.ID = input.nextLine();
      input.nextLine();
      this.Amount = input.nextInt();
      input.nextLine();
      this.payDate = input.nextLine();
      input.nextLine();
      this.hasPay = input.nextBoolean();        
      input.nextLine();  
 
      
    }
    
    public void print()
    {
      System.out.println(paymentList);
    }

}