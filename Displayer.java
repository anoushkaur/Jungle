public class Displayer {
   public void PrintBoard( Piece[][] board ) {
      //prints a dotted line for every row except the last
      for(int i = 0; i<board.length; i++){
         for (int j = 0; j<board[0].length; j++){
            System.out.print("---------");
         }
         System.out.println("-");
         //checks if value is new, if it is it displays {} around it
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
}