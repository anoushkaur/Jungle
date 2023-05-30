public class Player {
   private int id;
   private Animal[] animals;
   
   // DEVELOPED BY: SOFEA
   /**
    * Constructor for the Player class.
    *
    * @param id The player's ID.
    */
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
   /**
    * Retrieves the ID of the player.
    *
    * @return The player's ID.
    */
   public int GetId(){
      return this.id;
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Sets the ID of the player.
    *
    * @param id The player's ID.
    */
   public void SetId(int id){
      this.id = id;
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Retrieves the array of animals owned by the player.
    *
    * @return The array of animals.
    */
   public Animal[] GetAnimals(){
      return this.animals;
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Removes the specified animal from the player's array of animals.
    *
    * @param a The animal to be removed.
    */
   public void RemoveAnimal(Animal a){
      for( int i = 0; i < animals.length; i++ ) {
         if(this.animals[i] != null && this.animals[i].GetRank() == a.GetRank()){ // Compare the rank of i and specified animal
            animals[i] = null; // Set the animal at index i to null, effectively removing it from the array.
         }
      }
   }
   
   // DEVELOPED BY: SOFEA
   /**
    * Checks if ALL the animals owned by the player are dead.
    *
    * @return true if all animals are dead, false otherwise.
    */
   public boolean isDeadAnimals(){
      for (int i = 0; i<animals.length; i++){
         if (this.animals[i] != null){ // Check if the animal at index i is not null (i.e., it exists).
         return false; //  If there is at least one non-null animal, return false (not all animals are dead).
         }
      }
      return true; // All animals are null (dead), so return true.
   }
}