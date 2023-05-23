import java.util.Scanner;

public class Jungle {
   public static void main(String[] args) {
      // Animal a = new Rat(GameSystem.P2);
      //  System.out.print(a);
      GameSystem gs = new GameSystem(); // Instantiating classes
      Displayer disp = new Displayer();
      Scanner input = new Scanner(System.in);
      //System.out.println(gs.GetBoard()[3][5] instanceof River);
      int[] p1Animals = new int[8];
      int[] p2Animals = new int[8];
      int[] possibleMoves = new int[4];
      boolean animalFound = false;

      while (true) { // Player's Menu
         animalFound = false;
         disp.PrintBoard(gs.GetBoard()); // Displaying board
         Animal[] animals = gs.GetCurrPlayer().GetAnimals();

         disp.PrintValidAnimals(animals); // Displaying animals
         System.out.println("Choose animal"); // Prompt user for which animal to move
         int animal = input.nextInt();
         
         for (int i = 0; i < p1Animals.length; i++) { // If animal is in the correct range
            if (gs.GetCurrPlayer().GetId() == 1 && animals[i] != null) {
               p1Animals[i] = animals[i].ORIGRANK;
            } else {
               p1Animals[i] = 0;
            }
            if (gs.GetCurrPlayer().GetId() == 2 && animals[i] != null) {
               p2Animals[i] = animals[i].ORIGRANK;
            } else {
               p2Animals[i] = 0;
            }
         }
         
         while (!animalFound) { // while animal is not found in arr
            for (int i = 0; i < p1Animals.length; i++) {
               // If p1 animal is found
               if (gs.GetCurrPlayer().GetId() == 1 && p1Animals[i] == animal) {
                  animalFound = true;
                  break;
               }//if p2 animal is found
               if (gs.GetCurrPlayer().GetId() == 2 && p2Animals[i] == animal) {
                  animalFound = true;
                  break;
               }
            }
            if (!animalFound) { // error message for wrong animal
               System.out.println("Enter a valid animal: ");
               animal = input.nextInt();
            }
         }

         if (animalFound) { //if animal exists 
            boolean[] moves = gs.PossibleMoves(animals[animal - 1]);
            if (moves[0] == false && moves[1] == false && moves[2] == false && moves[3] == false){//if no moves avail
               System.out.println("No Moves Available! Choose a different animal below: ");
            }
            else {//if at least 1 move avail
               disp.PrintValidMoves(moves); // Displaying possible moves
               System.out.println("Choose dir"); // Prompt user for direction
               int dir = input.nextInt();
               //for loop checking how many moves are true in the possible moves arr
               int count = 0; 
               int move = 0;
               int[] temp = new int[4];
               for (int i = 0; i < moves.length; i++) {
                  if (moves[i]) {
                     temp[count] = i;
                     count++;
                  }
               }
               while (dir < 1 || dir > count){
                  System.out.println("Enter a valid direction: ");
                  dir = input.nextInt();
               }
               gs.Move(temp[dir-1], animals[animal - 1]);
               if (gs.CheckWinner()) {
                  break;
               } else {
                  gs.SwitchPlayer();
               }
            }
         }
      }
      System.out.println("Player " + gs.GetCurrPlayer().GetId() + " wins!");
   }
}