package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class representing an enclosure for a specific species of monkeys in the sanctuary.
 */
public class Enclosures implements EnclosuresHousing {

  private List<Monkey> monkeys;
  private Species speciesType;

  /**
   * Constructor for creating a new Enclosure for a specific monkey species.
   * @param speciesType The species of monkeys that the enclosure can house.
   */
  public Enclosures(Species speciesType){
    this.monkeys = new ArrayList<>();
    this.speciesType = speciesType;
  }

  /**
   * Get the species of monkeys that the enclosure can house.
   * @return The species of monkeys for the enclosure.
   */
  @Override
  public Species getSpeciesType() {
    return this.speciesType;
  }

  /**
   * Add a monkey to the enclosure if it belongs to the appropriate species.
   * The monkey's status will be updated to ENCLOSURE.
   * @param monkey The monkey to be added to the enclosure.
   */
  @Override
  public void addMonkey(Monkey monkey) {
    if(monkey.getSpecies().equals(this.speciesType)){
      if(monkey.isHealthy()){
        this.monkeys.add(monkey);
        monkey.setStatus(Status.ENCLOSURE);
      }
    }
  }

  /**
   * Get the list of monkeys currently in the enclosure.
   * @return A list of monkeys in the enclosure.
   */
  @Override
  public List<Monkey> getMonkeys() {
    return this.monkeys;
  }

  /**
   * Lists the monkeys currently in the enclosure.
   * @return A formatted string containing monkeys' name, sex, and favorite food.
   */
  @Override
  public String listMonkeys(){
    this.monkeys.sort(Comparator.comparing(Monkey::getName));
    StringBuilder monkeysList = new StringBuilder();
    for (Monkey monkey : this.monkeys) {
      monkeysList.append("Name: ").append(monkey.getName())
                .append(", Sex: ").append(monkey.getSex())
                .append(", Favorite Food: ").append(monkey.getFavoriteFood())
                .append("\n");
    }
    return monkeysList.toString();
  }
}
