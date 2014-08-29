import java.io.*;
import java.util.*;
public class Payment
{
   //fields
   private String MemberID;
   public String Amount;
   protected int ID;
   public int age;
   public String hasPay;
   public String payDate;
   public String cpr;
   Calendar date = Calendar.getInstance();
   public int dayPay = (date.get(Calendar.DAY_OF_MONTH));
   public int monthPay = (date.get(Calendar.MONTH)+1);
   public int yearPay = (date.get(Calendar.YEAR));
   public int i =0;
   
   //File payDat = new File("payment.dat");
   //Scanner memscan = new Scanner(memID);
   //Scanner payscan = new Scanner(payment);
   ArrayList<Payment> paymentList = new ArrayList<Payment>();
   
   //constructor
   public Payment()
   {
   
   }
   public Payment(int ID, String cpr)
   {
      this.ID = ID;
      this.MemberID = Integer.toString(ID);
      this.cpr = cpr;
      this.Amount = Amount;
      this.payDate = payDate;
      this.hasPay = hasPay;
   }


   //methods 
   //Adds payment to arraylist
   public void addPayment(Payment payment)
   {
      
      //this.fee();
      //this.hasPayed();
      //this.pay();
      System.out.println("adding payment");
      paymentList.add(payment);
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
   public String fee(Member member)
   {
      calculateAge(cpr);
      if (age>18 && age<60 && member.isActive())
      {
         Amount = "1600";
      }
      else if(age<=18 && member.isActive())
      {
         Amount = "1000";
      }
      else if(age>=60 && member.isActive())
      {
         Amount = "1200";
      }
      else
      {
         Amount = "500";
      }
      return Amount;
   }
   
   public String getID()
   {
      return MemberID;
   }
   
   //adds the date of payment
   public String pay()
   {
      payDate = Integer.toString(dayPay)+"-"+Integer.toString(monthPay)+"-"+Integer.toString(yearPay);
   
      return payDate;
   }
   
   //checks payment status
   public String hasPayed()
   {
      if(dayPay == date.get(Calendar.DAY_OF_MONTH) && monthPay == date.get(Calendar.MONTH) && yearPay == (date.get(Calendar.YEAR)+1))
      {
         //System.out.print("needs to pay ");
         this.hasPay = "false";
      }
      else
      {
         //System.out.print("has payed ");
         this.hasPay = "true";
      }
      return hasPay;
   }
   
   //saves payments
   public void savePayments()throws FileNotFoundException 
   {
      File payDat = new File("payment.dat");
      PrintStream outputpayment = new PrintStream(payDat);
      for (int i = 0;i< paymentList.size();i++)
      {
         Payment payment = paymentList.get(i);
         payment.writepayment(outputpayment);
      }      
   }
   
   //write function for the save to file function
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
    //read function for the load from file function
    public void readPayment(Scanner input)throws FileNotFoundException //Scanner input(was parameter)
    {
         input.nextLine();
         this.MemberID = input.nextLine();
         input.nextLine();
         this.Amount = input.nextLine();
         input.nextLine();
         this.payDate = input.nextLine();
         input.nextLine();
         this.hasPay = input.nextLine();
         input.nextLine();
         
         
             
    }
   
   //loads from file 
   public void loadPayments(Payment payment) throws FileNotFoundException
   {
      File payDat = new File("payment.dat");
      Scanner inputPay = new Scanner(payDat);   
      while (inputPay.hasNextLine())
      {
         readPayment(inputPay);
         paymentList.add(payment);
        
      }      
   }

}