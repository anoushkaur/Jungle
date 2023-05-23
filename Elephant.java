public class Elephant extends Animal{
   
   /**
    * Constructs a new Elephant object with the specified owner.
    *
    * @param owner the owner (player) of the elephant
    */
   public Elephant(int owner){
      super(Animal.ELEPHANT, owner);
   }
   
   /**
    * Returns a string representation of the elephant.
    *
    * @return the string representation of the elephant
    */
    @Override
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("ELE(" + GetRank() +")"); //player 1 
      }
      return ("ele(" + GetRank() +")"); //player 2
   }
}