package problem2;

import java.util.Comparator;

public class TotalSwimMeetsComparator implements Comparator<Swimmer> {

  @Override
  public int compare(Swimmer o1, Swimmer o2) {
    return getNumberOfMeets(o1) - getNumberOfMeets(o2);
  }

  private int getNumberOfMeets(Swimmer swimmer) {
    return swimmer.getFreestyle50mTimes().size() + swimmer.getButterfly50mTimes().size()
        + swimmer.getBackstroke50mTimes().size() + swimmer.getBreastStroke50mTimes().size();

  }
}
