import java.io.*;
import java.util.*;
public class Payment
{
   //fields
   private int MemberID;
   public int Amount;
   public int age;
   public boolean hasPay;
   public String payDate;
   public String cpr;
   Calendar date = Calendar.getInstance();
   public int dayPay = (date.get(Calendar.DAY_OF_MONTH));
   public int monthPay = (date.get(Calendar.MONTH));
   public int yearPay = (date.get(Calendar.YEAR));
   //public int i =0;
   
   File payDat = new File("payment.dat");
   //Scanner memscan = new Scanner(memID);
   //Scanner payscan = new Scanner(payment);
   ArrayList<Payment> paymentList = new ArrayList<Payment>();
   
   //constructor
   public Payment()
   {
   
   }
   public Payment(int MemberID, String cpr)
   {
      this.MemberID = MemberID;
      this.cpr = cpr;
      this.Amount = Amount;
      this.payDate = payDate;
      this.hasPay = hasPay;
   }


   //methods 
   public void addPayment(Payment payment)
   {
      
      fee();
      hasPayed();
      pay();
      System.out.println("adding payment");
      paymentList.add(payment);
      //i++;
   }
   
   //calculates age of member
   public int calculateAge(String cpr)
   {
      Calendar now = Calendar.getInstance();

      // Year calculations
      int year;
      if ((int)cpr.charAt(6)-48<5)
      {
         year = 1900;
      }
      else year = 2000;
      {
         year+=Integer.parseInt(cpr.substring(4,6));
      }
      age = now.get(Calendar.YEAR) - year;

      //Month Calculation
      int month = Integer.parseInt(cpr.substring(2,4));
      month = now.get(Calendar.MONTH)+1- month;

      //Day Calculation
      int days = Integer.parseInt(cpr.substring(0,2));
      days = now.get(Calendar.DAY_OF_MONTH) - days;

      if (month<0) 
      {
         age--;
      }
      else 
      {
         if (month == 0) 
         {
            if (days < 0) 
            {
               age--;
            }
         }
      }
      if(age>100)
      {
         age = age-100;
      }
      return age;
   }

   //calculates Anual fee by age and activity
   public int fee()
   {
      calculateAge(cpr);
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
         Payment payment = paymentList.get(i);
         payment.writepayment(outputpayment);
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
    
    public void readpayment()throws FileNotFoundException //Scanner input(was parameter)
    {
         Scanner input = new Scanner("payment.dat");
         input.nextLine();
         this.MemberID = input.nextInt();
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