public class Player {
   private int id;
   private Animal[] animals;
   
   // DEVELOPED BY: SOFEA
   public Player(int id){
      this.id = id;
      animals = new Animal[8];
      animals[0] = new Rat(id);
      animals[1] = new Cat(id);
      animals[2] = new Wolf(id);
      animals[3] = new Dog(id);
      animals[4] = new Leopard(id);
      animals[5] = new Tiger(id);
      animals[6] = new Lion(id);
      animals[7] = new Elephant(id);
   }
   
   // DEVELOPED BY: SOFEA
   public int GetId(){
      return this.id;
   }
   
   // DEVELOPED BY: SOFEA
   public void SetId(int id){
      this.id = id;
   }
   
   // DEVELOPED BY: SOFEA
   public Animal[] GetAnimals(){
      return this.animals;
   }
   
   // DEVELOPED BY: SOFEA
   public void RemoveAnimal(Animal a){
      for( int i = 0; i < animals.length; i++ ) {
         if(this.animals[i] != null && this.animals[i].GetRank() == a.GetRank()){
            animals[i] = null;
         }
      }
   }
   
   // DEVELOPED BY: SOFEA
   public boolean isDeadAnimals(){
      for (int i = 0; i<animals.length; i++){
         if (this.animals[i] != null){
         return false;
         }
      }
      return true;
   }
}