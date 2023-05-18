import java.util.Scanner;

public class Jungle { 
   public static void main(String[] args){
     // Animal a = new Rat(GameSystem.P2);
    //  System.out.print(a);
      GameSystem gs = new GameSystem(); // Instantiating classes
      Displayer disp = new Displayer();
      Scanner input = new Scanner(System.in);
      //System.out.println(gs.GetBoard()[3][5] instanceof River);
            
      //System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[0]);
      //System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[1]);
      
      while (true){ // Player's Menu
         disp.PrintBoard(gs.GetBoard()); // Displaying board
         Animal[] animals = gs.GetCurrPlayer().GetAnimals();
         
         disp.PrintValidAnimals(animals); // Displaying animals
         System.out.println("Choose animal"); // Prompt user for which animal to move
         int animal = input.nextInt();
         
         boolean[] moves = gs.PossibleMoves(animals[animal-1]);
         disp.PrintValidMoves(moves); // Displaying possible moves
         System.out.println("Choose dir"); // Prompt user for direction
         int dir = input.nextInt();
         
         int count = 0;
         int move = 0;
         for (int i = 0; i < moves.length; i++){ 
            if (moves[i]){
               count ++;
            }
            if (count == dir){
               move = i;
               break; //save i val
            }
         }
         System.out.println(move); 
         gs.Move(move, animals[animal-1]);
         if (gs.CheckWinner()){
            break;
         } else {
            gs.SwitchPlayer();
         }
      }
      System.out.println("Player " +  gs.GetCurrPlayer().GetId() + " wins!");
   }
}