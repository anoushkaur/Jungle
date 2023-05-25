public class Cat extends Animal {
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructs a new Cat object with the specified owner.
    *
    * @param owner the owner (player) of the Cat
    */
   public Cat(int owner){
      super(Animal.CAT, owner);
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Returns a string representation of the Cat.
    *
    * @return the string representation of the Cat
    */
    @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("CAT(" + GetRank() +")"); //player 1 
      }
      return ("cat(" + GetRank() +")"); //player 2
   }
   
}