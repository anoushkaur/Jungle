public class Dog extends Animal {
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructs a new Dog object with the specified owner.
    *
    * @param owner the owner (player) of the Dog
    */
   public Dog(int owner){
      super(Animal.DOG, owner);
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Returns a string representation of the Dog.
    *
    * @return the string representation of the Dog
    */
   @Override
   public String toString(){
      if (this.GetOwner() == 1){
         return ("DOG(" + GetRank() +")"); //player 1 
      }
      return ("dog(" + GetRank() +")"); //player 2
   }
   
}