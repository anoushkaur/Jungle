public class Tiger extends Animal {
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructs a new Tiger object with the specified owner.
    *
    * @param owner the owner (player) of the Tiger
    */
   public Tiger(int owner){
      super(Animal.TIGER, owner);
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Returns a string representation of the Tiger.
    *
    * @return the string representation of the Tiger
    */
   @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("TIG(" + GetRank() +")"); //player 1 
      }
      return ("tig(" + GetRank() +")"); //player 2
   }
   
}