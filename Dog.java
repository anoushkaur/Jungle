public class Dog extends Animal {
   public Dog(int owner){
      super(false, Animal.DOG, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("DOG(" + GetRank() +")"); //player 1 
      }
      return ("dog(" + GetRank() +")"); //player 2
   }
   
}