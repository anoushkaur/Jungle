public class Wolf extends Animal {

   // DEVELOPED BY: SOFEA
   /**
    * Constructs a new Wolf object with the specified owner.
    *
    * @param owner the owner (player) of the Wolf
    */
   public Wolf(int owner){
      super(Animal.WOLF, owner);
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Returns a string representation of the Wolf.
    *
    * @return the string representation of the Wolf
    */
   @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("WOL(" + GetRank() +")"); //player 1 
      }
      return ("wol(" + GetRank() +")"); //player 2
   }
   
}