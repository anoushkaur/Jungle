import java.util.Scanner;

public class Jungle {
   public static void main(String[] args) {
      GameSystem gs = new GameSystem(); // Instantiating classes
      Displayer disp = new Displayer();
      Scanner input = new Scanner(System.in);
      int[] possibleMoves = new int[4];
      boolean animalFound = false;
      boolean GameOver = false;
      System.out.printf("\n%53s" , "     __                     .__          ");
      System.out.printf("\n%53s" ,"    |__|__ __  ____    ____ |  |   ____  ");
      System.out.printf("\n%53s" ,"    |  |  |  \\/    \\  / ___\\|  | _/ __ \\ ");
      System.out.printf("\n%53s" ,"    |  |  |  /   |  \\/ /_/  >  |_\\  ___/ ");
      System.out.printf("\n%54s" ,"/\\__|  |____/|___|  /\\___  /|____/\\____/  ");
      System.out.printf("\n%51s" ,"\\______|          \\//_____/            ");
      System.out.printf("\n\n%53s" ,"Written by Sofea & Anoushka for ICS4U CCT");
      System.out.println();
      System.out.println();
      
      while (!GameOver) { // Player's Menu
         animalFound = false;
         disp.PrintBoard(gs.GetBoard()); // Displaying board
         disp.PrintPlayer(gs.GetCurrPlayer().GetId()); 
         Animal[] animals = gs.GetCurrPlayer().GetAnimals();
         disp.PrintValidAnimals(animals); // Displaying animals
         System.out.print("Choose an animal: "); // Prompt user for which animalChoiceto move
         int animalChoice = input.nextInt();
         
         while (!animalFound) { // while animalChoiceis not found in arr
            if (animalChoice < 1 || animalChoice > 8 || animals[animalChoice-1] == null){ // error message for wrong animal

                System.out.print("Error! Invalid animal. Please enter a valid animal: ");
                animalChoice = input.nextInt();
            }
            else {                
              animalFound = true;
            }
         }

         boolean[] moves = gs.PossibleMoves(animals[animalChoice - 1]);
         if (moves[0] == false && moves[1] == false && moves[2] == false && moves[3] == false){//if no moves avail
            System.out.println("No Moves Available! Choose a different animal below: ");
         }
         else { //if at least 1 move avail
            disp.PrintValidMoves(moves); // Displaying possible moves
            System.out.print("Choose a direction or 0 to pick a different animal: "); // Prompt user for direction
            int dir = input.nextInt();
            //for loop checking how many moves are true in the possible moves arr
            int count = 0; 
            int[] temp = new int[4];
            for (int i = 0; i < moves.length; i++) {
               if (moves[i]) {
                  temp[count] = i;
                  count++;
               }
            }
            while (dir < 0 || dir > count){
               System.out.print("Error! Invalid direction. Please enter a valid direction: ");
               dir = input.nextInt();
            }
            if (dir != 0){
               gs.Move(temp[dir-1], animals[animalChoice- 1]);
               if (gs.CheckWinner()) {
                  GameOver = true;
               } else {
                  gs.SwitchPlayer();
               }
            }
         }
      }
      System.out.println("Player " + gs.GetCurrPlayer().GetId() + " wins!");
   }
}