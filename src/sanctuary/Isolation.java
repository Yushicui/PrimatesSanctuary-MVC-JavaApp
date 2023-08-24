package sanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the isolation housing for monkeys in the sanctuary.
 */
public class Isolation implements IsolationHousing {
  private List<Monkey> monkeys;
  private int cageCapacity = 20;

  /**
   * Constructor for creating a new Isolation housing.
   * Initializes an empty list of monkeys in isolation.
   */
  public Isolation() {
    this.monkeys = new ArrayList<>();
  }

  /**
   * Add a monkey to the isolation housing.
   * @param monkey The monkey to be added.
   * @throws IllegalArgumentException if the isolation housing is already at full capacity.
   * @throws IllegalArgumentException if the monkey already added in the isolation.
   */
  @Override
  public void addMonkey(Monkey monkey) {
    if (this.monkeys.size() >= cageCapacity) {
      throw new IllegalArgumentException("Cages in the Isolation are full");
    }
    if(this.monkeys.contains(monkey)){
      throw new IllegalArgumentException("Monkey is already added!");
    }
    this.monkeys.add(monkey);
    monkey.setStatus(Status.ISOLATION);
  }

  /**
   * Remove a monkey from the isolation housing.
   * @param monkey The monkey to be removed.
   * @throws IllegalArgumentException if the monkey is not healthy.
   */
  @Override
  public void removeMonkey(Monkey monkey) {
    if(!monkey.isHealthy()){
      throw new IllegalArgumentException("Monkey is unhealthy.");
    }
    this.monkeys.remove(monkey);
  }

  /**
   * Get the list of monkeys currently in the isolation housing.
   * @return A list of monkeys in isolation.
   */
  @Override
  public List<Monkey> getMonkeys() {
    return this.monkeys;
  }
}
