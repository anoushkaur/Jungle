public class Dog extends Animal {
   public Dog(int colour){
      super(false, Animal.DOG, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("DOG(" + GetRank() +")"); //player 1 
      }
      return ("dog(" + GetRank() +")"); //player 2
   }
   
}