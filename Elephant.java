public class Elephant extends Animal{
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructs a new Elephant object with the specified owner.
    *
    * @param owner the owner (player) of the Elephant
    */
   public Elephant(int owner){
      super(Animal.ELEPHANT, owner);
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Returns a string representation of the Elephant.
    *
    * @return the string representation of the Elephant
    */
    @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("ELE(" + GetRank() +")"); //player 1 
      }
      return ("ele(" + GetRank() +")"); //player 2
   }
}