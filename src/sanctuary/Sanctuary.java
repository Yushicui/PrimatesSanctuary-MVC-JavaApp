package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The Sanctuary class represents the primate sanctuary for monkeys.
 * It includes facilities for isolation and enclosures, where monkeys can be housed.
 */
public class Sanctuary {
  private Isolation isolation;
  private Enclosures[] enclosures;

  /**
   * Constructor for creating a new Sanctuary.
   * Initializes isolation and enclosure facilities for monkeys of different species.
   */
  public Sanctuary(){
    this.isolation = new Isolation();
    this.enclosures = new Enclosures[Species.values().length];
    for (int i = 0; i < Species.values().length; i ++){
      enclosures[i] = new Enclosures(Species.values()[i]);
    }
  }

  /**
   * Add a monkey to the isolation facility.
   * @param monkey The monkey to be added to isolation.
   */
  public void addToIsolation(Monkey monkey){
    this.isolation.addMonkey(monkey);
  }

  /**
   * Move a monkey from isolation to the appropriate enclosure.
   * @param monkey The monkey to be moved to the enclosure.
   * @throws IllegalArgumentException if the monkey is not found.
   */
  public void moveToEnclosure(Monkey monkey) {
    if(monkey == null){
      throw new IllegalArgumentException("Monkey is not found!");
    }
    else {
      if(monkey.getStatus().equals(Status.ISOLATION)){
        for(Enclosures enclosure : enclosures){
          isolation.removeMonkey(monkey);
          enclosure.addMonkey(monkey);
        }
      }
    }
  }

  /**
   * List monkeys housed in an enclosure of the given species.
   * @param species The species of the enclosure for which to produce the list.
   * @return A formatted string containing monkeys' name, sex, and favorite food.
   */
  public String monkeysInOneEnclosure(Species species) {
    StringBuilder enclosureList = new StringBuilder();
    for (Enclosures enclosure : enclosures) {
      if (enclosure.getSpeciesType() == species) {
        if (!enclosure.getMonkeys().isEmpty()) {
          enclosureList.append("Enclosure for ").append(enclosure.getSpeciesType()).append(":\n");
          enclosureList.append(enclosure.listMonkeys());
        }
        else{
          enclosureList.append("Enclosure for ").append(enclosure.getSpeciesType()).append(" is empty.");
        }
      }
    }
    return enclosureList.toString();
  }

  /**
   * List all the monkeys currently housed in each enclosure.
   * @return A formatted string containing monkeys' name, sex, and favorite food.
   */
  public String monkeysInAllEnclosures() {
    StringBuilder enclosureList = new StringBuilder();
    for (Enclosures enclosure : enclosures) {
      if(!enclosure.getMonkeys().isEmpty()){
        enclosureList.append("\nEnclosure for ").append(enclosure.getSpeciesType()).append(":\n");
        enclosureList.append(enclosure.listMonkeys());
      }
      else{
        enclosureList.append("\nEnclosure for ").append(enclosure.getSpeciesType()).append(" is empty.\n");
      }
    }
    return enclosureList.toString();
  }

  /**
   * List all the monkeys housed in the entire sanctuary.
   * The list will be sorted alphabetically by the names of the monkeys.
   * @return A formatted string containing monkeys' name, sex, and favorite food.
   */
  public String allMonkeysList() {
    List<Monkey> allMonkeys = new ArrayList<>();
    allMonkeys.addAll(isolation.getMonkeys());
    for (Enclosures enclosure : enclosures) {
      allMonkeys.addAll(enclosure.getMonkeys());
    }
    allMonkeys.sort(Comparator.comparing(Monkey::getName));

    StringBuilder allMonkeysList = new StringBuilder();

    allMonkeysList.append("All monkeys housed in the Sanctuary:\n");
    for(Monkey monkey : allMonkeys) {
      allMonkeysList.append("Name: ").append(monkey.getName())
              .append(", Sex: ").append(monkey.getSex())
              .append(", Favorite Food: ").append(monkey.getFavoriteFood())
              .append(", Housing Status: ").append(monkey.getStatus())
              .append("\n");
    }
    return allMonkeysList.toString();
  }

  /**
   * Retrieves the Isolation object associated with this instance.
   * @return The Isolation object.
   */
  public Isolation getIsolation(){
    return this.isolation;
  }

  /**
   * Retrieves an array of Enclosures associated with this instance.
   * @return An array of Enclosures.
   */
  public Enclosures[] getEnclosures(){
    return this.enclosures;
  }
}

