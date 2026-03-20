import java.util.Arrays;
import java.util.List;

public class IteratorTest {
  public static void main(String[] args) {
    Swimmer swimmer1 = new Swimmer(
        "Alice",
        Arrays.asList(30.1, 30.2, 30.3, 30.4, 30.5),
        Arrays.asList(26.5, 26.0, 27.0)
    );

    Swimmer swimmer2 = new Swimmer(
        "Bob",
        Arrays.asList(31.1, 31.2, 31.3),
        Arrays.asList(25.9, 26.0)
    );

    Swimmer swimmer3 = new Swimmer(
        "Cathy",
        Arrays.asList(29.1, 29.2, 29.3, 29.4, 29.5),
        Arrays.asList(27.2, 27.5, 28.0)
    );

    Swimmer swimmer4 = new Swimmer(
        "David",
        Arrays.asList(28.1, 28.2, 28.3, 28.4, 28.5),
        Arrays.asList(26.1, 27.0)
    );

    List<Swimmer> swimmers = Arrays.asList(swimmer1, swimmer2, swimmer3, swimmer4);

    SwimmersIterator iterator = new SwimmersIterator(swimmers);

    while (iterator.hasNext()) {
      Swimmer s = iterator.next();
      System.out.println(s.getName());
    }
  }
}
