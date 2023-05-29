public class Trap extends Piece {
   
   private int owner;
   
   // DEVELOPED BY: ANOUSHKA
   /**
    * Constructor for the Trap class.
    *
    * @param owner The owner of the trap.
    */
   public Trap(int owner){
      this.owner = owner;
   }
   
   // DEVELOPED BY: ANOUSHKA
   /**
    * Retrieves the owner of the trap.
    *
    * @return The owner of the trap.
    */
   public int GetOwner(){
      return this.owner;
   }
   
   // DEVELOPED BY: ANOUSHKA
   /**
    * Returns a string representation of the Trap piece.
    *
    * @return The string representation of the Trap.
    */
   public String toString(){
      return "* * *  ";
   }
}