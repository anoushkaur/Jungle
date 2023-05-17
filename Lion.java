public class Lion extends Animal {

   public Lion(int owner){
      super(false, Animal.LION, false, owner);
   }
   
   public String toString(){
      if (this.GetOwner() == GameSystem.P1){
         return ("LIO(" + GetRank() +")"); //player 1 
      }
      return ("lio(" + GetRank() +")"); //player 2
   }
   
}