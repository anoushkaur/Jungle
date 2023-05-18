public class GameSystem {
   public final static int RIV = 0;
   public final static int P1 = 1;
   public final static int P2 = 2;
   private Player[] allPlayer;
   private Player currPlayer;
   private Piece[][] board = new Piece[9][7];
   private final int[][] RIVER ={{3,1}, {3,2},{3,4}, {3,5}, {4,1}, {4,2}, {4,4}, {4, 5}, {5,1}, {5,2}, {5,4}, {5, 5}};

  //make private
  //canswim and istrapped **
   public final int[][] P1_TRAP = {{0,2}, {1,3}, {0,4}};
   public final int[][] P2_TRAP = {{8,2}, {7,3}, {8,4}};
   public final int[][] BASE = {{0,3}, {8,3}};
   
   public GameSystem(){
      allPlayer = new Player[2]; 
      allPlayer[0] = new Player(1);
      allPlayer[1] = new Player(2);
      currPlayer = allPlayer[0];
      for (int i = 0; i< RIVER.length; i++){
         board[RIVER[i][0]][RIVER[i][1]] = new River();
      }
      
      board[0][2] = new Trap(P1);
      board[0][3] = new Base(P1);
      board[0][4] = new Trap(P1);
      board[1][3] = new Trap(P1);
      board[8][4] = new Trap(P2);
      board[8][3] = new Base(P2);
      board[8][2] = new Trap(P2);
      board[7][3] = new Trap(P2);
      
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
             //board[4][3] = allPlayer[0].GetAnimals()[i];
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
             //board[3][3] = allPlayer[1].GetAnimals()[i];
             board[6][0] = allPlayer[1].GetAnimals()[i];
         }
      }     
   }
    
   private boolean isOnRiver(Rat r){
      int row = getAnimalPos(r)[0];
      int col = getAnimalPos(r)[1];
      for (int i = 0; i<RIVER.length; i++){
         if(row == RIVER[i][0] && col == RIVER[i][1]){
            return true;
         }
      }
      return false;
   }
   
   //to set rank to 0 & replace *
   private Player isOnTrap(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      
      for (int i = 0; i<P1_TRAP.length; i++){
         if (P1_TRAP[i][0] == row && P1_TRAP[i][1] == col){
            return allPlayer[0];
         }
      }
      
      for (int i = 0; i<P2_TRAP.length; i++){
         if (P2_TRAP[i][0] == row && P2_TRAP[i][1] == col){
            return allPlayer[1];
         }
      }
      return null;
   }
   
   private boolean canEat(Animal pred, Animal prey){
      if (pred.GetOwner() == prey.GetOwner()){
         return false;
      }
      if (pred instanceof Rat && prey instanceof Rat){
         if ((isOnRiver((Rat)pred) && isOnRiver((Rat)prey) || (!isOnRiver((Rat)pred) && !isOnRiver((Rat)prey)))){
            return true;
         }
         return false;
      }
      else if(pred instanceof Rat && prey instanceof Elephant && !isOnRiver((Rat)pred)){
         return true;
      }
      else if (pred instanceof Elephant && prey instanceof Rat){
         return false;
      }
      else if ( pred.GetRank() >= prey.GetRank()){
         return true;
      }
      return false;
   }
   
   private int[] getValidLeft(Animal a){
      int row = getAnimalPos(a)[0];
      int col = getAnimalPos(a)[1];
      //RIVER (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row][col-1] instanceof River && board[row][col-2] instanceof River){
            //if((board[row][col-3] == null) || (board[row][col-3] instanceof Animal && canEat(a, (Animal)board[row][col-3]))){
              if((board[row][col-3] == null) ||( (board[row][col-3] instanceof Animal && canEat(a, (Animal)board[row][col-3])))){
               return new int[] {row, col-3};
            }
         }
      }     
      //RIVER (everyone else)
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
      //RIVER (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row][col+1] instanceof River && board[row][col+2] instanceof River){
            if((board[row][col+3] == null) || (board[row][col+3] instanceof Animal && canEat(a, (Animal)board[row][col+3]))){
               return new int[] {row, col+3};
            }
         }
      }     
      //RIVER (everyone else)
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
      //RIVER (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row-1][col] instanceof River && board[row-2][col] instanceof River && board[row-3][col] instanceof River){
            if((board[row-4][col] == null) || (board[row-4][col] instanceof Animal && canEat(a, (Animal)board[row-4][col]))){
               return new int[] {row-4, col};
            }
         }
      }     
      //RIVER (everyone else)
      if(board[row-1][col] instanceof River && a instanceof Rat){
         return new int[] {row-1, col};
      }
      //not own base
      if ((board[row-1][col] instanceof Base) && (((Base)board[row-1][col]).GetOwner() != a.GetOwner())){
         return new int[] {row-1, col};
      }
      if (board[row-1][col] instanceof Animal && canEat(a, (Animal)board[row-1][col])){
         System.out.println(canEat(a, (Animal)board[row-1][col]));
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
      //RIVER (lion/tiger)
      if (a.GetRank() == Animal.LION || a.GetRank() == Animal.TIGER){
         if(board[row+1][col] instanceof River && (board[row+2][col] instanceof River && board[row+3][col] instanceof River)){
            if((board[row+4][col] == null) || (board[row+4][col] instanceof Animal && canEat(a, (Animal)board[row+4][col]))){
               return new int[] {row+4, col};
            }
         }
      }     
      //RIVER (everyone else)
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
   
   //RIVER
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
   
   public void Move(int dir, Animal a) {
      int currentRow = getAnimalPos(a)[0];
      int currentCol = getAnimalPos(a)[1];
      Player trapper = isOnTrap(a);
      Player otherPlayer = allPlayer[currPlayer.GetId() * -1 + 2];
      Piece newDir;

      // dealing w location
      if(a instanceof Rat && isOnRiver((Rat)a)){   
         board[currentRow][currentCol] = new River();
      }
      else if (trapper != null){
         if (trapper == otherPlayer){
            a.SetRank(a.ORIGRANK);
         }
         board[currentRow][currentCol] = new Trap(trapper.GetId());
      }
      else {
         board[currentRow][currentCol] = null;
      }
      
      //dealing w dest
      if (dir == 0) { 
         newDir = board[currentRow][currentCol - 1];
         board[currentRow][currentCol - 1] = a;
      }
      else if (dir == 1){
         newDir = board[currentRow][currentCol + 1];
         board[currentRow][currentCol + 1] = a;
      }
      else if (dir == 2){
         newDir = board[currentRow - 1][currentCol];
         board[currentRow - 1][currentCol] = a;
      }
      else {
         newDir = board[currentRow + 1][currentCol];
         board[currentRow + 1][currentCol] = a;
      }
      if (newDir instanceof Trap && ((Trap)newDir).GetOwner() == otherPlayer.GetId()){
         a.SetRank(0);
      }
      else if (newDir instanceof Animal){
         otherPlayer.RemoveAnimal((Animal)newDir);
      }
   }
   
   public boolean CheckWinner(){
      Player otherPlayer = allPlayer[currPlayer.GetId() * -1 + 2];
      if (otherPlayer.GetAnimals().length == 0){
         return true;
      }
      int otherRow = BASE[otherPlayer.GetId()-1][0];
      int otherCol = BASE[otherPlayer.GetId()-1][1];
      return board[otherRow][otherCol] instanceof Animal;
   }
}