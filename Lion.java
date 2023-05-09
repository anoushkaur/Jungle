public class Lion extends Animal {
   public Lion(int colour){
      super(false, Animal.LION, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("LIO(" + GetRank() +")"); //player 1 
      }
      return ("lio(" + GetRank() +")"); //player 2
   }
   
}