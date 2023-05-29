public abstract class Animal extends Piece {
   public static final int RAT = 1;
   public static final int CAT = 2;
   public static final int WOLF = 3;
   public static final int DOG = 4;
   public static final int LEOPARD = 5;
   public static final int TIGER = 6;
   public static final int LION = 7;
   public static final int ELEPHANT = 8;
   private int rank;
   private int owner;
   public final int ORIGRANK;
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructor for the Animal class.
    *
    * @param rank  The rank of the animal.
    * @param owner The owner of the animal.
    */
   public Animal(int rank, int owner){
      this.owner = owner;
      this.rank = rank;
      this.ORIGRANK = rank;
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Retrieves the owner of the animal.
    *
    * @return The owner of the animal.
    */
   public int GetOwner(){
      return this.owner;
   }
   
   // DEVELOPED BY: SOFEA  
   /**
    * Retrieves the rank of the animal.
    *
    * @return The rank of the animal.
    */ 
   public int GetRank(){
      return this.rank;
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Sets the rank of the animal.
    *
    * @param rank The rank to be set.
    */
   public void SetRank(int rank){
      this.rank = rank;
   }
}