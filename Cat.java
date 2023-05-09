public class Cat extends Animal {
   public Cat(int colour){
      super(false, Animal.CAT, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("CAT(" + GetRank() +")"); //player 1 
      }
      return ("cat(" + GetRank() +")"); //player 2
   }
   
}