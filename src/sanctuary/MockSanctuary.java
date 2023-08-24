package sanctuary;

public class MockSanctuary extends Sanctuary {
  private String log = "";

  @Override
  public void addToIsolation(Monkey monkey) {
    log += monkey.toString() + "\n";
    super.addToIsolation(monkey);
  }

  public String getLog() {
    return log;
  }
}
