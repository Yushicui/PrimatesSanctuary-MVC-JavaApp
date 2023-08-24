package sanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for managing the sanctuary's operations.
 */
public class Controller {
  private Sanctuary sanctuary;
  private View view;

  /**
   * Constructor to initialize the Controller with the given Sanctuary and View.
   * @param sanctuary The Sanctuary object to be managed.
   * @param view      The View object for displaying information.
   */
  public Controller(Sanctuary sanctuary, View view) {
    this.sanctuary = sanctuary;
    this.view = view;
    this.initView();
  }

  /**
   * Initialize the View by binding actions to buttons.
   */
  private void initView() {
    view.getRegisterMonkeyButton().addActionListener(e -> registerMonkey());
    view.getMoveToEnclosureButton().addActionListener(e -> moveToEnclosure());
    view.getListEnclosureButton().addActionListener(e -> listMonkeysInAllEnclosure());
    view.getListEachEnclosureButton().addActionListener(e -> listMonkeysInEachEnclosure());
    view.getListAllMonkeysButton().addActionListener(e -> listAllMonkeys());
  }

  /**
   * Method to register a new monkey.
   */
  public void registerMonkey() {
    try {
      String name = view.getNameField().getText();
      Species species = Species.valueOf((String) view.getSpeciesField().getSelectedItem());
      String sex = (String) view.getSexField().getSelectedItem();
      String size = (String) view.getSizeField().getSelectedItem();
      double weight = Double.parseDouble(view.getWeightField().getText());
      int age = Integer.parseInt(view.getAgeField().getText());
      Food favoriteFood = Food.valueOf((String) view.getFavoriteFoodField().getSelectedItem());
      boolean isHealthy = "Yes".equals((String) view.getIsHealthyField().getSelectedItem());

      Monkey newMonkey = new Monkey(name, species, sex, size, weight, age, favoriteFood, isHealthy);

      if (isMonkeyRegistered(newMonkey)) {
        view.getDisplayArea().setText("Monkey with this name is already registered.");
        return;
      }

      sanctuary.addToIsolation(newMonkey);
      view.getMonkeysInIsolation().addItem(newMonkey);
      view.getDisplayArea().setText("Monkey: " + newMonkey.getName() + " is registered successfully!");
    }
    catch (Exception ex) {
      view.getDisplayArea().setText("Error registering monkey: " + ex.getMessage());
    }
  }


  /**
   * Checks if a monkey is already registered in the sanctuary.
   * @param newMonkey The monkey to check.
   * @return True if the monkey is already registered, otherwise false.
   */
  private boolean isMonkeyRegistered(Monkey newMonkey) {
    List<Monkey> allMonkeys = new ArrayList<>(sanctuary.getIsolation().getMonkeys());
    for (Enclosures enclosure : sanctuary.getEnclosures()) {
      allMonkeys.addAll(enclosure.getMonkeys());
    }
    return allMonkeys.stream().anyMatch(monkey -> monkey.getName().equals(newMonkey.getName()));
  }


  /**
   * Moves a selected monkey to an enclosure.
   */
  public void moveToEnclosure() {
    try {
      Monkey selectedMonkey = view.getSelectedMonkey();
      sanctuary.moveToEnclosure(selectedMonkey);
      view.getMonkeysInIsolation().removeItem(selectedMonkey);
      view.getDisplayArea().setText("Monkey: " + selectedMonkey.getName() + " moved to enclosure successfully!");
    } catch (Exception ex) {
      view.getDisplayArea().setText("Error moving monkey to enclosure: " + ex.getMessage());
    }
  }

  /**
   * Lists all monkeys in all enclosures.
   */
  private void listMonkeysInAllEnclosure() {
    try {
      String enclosureList = sanctuary.monkeysInAllEnclosures();
      view.getDisplayArea().setText(enclosureList);
    } catch (Exception ex) {
      view.getDisplayArea().setText("Error listing monkeys in enclosures: " + ex.getMessage());
    }
  }

  /**
   * Lists monkeys in a specific enclosure based on species.
   */
  private void listMonkeysInEachEnclosure() {
    try {
      Species species = Species.valueOf((String) view.getSpeciesForEnclosureField().getSelectedItem());
      String enclosureList = sanctuary.monkeysInOneEnclosure(species);
      view.getDisplayArea().setText(enclosureList);
    } catch (Exception ex) {
      view.getDisplayArea().setText("Error listing monkeys in enclosure: " + ex.getMessage());
    }
  }

  /**
   * Lists all monkeys in the sanctuary.
   */
  private void listAllMonkeys() {
    try {
      String allMonkeysList = sanctuary.allMonkeysList();
      view.getDisplayArea().setText(allMonkeysList);
    } catch (Exception ex) {
      view.getDisplayArea().setText("Error listing all monkeys: " + ex.getMessage());
    }
  }

  /**
   * Main method to initialize the Controller with a View and Sanctuary.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    View view = new View();
    Sanctuary sanctuary = new Sanctuary();
    Controller controller = new Controller(sanctuary, view);
  }
}

