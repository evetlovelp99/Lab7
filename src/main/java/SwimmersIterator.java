import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SwimmersIterator implements Iterator<Swimmer> {
  private static final double OLYMPIC_QUALIFYING_TIME = 26.17;

  private List<Swimmer> swimmers;
  private int currentIndex;

  public SwimmersIterator(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
    this.currentIndex = 0;
    moveToNextValid();
  }

  private void moveToNextValid() {
    while (currentIndex < swimmers.size() && !isValid(swimmers.get(currentIndex))) {
      currentIndex++;
    }
  }

  private boolean isValid(Swimmer swimmer) {
    if (swimmer.getButterfly50mTimes().size() < 5) {
      return false;
    }

    for (Double time : swimmer.getFreestyle50mTimes()) {
      if (time <= OLYMPIC_QUALIFYING_TIME) {
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean hasNext() {
    return currentIndex < swimmers.size();
  }

  @Override
  public Swimmer next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    Swimmer result = swimmers.get(currentIndex);
    currentIndex++;
    moveToNextValid();
    return result;
  }
}
