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

      //System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[0]);
      //System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[1]);

      while (true) { // Player's Menu
         animalFound = false;
         disp.PrintBoard(gs.GetBoard()); // Displaying board
         Animal[] animals = gs.GetCurrPlayer().GetAnimals();

         disp.PrintValidAnimals(animals); // Displaying animals
         System.out.println("Choose animal"); // Prompt user for which animal to move
         int animal = input.nextInt();
         
         /*while (animal < 1 || animal > 8) { // If animal is not in range (1-8)
            System.out.println("Enter a valid animal: ");
            animal = input.nextInt();
         }
         for (int i = 0; i < p1Animals.length; i++) { // If animal is in the correct range
            if (gs.GetCurrPlayer().GetId() == 1 && animals[i] != null) {
               p1Animals[i] = animals[i].GetRank();
               //System.out.println(p1Animals[i]);
            } else {
               p1Animals[i] = 0;
            }
            if (gs.GetCurrPlayer().GetId() == 2 && animals[i] != null) {
               p2Animals[i] = animals[i].GetRank();
               //System.out.println(p2Animals[i]);
            } else {
               p2Animals[i] = 0;
            }
         }
<<<<<<< Updated upstream
         System.out.println(animal); */
         while (!animalFound) { // If animal is not in the correct range which are 1 to 8
=======
         //System.out.println(animal);
         while (!animalFound) {
>>>>>>> Stashed changes
            for (int i = 0; i < p1Animals.length; i++) {
               // If 
               if (gs.GetCurrPlayer().GetId() == 1 && p1Animals[i] == animal) {
                  animalFound = true;
                  break;
               }
               if (gs.GetCurrPlayer().GetId() == 2 && p2Animals[i] == animal) {
                  animalFound = true;
                  break;
               }
            }
            if (!animalFound) {
               System.out.println("Enter a valid animal: ");
               animal = input.nextInt();
            }
         }

         if (animalFound) {
            boolean[] moves = gs.PossibleMoves(animals[animal - 1]);
            if (moves[0] == false && moves[1] == false && moves[2] == false && moves[3] == false){
               System.out.println("No Moves Available! Choose a different animal below: ");
            }
            else {
               disp.PrintValidMoves(moves); // Displaying possible moves
               System.out.println("Choose dir"); // Prompt user for direction
               int dir = input.nextInt();
   
               int count = 0;
               int move = 0;
               for (int i = 0; i < moves.length; i++) {
                  if (moves[i]) {
                     count++;
                  }
                  if (count == dir) {
                     move = i;
                     break; //save i val
                  }
               }
               //System.out.println(move);
               gs.Move(move, animals[animal - 1]);
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