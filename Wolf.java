public class Wolf extends Animal {
   public Wolf(int colour){
      super(false, Animal.WOLF, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("WOL(" + GetRank() +")"); //player 1 
      }
      return ("wol(" + GetRank() +")"); //player 2
   }
   
}