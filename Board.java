public class Board {
   public final static int RIV = 0;
   public final static int P1 = 1;
   public final static int P2 = 2;
   public final static char LEFT = 'a';
   public final static char RIGHT = 'd';
   public final static char UP = 'w';
   public final static char DOWN = 's';
   private Player[] allPlayer;
   private Player currPlayer;
   
  
   public final int[][] BLACK_TRAP = {{2,0}, {3,1}, {4,0}};
   public final int[][] WHITE_TRAP = {{2,8}, {3,7}, {4,8}};
   public final int[] BLACK_BASE = {3,0};
   public final int[] WHITE_BASE = {3,8};
   public static Piece board[][] = new Piece[9][7];
   
   public Board(){
      board[0][0] = new Lion(P1);
      board[0][2] = new Trap(P1);
      board[0][3] = new Base(P1);
      board[0][4] = new Trap(P1);
      board[0][6] = new Tiger(P1);
      board[1][1] = new Dog(P1);
      board[1][3] = new Trap(P1);
      board[1][5] = new Cat(P1);
      board[2][0] = new Rat(P1);
      board[2][2] = new Leopard(P1);
      board[2][4] = new Wolf(P1);
      board[2][6] = new Elephant(P1);
      board[3][1] = new River();
      board[3][2] = new River();
      board[3][4] = new River();
      board[3][5] = new River();
      board[4][1] = new River();
      board[4][2] = new River();
      board[4][4] = new River();
      board[4][5] = new River();
      board[5][1] = new River();
      board[5][2] = new River();
      board[5][4] = new River();
      board[5][5] = new River();
      board[8][6] = new Lion(P2);
      board[8][4] = new Trap(P2);
      board[8][3] = new Base(P2);
      board[8][2] = new Trap(P2);
      board[8][0] = new Tiger(P2);
      board[7][5] = new Dog(P2);
      board[7][3] = new Trap(P2);
      board[7][1] = new Cat(P2);
      board[6][6] = new Rat(P2);
      board[6][4] = new Leopard(P2);
      board[6][2] = new Wolf(P2);
      board[6][0] = new Elephant(P2);
      allPlayer = new Player[2]; 
      allPlayer[0] = new Player(1);
      allPlayer[1] = new Player(2);
      currPlayer = allPlayer[0];
   }
   
   public void SetCurrPlayer(int id){
      if (id == 1 || id == 2){
         currPlayer = allPlayer[id-1];
      }
   }
   
   public Player GetCurrPlayer(){
      return currPlayer;
   }
   
   public void SwitchPlayer(){
      currPlayer = allPlayer[(currPlayer.GetId() * -1) + 2];
   }
}