public class Elephant extends Animal{
   public Elephant(int colour){
      super(false, Animal.ELEPHANT, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("ELE(" + GetRank() +")"); //player 1 
      }
      return ("ele(" + GetRank() +")"); //player 2
   }
}