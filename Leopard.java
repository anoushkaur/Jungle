public class Leopard extends Animal { 
   public Leopard(int colour){
      super(false, Animal.LEOPARD, false, colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return ("LEO(" + GetRank() +")"); //player 1 
      }
      return ("leo(" + GetRank() +")"); //player 2
   }
   
}