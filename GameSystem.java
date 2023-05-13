public class GameSystem {
   public final static int RIV = 0;
   public final static int P1 = 1;
   public final static int P2 = 2;
   private Player[] allPlayer;
   private Player currPlayer;
   private Piece[][] board = new Piece[9][7];
   private final int[][] river ={{3,1}, {3,2},{3,4}, {3,5}, {4,1}, {4,2}, {4,4}, {4, 5}, {5,1}, {5,2}, {5,4}, {5, 5}};

  
   public final int[][] BLACK_TRAP = {{2,0}, {3,1}, {4,0}};
   public final int[][] WHITE_TRAP = {{2,8}, {3,7}, {4,8}};
   public final int[] BLACK_BASE = {3,0};
   public final int[] WHITE_BASE = {3,8}; 
   
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
      for (int i = 0; i< river.length; i++){
         board[river[i][0]][river[i][1]] = new River();
      }

      board[0][2] = new Trap(P1);
      board[0][3] = new Base(P1);
      board[0][4] = new Trap(P1);
      board[1][3] = new Trap(P1);
      board[8][4] = new Trap(P2);
      board[8][3] = new Base(P2);
      board[8][2] = new Trap(P2);
      board[7][3] = new Trap(P2);
     
   }
    
   private boolean isOnRiver(Rat r){
      int row = getAnimalPos(r)[0];
      int col = getAnimalPos(r)[1];
      for (int i = 0; i<river.length; i++){
         if(row == river[i][0] && col == river[i][1]){
            return true;
         }
      }
      return false;
   }
   
   private boolean canEat(Animal pred, Animal prey){
      if (pred.GetOwner() == prey.GetOwner()){
         return false;
      }
      else if(pred instanceof Rat && prey instanceof Elephant && !isOnRiver((Rat)pred)){
         return true;
      }
      else if ( pred.GetRank() >= prey.GetRank()){
         return true;
     }
     return false;
   }
   
   private int[] getValidLeft(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      //river (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row][col-1] instanceof River){
            if((board[row][col-3] == null) || (board[row][col-3] instanceof Animal && canEat(a, (Animal)board[row][col-3]))){
               return new int[] {row, col-3};
            }
         }
      }     
      //river (everyone else)
      if(board[row][col-1] instanceof River && a instanceof Rat){
         return new int[] {row, col-1};
      }
      //not own base
      if ((board[row][col-1] instanceof Base) && (((Base)board[row][col-1]).GetOwner() != a.GetOwner())){
         return new int[] {row, col-1};
      }
      if (board[row][col-1] instanceof Animal && canEat(a, (Animal)board[row][col-1])){
         return new int[] {row, col-1};
      }
      if (board[row][col-1] instanceof Trap || board[row][col-1] == null){
         return new int[] {row, col-1};
      }
      return null;
   }
   
   private int[] getValidRight(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      //river (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row][col+1] instanceof River){
            if((board[row][col+3] == null) || (board[row][col+3] instanceof Animal && canEat(a, (Animal)board[row][col+3]))){
               return new int[] {row, col+3};
            }
         }
      }     
      //river (everyone else)
      if(board[row][col+1] instanceof River && a instanceof Rat){
         return new int[] {row, col+1};
      }
      //not own base
      if ((board[row][col+1] instanceof Base) && (((Base)board[row][col+1]).GetOwner() != a.GetOwner())){
         return new int[] {row, col+1};
      }
      if (board[row][col+1] instanceof Animal && canEat(a, (Animal)board[row][col+1])){
         return new int[] {row, col+1};
      }
      if (board[row][col+1] instanceof Trap){
         return new int[] {row, col+1};
      }
      if ( board[row][col+1] == null){
         return new int[] {row, col+1};
      }
      return null;
   }
   
   private int[] getValidUp(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      //river (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row-1][col] instanceof River){
            if((board[row-4][col] == null) || (board[row-4][col] instanceof Animal && canEat(a, (Animal)board[row-4][col]))){
               return new int[] {row-4, col};
            }
         }
      }     
      //river (everyone else)
      if(board[row-1][col] instanceof River && a instanceof Rat){
         return new int[] {row-1, col};
      }
      //not own base
      if ((board[row-1][col] instanceof Base) && (((Base)board[row-1][col]).GetOwner() != a.GetOwner())){
         return new int[] {row-1, col};
      }
      if (board[row-1][col] instanceof Animal && canEat(a, (Animal)board[row-1][col])){
         return new int[] {row-1, col};
      }
      if (board[row-1][col] instanceof Trap || board[row-1][col] == null){
         return new int[] {row-1, col};
      }
      return null;
   }
   
   private int[] getValidDown(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      //river (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row+1][col] instanceof River){
            if((board[row+4][col] == null) || (board[row+4][col] instanceof Animal && canEat(a, (Animal)board[row+4][col]))){
               return new int[] {row+4, col};
            }
         }
      }     
      //river (everyone else)
      if(board[row+1][col] instanceof River && a instanceof Rat){
         return new int[] {row+1, col};
      }
      //not own base
      if ((board[row+1][col] instanceof Base) && (((Base)board[row+1][col]).GetOwner() != a.GetOwner())){
         return new int[] {row+1, col};
      }
      if (board[row+1][col] instanceof Animal && canEat(a, (Animal)board[row+1][col])){
         return new int[] {row+1, col};
      }
      if (board[row+1][col] instanceof Trap ){
         return new int[] {row+1, col};
      }
      if(board[row+1][col] == null){
         return new int[] {row+1, col};
      }
      return null;
   }

   private int[] getAnimalPos(Animal a){
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
   public boolean[] PossibleMoves(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      boolean[] valid = new boolean[4]; 
      if(col-1>-1){ //check left
         if (getValidLeft(a) != null){
            valid[0] = true;
         }       
      }
      if(col+1<board[0].length){ //check right
         if (getValidRight(a) != null){
            valid[1] = true;
         }
      }
      if(row-1>-1){ //check up
         if (getValidUp(a) != null){
            valid[2] = true;
         }
      }
      if(row+1<board.length){ //check down
         if (getValidDown(a) != null){
            valid[3] = true;
         }
      }
      return valid;
   }
}