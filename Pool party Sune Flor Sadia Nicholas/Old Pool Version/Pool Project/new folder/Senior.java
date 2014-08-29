public class Senior extends Member
{
   int price;
   boolean isSenior;
   //dont need isSenior. Can be calculated with age
   //dont need birthdate can be calculated with ssn
   public Senior(String name, int birthDate, int ssn, String activePassive, String eliteExercise, int price, boolean isSenior)
   {
      super(name, birthDate, ssn , activePassive , eliteExercise);
      this.price = price;
      this.isSenior = isSenior;
   }
   public String getName()
   {
      return name;
   }
   public int getBirthDate()
   {
      return birthDate;
   }
   public String getActivePassive()
   {
      return activePassive;
   }
   public String getEliteExercise()
   {
      return eliteExercise;
   }
   public int getPrice()
   {
      if (activePassive.equals("active"))
      {
         double price = 1600*0.75;
         return (int)price;
               
      }
      else
      {
         double price2 = 500*0.75;
         return (int)price2;
        
                   
      }
            
   }
   
}

   

