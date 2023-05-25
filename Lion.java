public class Lion extends Animal {
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructs a new Leopard object with the specified owner.
    *
    * @param owner the owner (player) of the Lion
    */
   public Lion(int owner){
      super(Animal.LION, owner);
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Returns a string representation of the Lion.
    *
    * @return the string representation of the Lion
    */
   @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("LIO(" + GetRank() +")"); //player 1 
      }
      return ("lio(" + GetRank() +")"); //player 2
   }
   
}