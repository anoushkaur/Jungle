public class Base extends Piece{

   public Base(int colour){
      super(colour);
   }
   
   public String toString(){
      if (this.colour == Board.P1){
         return " O N E ";
      }
      return " T W O ";
   }
}