package problem2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Swimmer implements Comparable<Swimmer> {

  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breastStroke50mTimes;
  private List<Double> freestyle50mTimes;
  private static final int BUTTERFLY_RACES_CUTOFF = 5;
  private static final double QUALIFYING_CUTOFF = 26.57;

  public Swimmer(String name, List<Double> butterfly50mTimes,
      List<Double> backstroke50mTimes, List<Double> breastStroke50mTimes,
      List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breastStroke50mTimes = breastStroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }

  public List<Double> getBreastStroke50mTimes() {
    return breastStroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  private Double computeAverageSwimTime(List<Double> swimTimes) {
    Double averageTime = 0d;
    for (Double swimTime : swimTimes) {
      averageTime += swimTime;
    }
    return averageTime / swimTimes.size();
  }

  Comparator<Swimmer> fastestButterflyTime = new Comparator<Swimmer>() {
    @Override
    public int compare(Swimmer o1, Swimmer o2) {
      return 0;
    }
  };

  @Override
  public int compareTo(Swimmer otherSwimmer) {
    return Double.compare(this.computeAverageSwimTime(this.freestyle50mTimes),
        otherSwimmer.computeAverageSwimTime(this.freestyle50mTimes));
  }

  public boolean hasEnoughButterflyRaces() {
    return this.butterfly50mTimes.size() >= BUTTERFLY_RACES_CUTOFF;
  }

  public boolean isQualified() {
    Collections.sort(this.freestyle50mTimes);
    return this.getFreestyle50mTimes().get(0) <= QUALIFYING_CUTOFF;
  }
}
