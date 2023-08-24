import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sanctuary.Food;
import sanctuary.Monkey;
import sanctuary.Sanctuary;
import sanctuary.Species;
import sanctuary.Status;

class SanctuaryTest {
  private Sanctuary sanctuary = new Sanctuary();
  private Monkey monkey1, monkey2, monkey3, monkey4, monkey5, monkey21;

  @BeforeEach
  void setUp() {
    monkey1 = new Monkey("MonkeyA", Species.DRILL, "M", "Medium", 50.0, 2, Food.FRUITS,false);
    monkey2 = new Monkey("MonkeyB", Species.GUEREZA, "F", "Small", 25.0, 5, Food.EGGS, true);
    monkey3 = new Monkey("MonkeyC", Species.HOWLER, "F", "Large", 90.0, 4, Food.INSECTS, false);
    monkey4 = new Monkey("MonkeyD", Species.SAKI, "M", "Large", 86.0, 7, Food.TREESAP, true);
    monkey5 = new Monkey("MonkeyE", Species.SQUIRREL, "M", "Large", 70.0, 5, Food.TREESAP, true);
    monkey21 = new Monkey("MonkeyF", Species.MANGABEY, "F", "Medium", 45.0, 11, Food.SEEDS, true);
  }


  /**
   * Test that monkeys are created correctly
   */
  @Test
  public void testCreateMonkey() {
    assertNotNull(monkey1);
    assertEquals("MonkeyA", monkey1.getName());
    assertEquals(Species.DRILL, monkey1.getSpecies());
    assertEquals("M", monkey1.getSex());
    assertEquals("Medium", monkey1.getSize());
    assertEquals(50.0, monkey1.getWeight());
    assertEquals(2, monkey1.getAge());
    assertEquals(Food.FRUITS, monkey1.getFavoriteFood());
    assertFalse(monkey1.isHealthy());
  }

  /**
   * Test that verifies that an exception is thrown if creating an invalid monkey is attempted
   */
  @Test
  public void testCreateInvalidMonkey() {
    assertThrows(IllegalArgumentException.class, () -> {
      Monkey invalidMonkey = new Monkey("Monkey1", null, "M", "Small", 10.0, -1, Food.FRUITS, false);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      Monkey invalidMonkey = new Monkey("", Species.GUEREZA, "F", "Medium", 20.0, 3, Food.EGGS, true);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      Monkey invalidMonkey = new Monkey("Monkey2", Species.GUEREZA, "F", "Medium", 0, -1, Food.EGGS, true);
    });
  }


  /**
   * Test that verifies that a monkey can be added to isolation successfully
   */
  @Test
  public void testAddToIsolation() {
    sanctuary.addToIsolation(monkey1);
    sanctuary.addToIsolation(monkey2);
    sanctuary.addToIsolation(monkey3);
    sanctuary.addToIsolation(monkey4);
    assertEquals(Status.ISOLATION, monkey1.getStatus());
    assertEquals(Status.ISOLATION, monkey2.getStatus());
    assertEquals(Status.ISOLATION, monkey3.getStatus());
    assertEquals(Status.ISOLATION, monkey4.getStatus());

    /**
     * Test that verifies that same monkey cannot be added duplicate times.
     */
    assertThrows(IllegalArgumentException.class, () -> sanctuary.addToIsolation(monkey1));
  }


  /**
   * Test that verifies that a monkey cannot be added to isolation if it is already full
   */
  @Test
  public void testIsolationFull() {
    assertDoesNotThrow(() -> {
      for (int i = 0; i < 20; i++) {
        sanctuary.addToIsolation(new Monkey("Monkey" + i, Species.DRILL, "M", "Medium", 50.0, 2, Food.FRUITS,false));
      }
    });
    assertThrows(IllegalArgumentException.class, () -> sanctuary.addToIsolation(monkey21));
  }


  /**
   * Test that verifies that a monkey cannot be added to an enclosure if has not been labelled as healthy
   */
  @Test
  public void testAddToEnclosureInvalidHealthStatus() {
    sanctuary.addToIsolation(monkey1);
    assertThrows(IllegalArgumentException.class, () -> sanctuary.moveToEnclosure(monkey1));
  }

  /**
   * Test that verifies that a monkey can be moved from isolation to an enclosure
   */
  @Test
  public void testMoveFromIsolationToEnclosure() {
    sanctuary.addToIsolation(monkey1);
    assertFalse(monkey1.isHealthy());
    assertEquals(Status.ISOLATION, monkey1.getStatus());

    monkey1.healedMonkey();
    assertTrue(monkey1.isHealthy());

    sanctuary.moveToEnclosure(monkey1);
    assertEquals(Status.ENCLOSURE, monkey1.getStatus());

    sanctuary.addToIsolation(monkey2);
    assertEquals(Status.ISOLATION, monkey2.getStatus());
    sanctuary.moveToEnclosure(monkey2);
    assertEquals(Status.ENCLOSURE, monkey2.getStatus());
  }

  /**
   * Test that verifies that the report of species that are currently being housed in the sanctuary is correct
   */
  @Test
  public void testSpeciesHousedInSanctuary() {
    sanctuary.addToIsolation(monkey2);
    sanctuary.addToIsolation(monkey4);
    sanctuary.addToIsolation(monkey5);

    sanctuary.moveToEnclosure(monkey2);
    sanctuary.moveToEnclosure(monkey4);
    sanctuary.moveToEnclosure(monkey5);

    String speciesReport = sanctuary.monkeysInAllEnclosures();
    assertTrue(speciesReport.contains(Species.GUEREZA.toString()));
    assertTrue(speciesReport.contains(Species.SAKI.toString()));
    assertTrue(speciesReport.contains(Species.SQUIRREL.toString()));
    assertFalse(speciesReport.contains(Species.DRILL.toString()));
  }

  /**
   * Test that verifies the list for a given enclosure is correct
   */
  @Test
  public void testMonkeysInOneEnclosureList() {
    sanctuary.addToIsolation(monkey2);
    sanctuary.addToIsolation(monkey4);
    sanctuary.moveToEnclosure(monkey2);
    sanctuary.moveToEnclosure(monkey4);

    String enclosureList1 = sanctuary.monkeysInOneEnclosure(Species.GUEREZA);
    assertTrue(enclosureList1.contains("Name: MonkeyB"));

    String enclosureList2 = sanctuary.monkeysInOneEnclosure(Species.SAKI);
    assertTrue(enclosureList2.contains("Name: MonkeyD"));
  }

  /**
   * Test that verifies the list of all monkeys housed in the Sanctuary is ordered by name
   */
  @Test
  public void testAllMonkeysListOrderedByName() {
    sanctuary.addToIsolation(monkey4);
    sanctuary.addToIsolation(monkey2);
    sanctuary.addToIsolation(monkey5);
    sanctuary.addToIsolation(monkey3);
    sanctuary.addToIsolation(monkey1);

    sanctuary.moveToEnclosure(monkey2);
    sanctuary.moveToEnclosure(monkey4);

    String monkeysList = sanctuary.allMonkeysList();

    assertTrue(monkeysList.contains("Name: MonkeyA"));
    assertTrue(monkeysList.contains("Name: MonkeyB"));
    assertTrue(monkeysList.contains("Name: MonkeyC"));
    assertTrue(monkeysList.contains("Name: MonkeyD"));
    assertTrue(monkeysList.contains("Name: MonkeyE"));

    int indexOfMonkey1 = monkeysList.indexOf("Name: MonkeyA");
    int indexOfMonkey2 = monkeysList.indexOf("Name: MonkeyB");
    int indexOfMonkey3 = monkeysList.indexOf("Name: MonkeyC");
    int indexOfMonkey4 = monkeysList.indexOf("Name: MonkeyD");
    int indexOfMonkey5 = monkeysList.indexOf("Name: MonkeyE");
    assertTrue(indexOfMonkey1 < indexOfMonkey2);
    assertTrue(indexOfMonkey2 < indexOfMonkey3);
    assertTrue(indexOfMonkey3 < indexOfMonkey4);
    assertTrue(indexOfMonkey4 < indexOfMonkey5);
  }
}