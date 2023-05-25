public class Base extends Piece {

   private int owner;
 
   // DEVELOPED BY: ANOUSHKA
   /**
    * Constructs a Base object with the specified owner.
    *
    * @param owner the owner of the base
    */
   public Base(int owner) {
      this.owner = owner;
   }

   // DEVELOPED BY: ANOUSHKA
   /**
    * Returns the owner of the base.
    *
    * @return the owner of the base
    */
   public int GetOwner() {
      return this.owner;
   }

   // DEVELOPED BY: ANOUSHKA
   /**
    * Returns a string representation of the base.
    * If the owner is P1, it returns " O N E ".
    * If the owner is P2, it returns " T W O ".
    *
    * @return a string representation of the base
    */
   public String toString() {
      if (this.owner == 1) {
         return " O N E ";
      }
      return " T W O ";
   }
}