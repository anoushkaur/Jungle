public class Rat extends Animal {

   public Rat(int colour){
      super(true, Animal.RAT, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("RAT(" + GetRank() +")"); //player 1 
      }
      return ("rat(" + GetRank() +")"); //player 2
   }
}