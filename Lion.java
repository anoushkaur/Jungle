public class Lion extends Animal {
   
   /**
    * Constructs a new Leopard object with the specified owner.
    *
    * @param owner the owner (player) of the Leopard
    */
   public Lion(int owner){
      super(Animal.LION, owner);
   }
   
   /**
    * Returns a string representation of the elephant.
    *
    * @return the string representation of the elephant
    */
   @Override
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("LIO(" + GetRank() +")"); //player 1 
      }
      return ("lio(" + GetRank() +")"); //player 2
   }
   
}