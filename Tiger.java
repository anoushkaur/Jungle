public class Tiger extends Animal {
   public Tiger(int colour){
      super(false, Animal.TIGER, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("TIG(" + GetRank() +")"); //player 1 
      }
      return ("tig(" + GetRank() +")"); //player 2
   }
   
}