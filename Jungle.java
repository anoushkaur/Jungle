import java.util.Scanner;

public class Jungle {
   public static void main(String[] args){
     // Animal a = new Rat(GameSystem.P2);
    //  System.out.print(a);
      GameSystem gs = new GameSystem();
      Displayer disp = new Displayer();
      Scanner input = new Scanner(System.in);
      
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
      }
   }
}