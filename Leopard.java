public class Leopard extends Animal { 
   
   /**
    * Constructs a new Leopard object with the specified owner.
    *
    * @param owner the owner (player) of the Leopard
    */
   public Leopard(int owner){
      super(Animal.LEOPARD, owner);
   }
   
   /**
    * Returns a string representation of the elephant.
    *
    * @return the string representation of the elephant
    */
   @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("LEO(" + GetRank() +")"); //player 1 
      }
      return ("leo(" + GetRank() +")"); //player 2
   }
   
}