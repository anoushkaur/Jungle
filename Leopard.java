public class Leopard extends Animal { 

   public Leopard(int owner){
      super(false, Animal.LEOPARD, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("LEO(" + GetRank() +")"); //player 1 
      }
      return ("leo(" + GetRank() +")"); //player 2
   }
   
}