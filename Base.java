public class Base extends Piece{

   private int owner;

   public Base(int owner){
      this.owner = owner;
   }
   
   public int GetOwner(){
      return this.owner;
   }
   
   public String toString(){
      if (this.owner == GameSystem.P1){
         return " O N E ";
      }
      return " T W O ";
   }
}