public class Rat extends Animal {   
   public Rat(int owner){
      super(true, Animal.RAT, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("RAT(" + GetRank() +")"); //player 1 
      }
      return ("rat(" + GetRank() +")"); //player 2
   }
}