import java.util.Scanner;

public class Jungle {
   public static void main(String[] args){
     // Animal a = new Rat(GameSystem.P2);
    //  System.out.print(a);
      GameSystem gs = new GameSystem();
      Displayer disp = new Displayer();
      Scanner input = new Scanner(System.in);
      System.out.println(gs.GetBoard()[3][5] instanceof River);
      
      //System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[0]);
      //System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[1]);
      while (true){
         disp.PrintBoard(gs.GetBoard());
         Animal[] animals = gs.GetCurrPlayer().GetAnimals();
         disp.PrintValidAnimals(animals);
         System.out.println("Choose animal");
         int animal = input.nextInt();
         boolean[] moves = gs.PossibleMoves(animals[animal-1]);
         disp.PrintValidMoves(moves);
         System.out.println("Choose dir");
         int dir = input.nextInt();
         int count = 0;
         int move = 0;
         for (int i = 0; i<moves.length; i++){
            if(moves[i]){
               count ++;
            }
            if (count == dir){
               move = i;
               break; //save i val
            }
         }
      }
   }
}