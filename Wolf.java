public class Wolf extends Animal {
   public Wolf(int owner){
      super(false, Animal.WOLF, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("WOL(" + GetRank() +")"); //player 1 
      }
      return ("wol(" + GetRank() +")"); //player 2
   }
   
}