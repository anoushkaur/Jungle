public class Tiger extends Animal {
   public Tiger(int owner){
      super(false, Animal.TIGER, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("TIG(" + GetRank() +")"); //player 1 
      }
      return ("tig(" + GetRank() +")"); //player 2
   }
   
}