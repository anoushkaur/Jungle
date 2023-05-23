public class Dog extends Animal {
   
   /**
    * Constructs a new Dog object with the specified owner.
    *
    * @param owner the owner (player) of the dog
    */
   public Dog(int owner){
      super(Animal.DOG, owner);
   }
   
   /**
    * Returns a string representation of the dog.
    *
    * @return the string representation of the dog
    */
   @Override
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("DOG(" + GetRank() +")"); //player 1 
      }
      return ("dog(" + GetRank() +")"); //player 2
   }
   
}