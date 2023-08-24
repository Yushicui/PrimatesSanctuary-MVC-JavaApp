package sanctuary;

/**
 * Class representing a Monkey in the sanctuary.
 * Each monkey has a name, species, sex, size, weight, age, favorite food, health condition and a housing status.
 */
public class Monkey {
  private String name;
  private Species species;
  private String sex;
  private String size;
  private double weight;
  private int age;
  private Food favoriteFood;
  private boolean isHealthy;
  private Status status;

  /**
   * Constructor for creating a new Monkey.
   * @param name The name of the monkey.
   * @param species The species of the monkey.
   * @param sex The sex of the monkey.
   * @param size The size of the monkey.
   * @param weight The weight of the monkey.
   * @param age The age of the monkey.
   * @param favoriteFood The favorite food of the monkey.
   * @param isHealthy The health condition of the monkey.
   */
  public Monkey(String name, Species species,
                String sex, String size, double weight,
                int age, Food favoriteFood, boolean isHealthy){
    if(name.isEmpty() || sex.isEmpty() || size.isEmpty() ||
            weight <= 0 || age < 0 || species == null ||
            favoriteFood == null){
      throw new IllegalArgumentException("Information cannot be empty");
    }
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favoriteFood = favoriteFood;
    this.isHealthy = isHealthy;
    this.status = null;
  }

  /**
   * Get the name of the monkey.
   * @return The name of the monkey.
   */
  public String getName(){
    return this.name;
  }

  /**
   * Get the sex of the monkey.
   * @return The sex of the monkey.
   */
  public String getSex(){
    return this.sex;
  }

  /**
   * Get the size of the monkey.
   * @return The size of the monkey.
   */
  public String getSize(){
    return this.size;
  }

  /**
   * Get the weight of the monkey.
   * @return The weight of the monkey.
   */
  public double getWeight(){
    return this.weight;
  }

  /**
   * Get the age of the monkey.
   * @return The age of the monkey.
   */
  public int getAge(){
    return this.age;
  }

  /**
   * Get the favorite food of the monkey.
   * @return The favorite food of the monkey.
   */
  public Food getFavoriteFood(){
    return this.favoriteFood;
  }

  /**
   * Get the species of the monkey.
   * @return The species of the monkey.
   */
  public Species getSpecies(){
    return this.species;
  }

  /**
   * Set the housing status of the monkey, either in Isolation or Enclosure.
   */
  public void setStatus(Status status){
    this.status = status;
  }

  /**
   * Get the housing status of the monkey.
   * @return The housing status of the monkey.
   */
  public Status getStatus(){
    return this.status;
  }

  /**
   * Set the monkey's health status to healthy.
   */
  public void healedMonkey() {
    this.isHealthy = true;
  }

  /**
   * Check if the monkey is healthy.
   * @return True if the monkey is healthy, false otherwise.
   */
  public boolean isHealthy() {
    return this.isHealthy;
  }

  /**
   * toString method to represent the monkey as a string.
   * @return A string representation of the monkey.
   */
  @Override
  public String toString() {
    if (isHealthy()){
      return name + ", Healthy";
    }
    return name + ", Unhealthy";
  }
}
