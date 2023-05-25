public class Trap extends Piece {
   
   private int owner;
   
   // DEVELOPED BY: ANOUSHKA
   public Trap(int owner){
      this.owner = owner;
   }
   
   // DEVELOPED BY: ANOUSHKA
   public int GetOwner(){
      return this.owner;
   }
   
   // DEVELOPED BY: ANOUSHKA
   public String toString(){
      return "* * *  ";
   }
}