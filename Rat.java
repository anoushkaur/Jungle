public class Rat extends Animal {   

   /**
    * Constructs a new Rat object with the specified owner.
    *
    * @param owner the owner (player) of the Rat
    */
   public Rat(int owner){
      super(Animal.RAT, owner);
   }
   
   /**
    * Returns a string representation of the Rat.
    *
    * @return the string representation of the Rat
    */
   @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("RAT(" + GetRank() +")"); //player 1 
      }
      return ("rat(" + GetRank() +")"); //player 2
   }
}