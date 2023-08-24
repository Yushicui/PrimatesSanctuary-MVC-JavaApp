package sanctuary;

import java.util.List;

/**
 * Interface representing isolation housing facilities for monkeys in the sanctuary.
 * The interface defines methods to add a monkey, remove a monkey, and get the list of monkeys in the isolation.
 */
public interface IsolationHousing {

  /**
   * Adds a monkey to the isolation housing.
   * @param monkey The monkey to be added.
   */
  void addMonkey(Monkey monkey);


  /**
   * Removes a monkey from the isolation housing.
   * @param monkey The monkey to be removed.
   */
  void removeMonkey(Monkey monkey);


  /**
   * Gets the list of monkeys currently in the isolation housing.
   * @return A list of monkeys in the isolation.
   */
  List<Monkey> getMonkeys();
}
