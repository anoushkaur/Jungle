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
   public Animal(int rank, int owner){
      this.owner = owner;
      this.rank = rank;
      this.ORIGRANK = rank;
   }
   
   // DEVELOPED BY: SOFEA
   public int GetOwner(){
      return this.owner;
   }
   
   // DEVELOPED BY: SOFEA   
   public int GetRank(){
      return this.rank;
   }
   
   // DEVELOPED BY: SOFEA
   public void SetRank(int rank){
      this.rank = rank;
   }
}