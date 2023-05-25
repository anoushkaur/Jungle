public class Cat extends Animal {
   
   /**
    * Constructs a new Cat object with the specified owner.
    *
    * @param owner the owner (player) of the cat
    */
   public Cat(int owner){
      super(Animal.CAT, owner);
   }
   
   /**
    * Returns a string representation of the dog.
    *
    * @return the string representation of the dog
    */
    @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("CAT(" + GetRank() +")"); //player 1 
      }
      return ("cat(" + GetRank() +")"); //player 2
   }
   
}