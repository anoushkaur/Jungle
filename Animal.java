public abstract class Animal extends Piece {
   public static final int RAT = 1;
   public static final int CAT = 2;
   public static final int WOLF = 3;
   public static final int DOG = 4;
   public static final int LEOPARD = 5;
   public static final int TIGER = 6;
   public static final int LION = 7;
   public static final int ELEPHANT = 8;
   private boolean canSwim;
   private boolean isTrapped;
   private int rank;
   private int trapRank;
   private int owner;
   public final int ORIGRANK;
   
   public Animal(boolean canSwim, int rank, boolean isTrapped, int owner){
      this.owner = owner;
      this.canSwim = canSwim;
      this.rank = rank;
      this.ORIGRANK = rank;
      this.isTrapped = isTrapped;
   }
   
   public int GetOwner(){
      return this.owner;
   }
   
   public boolean GetCanSwim(){
      return this.canSwim;
   }
   
   public void SetCanSwim(boolean canSwim){
      this.canSwim = canSwim;
   }
   
   public int GetRank(){
      return this.rank;
   }
   
   public void SetRank(int rank){
      this.rank = rank;
   }
   
   public boolean GetIsTrapped(){
      return this.isTrapped;
   }
   
   public void SetIsTrapped(boolean isTrapped){
      this.isTrapped = isTrapped;
   } 
}