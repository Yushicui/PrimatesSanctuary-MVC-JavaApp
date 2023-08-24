package sanctuary;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

/**
 * View class for Primate Sanctuary application.
 * This class represents the UI and contains components to gather input
 * and display information to the user.
 */
public class View extends JFrame {

  private JFrame frame;
  private JTextField nameField, weightField, ageField;
  private JComboBox<String> speciesField, sizeField, sexField, favoriteFoodField, isHealthyField, speciesForEnclosure;
  private JButton registerButton, moveButton, listEnclosureMonkeys, listEachEnclosureMonkeys,listAllMonkeys;
  private JTextArea displayArea;
  private JComboBox<Monkey> monkeysInIsolation;


  /**
   * Constructor to create and initialize the main frame and components.
   */
  public View() {
    frame = new JFrame("Primate Sanctuary");
    frame.setLayout(new BorderLayout());

    frame.setSize(900, 350);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    JPanel formPanel = new JPanel(new GridLayout(10, 2));
    nameField = addField(formPanel, "Name:");
    speciesField = addComboBox(formPanel, "Species:", Arrays.stream(Species.values()).map(Species::name).toArray(String[]::new));
    sexField = addComboBox(formPanel, "Sex:", "Male", "Female");
    sizeField = addComboBox(formPanel, "Size:", "Small", "Medium", "Large");
    weightField = addField(formPanel, "Weight:");
    ageField = addField(formPanel, "Age:");
    favoriteFoodField = addComboBox(formPanel, "Favorite Food:", Arrays.stream(Food.values()).map(Food::name).toArray(String[]::new));
    isHealthyField = addComboBox(formPanel, "Is Healthy", "Yes", "No");
    monkeysInIsolation = addComboBox(formPanel, "Monkeys in Isolation:");
    speciesForEnclosure = addComboBox(formPanel, "Select Enclosure:", Arrays.stream(Species.values()).map(Species::name).toArray(String[]::new));

    frame.add(formPanel, BorderLayout.WEST);

    displayArea = new JTextArea(10, 30);
    displayArea.setEditable(false);
    frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel(new FlowLayout());
    registerButton = new JButton("Register Monkey");
    moveButton = new JButton("Move to Enclosure");
    listEachEnclosureMonkeys = new JButton("View Selected Enclosure");
    listEnclosureMonkeys = new JButton("View All Enclosures");
    listAllMonkeys = new JButton("Vew All Monkeys");
    buttonPanel.add(registerButton);
    buttonPanel.add(moveButton);
    buttonPanel.add(listEachEnclosureMonkeys);
    buttonPanel.add(listEnclosureMonkeys);
    buttonPanel.add(listAllMonkeys);
    frame.add(buttonPanel, BorderLayout.SOUTH);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 350);
    frame.setTitle("Primates Sanctuary");
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Adds a JTextField with a label to the given JPanel.
   * @param panel The JPanel to which the field and label are added.
   * @param label The text for the JLabel.
   * @return The JTextField that was added.
   */
  private JTextField addField(JPanel panel, String label) {
    panel.add(new JLabel(label));
    JTextField textField = new JTextField();
    panel.add(textField);
    return textField;
  }

  /**
   * Adds a JComboBox with a label to the given JPanel.
   * @param panel The JPanel to which the combo box and label are added.
   * @param label The text for the JLabel.
   * @param items The items to be added to the combo box.
   * @return The JComboBox that was added.
   */
  private <T> JComboBox<T> addComboBox(JPanel panel, String label, T... items) {
    panel.add(new JLabel(label));
    JComboBox<T> comboBox = new JComboBox<>(items);
    panel.add(comboBox);
    return comboBox;
  }

  /**
   * Retrieves the button used to register a monkey.
   * @return The button for registering a monkey.
   */
  public JButton getRegisterMonkeyButton() {
    return registerButton;
  }

  /**
   * Retrieves the button used to move a monkey to an enclosure.
   * @return The button for moving a monkey to an enclosure.
   */
  public JButton getMoveToEnclosureButton() {
    return moveButton;
  }

  /**
   * Retrieves the button used to list all monkeys in enclosures.
   * @return The button for listing monkeys in enclosures.
   */
  public JButton getListEnclosureButton() {
    return listEnclosureMonkeys;
  }

  /**
   * Retrieves the button used to list monkeys for a selected enclosure.
   * @return The button for listing monkeys for a selected enclosure.
   */
  public JButton getListEachEnclosureButton() {
    return listEachEnclosureMonkeys;
  }

  /**
   * Retrieves the button used to list all monkeys.
   * @return The button for listing all monkeys.
   */
  public JButton getListAllMonkeysButton() {
    return listAllMonkeys;
  }

  /**
   * Retrieves the selected monkey from the combo box.
   * @return The currently selected monkey from the combo box.
   */
  public Monkey getSelectedMonkey() {return (Monkey) monkeysInIsolation.getSelectedItem();}

  /**
   * Retrieves the text field used for inputting the name.
   * @return The text field for the name.
   */
  public JTextField getNameField() { return nameField; }

  /**
   * Retrieves the combo box used to select the species.
   * @return The combo box for selecting the species.
   */
  public JComboBox<String> getSpeciesField() { return speciesField; }

  /**
   * Retrieves the combo box used to select the sex.
   * @return The combo box for selecting the sex.
   */
  public JComboBox<String> getSexField() { return sexField; }

  /**
   * Retrieves the combo box used to select the size.
   * @return The combo box for selecting the size.
   */
  public JComboBox<String> getSizeField() { return sizeField; }

  /**
   * Retrieves the text field used for inputting the weight.
   * @return The text field for the weight.
   */
  public JTextField getWeightField() { return weightField; }

  /**
   * Retrieves the text field used for inputting the age.
   * @return The text field for the age.
   */
  public JTextField getAgeField() { return ageField; }

  /**
   * Retrieves the combo box used to select the favorite food.
   * @return The combo box for selecting the favorite food.
   */
  public JComboBox<String> getFavoriteFoodField() { return favoriteFoodField; }

  /**
   * Retrieves the combo box used to determine if the monkey is healthy.
   * @return The combo box for determining the health status.
   */
  public JComboBox<String> getIsHealthyField() { return isHealthyField; }

  /**
   * Retrieves the text area used to display information.
   * @return The text area for displaying information.
   */
  public JTextArea getDisplayArea() { return displayArea; }

  /**
   * Retrieves the combo box used to select monkeys in isolation.
   * @return The combo box for selecting monkeys in isolation.
   */
  public JComboBox<Monkey> getMonkeysInIsolation() {
    return monkeysInIsolation;
  }

  /**
   * Retrieves the combo box used to select species for enclosure.
   * @return The combo box for selecting species for enclosure.
   */
  public JComboBox<String> getSpeciesForEnclosureField() { return speciesForEnclosure;}
}
