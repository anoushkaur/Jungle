public class Jungle {
   public static void main(String[] args){
     // Animal a = new Rat(GameSystem.P2);
    //  System.out.print(a);
      GameSystem gs = new GameSystem();
      Displayer disp = new Displayer();
      disp.PrintBoard(gs.GetBoard());
      System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[0]);
      System.out.println(gs.GetAnimalPos(gs.GetCurrPlayer().GetAnimals()[6])[1]);
   }
}