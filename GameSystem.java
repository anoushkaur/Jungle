public class GameSystem {
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
   private Piece[][] board = new Piece[9][7]; 
   
   public GameSystem(){
      allPlayer = new Player[2]; 
      allPlayer[0] = new Player(1);
      allPlayer[1] = new Player(2);
      currPlayer = allPlayer[0];
      for (int i = 0; i<currPlayer.GetAnimals().length; i++){
         if (currPlayer.GetAnimals()[i] instanceof Lion){
             board[0][0] = allPlayer[0].GetAnimals()[i];
             board[8][6] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Tiger){
             board[0][6] = allPlayer[0].GetAnimals()[i];
             board[8][0] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Dog){
             board[1][1] = allPlayer[0].GetAnimals()[i];
             board[7][5] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Cat){
             board[1][5] = allPlayer[0].GetAnimals()[i];
             board[7][1] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Rat){
             board[2][0] = allPlayer[0].GetAnimals()[i];
             board[6][6] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Leopard){
             board[2][2] = allPlayer[0].GetAnimals()[i];
             board[6][4] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Wolf){
             board[2][4] = allPlayer[0].GetAnimals()[i];
             board[6][2] = allPlayer[1].GetAnimals()[i];
         }
         else if (currPlayer.GetAnimals()[i] instanceof Elephant){
             board[2][6] = allPlayer[0].GetAnimals()[i];
             board[6][0] = allPlayer[1].GetAnimals()[i];
         }
      }

      board[0][2] = new Trap(P1);
      board[0][3] = new Base(P1);
      board[0][4] = new Trap(P1);
      board[1][3] = new Trap(P1);
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
      board[8][4] = new Trap(P2);
      board[8][3] = new Base(P2);
      board[8][2] = new Trap(P2);
      board[7][3] = new Trap(P2);
     
   }
   
   public int[] GetAnimalPos(Animal a){
      for(int i = 0; i<board.length; i++){
         for(int j = 0; j< board[0].length; j++){
            if (board[i][j] instanceof Animal && a == (Animal)board[i][j]){
               return new int[] {i, j};
            }
         }
      }
      return null;
   }
   
   public Piece[][] GetBoard(){
      return this.board;
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
   
   //river
   //trap
   //base
   //animal
   //out of bound
   //null
   public boolean[] isMovePossible(int[] pos){
      int row = pos[0];
      int col = pos[1];
      Animal a = (Animal)board[row][col];
      boolean[] valid = new boolean[4]; 
      if(col-1>-1){ //check left
         if (board[row][col-1] == null){
            valid[0] = true;
         }
         else if (board[row][col-1] instanceof Animal){
            //check if its enemys animal or yours
            //also check rank if its enemys animal
         }
      }
      if(col+1<board[0].length){ //check right
      }
      
      if(row-1>-1){ //check up
      
      }
      if(row+1<board.length){ //check down
      
      }
      return null;
   }
}