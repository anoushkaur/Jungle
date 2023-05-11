public class Elephant extends Animal{
   public Elephant(int owner){
      super(false, Animal.ELEPHANT, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("ELE(" + GetRank() +")"); //player 1 
      }
      return ("ele(" + GetRank() +")"); //player 2
   }
}