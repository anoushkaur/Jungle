public class Player {
   private int id;
   private Animal[] animals;
   
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
   
   public int GetId(){
      return this.id;
   }
   
   public void SetId(int id){
      this.id = id;
   }
      
   public Animal[] GetAnimals(){
      return this.animals;
   }
   
   public void RemoveAnimal(Animal a){
      for( int i = 0; i < animals.length; i++ ) {
         if(this.animals[i] != null && this.animals[i].GetRank() == a.GetRank()){
            animals[i] = null;
         }
      }
   }
   
   public boolean isDeadAnimals(){
      for (int i = 0; i<animals.length; i++){
         if (this.animals[i] != null){
         return false;
         }
      }
      return true;
   }
}