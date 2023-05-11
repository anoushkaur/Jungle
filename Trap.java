public class Trap extends Piece {
   
   private int owner;
   
   public Trap(int owner){
      this.owner = owner;
   }
   
   public int GetOwner(){
      return this.owner;
   }
   
   public String toString(){
      return "* * *  ";
   }
}