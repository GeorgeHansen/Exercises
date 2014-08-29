public class Junior extends Member
{
   int price;   
   public Junior(String name, int birthDate, int ssn, String activePassive, String eliteExercise, int price)
   {
      super(name, birthDate, ssn , activePassive , eliteExercise);
      this.price = price;
   }
   public String getName()
   {
      return name;
   }
   public int getbirthDate()
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
      return price;
   }

   
}