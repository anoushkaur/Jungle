public class Cat extends Animal {
   public Cat(int owner){
      super(false, Animal.CAT, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("CAT(" + GetRank() +")"); //player 1 
      }
      return ("cat(" + GetRank() +")"); //player 2
   }
   
}