package sanctuary;

import java.util.List;

/**
 * Interface representing Enclosure facilities for monkeys in the sanctuary.
 * The interface defines methods to get the species type of the enclosure,
 * add a monkey, get the list of monkeys and list the monkeys in the isolation.
 */
public interface EnclosuresHousing {

  /**
   * Gets the species type of the enclosure.
   * @return The species type of the enclosure.
   */
  Species getSpeciesType();

  /**
   * Adds a monkey to the housing facility.
   * @param monkey The monkey to be added.
   */
  void addMonkey(Monkey monkey);


  /**
   * Gets the list of monkeys currently in the housing facility.
   * @return A list of monkeys in the housing.
   */
  List<Monkey> getMonkeys();


  /**
   * Displays the list of monkeys currently in the enclosure.
   */
  String listMonkeys();
}
