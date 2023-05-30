public class Displayer {

   // DEVELOPED BY: ANOUSHKA
   /**
    * Prints the game board.
    *
    * @param board the 2D array representing the game board
   */
   public void PrintBoard( Piece[][] board ) {
      //prints a dotted line for every row except the last
      for(int i = 0; i<board.length; i++){
         for (int j = 0; j<board[0].length; j++){ 
            System.out.print("---------");
         }
         System.out.println("-");
         for (int k = 0; k<board[0].length; k++){
            //prints board and values with print f
            if (board[i][k] != null){
               System.out.printf("|%8s" , board[i][k]);
            }
            else{
               System.out.printf("%-9s", "|");
            }
         }
         //prints an extra pipe at the end of every row
         System.out.println("|");
      }
      //prints dotted line for last row
      for (int j = 0; j<board[0].length; j++){
            System.out.print("---------");
         }
         System.out.println("-");
   }
   
   // DEVELOPED BY: ANOUSHKA
   /**
    * Prints the valid moves based on the given array.
    *
    * @param arr the boolean array representing the valid moves
   */
   public void PrintValidMoves( boolean[] arr ){   
      int num = 1;
      System.out.println(0 + ". Repick animal");
      for(int i = 0; i<arr.length; i++){
         if(arr[i]){
            switch(i){
               case 0:
                  System.out.println(num + ". Left");
                  num++;
                  break;
               case 1:
                  System.out.println(num +". Right");
                  num++;
                  break;
               case 2:
                  System.out.println(num + ". Up");
                  num++;
                  break;
               case 3:
                  System.out.println(num + ". Down");
                  num++;
                  break;
            }
         }
      }
   }
   
   // DEVELOPED BY: ANOUSHKA
   /**
    * Prints the valid animals based on the given array.
    *
    * @param arr the array of animals representing the valid animals
   */
   public void PrintValidAnimals( Animal[] arr ){   
      for(int i = 0; i<arr.length; i++){
         if (arr[i] != null){
            System.out.println(arr[i].ORIGRANK + ". " + arr[i]);  
         }       
      }
   }
   
   public void PrintPlayer (int player){
      System.out.println("==================");
      System.out.println("| PLAYER " + player + " TURN: |");
      System.out.println("==================");
   }
   
}