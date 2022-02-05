package p1;

import java.util.Objects;

/**
 * Class Runner stores information of a runner. This class inherited from Athlete class.
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favRunningEvent;

  /**
   * Constructor for the class Runner.
   *
   * @param athletesName         - Name, runner's name represented as a string.
   * @param height               - Double, runner's height.
   * @param weight               - Double, runner's weight.
   * @param league               - String, runner's league.
   * @param best5KTime           - Double, runner's best5KTime.
   * @param bestHalfMarathonTime - Double, runner's bestHalfMarathonTime.
   * @param favRunningEvent      - String, runner's favorite runnning event.
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double bestHalfMarathonTime, String favRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favRunningEvent = favRunningEvent;
  }

  /**
   * Getter for best 5k time.
   *
   * @return Double, the runner's best 5k running time.
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * Setter for best 5k time.
   *
   * @param best5KTime - Double, the new runner's best 5k running time.
   */
  public void setBest5KTime(Double best5KTime) {
    this.best5KTime = best5KTime;
  }

  /**
   * Getter for best half marathon time.
   *
   * @return Double, the runner's best half marathon time.
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * Setter for best half marathon time.
   *
   * @param bestHalfMarathonTime - Double, the new runner's best half marathon time.
   */
  public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  /**
   * Getter for runner's favorite running event.
   *
   * @return String, the runner's favorite running event.
   */
  public String getFavRunningEvent() {
    return favRunningEvent;
  }

  /**
   * Setter for runner's favorite running event.
   *
   * @param favRunningEvent - String, the new runner's favorite running event.
   */
  public void setFavRunningEvent(String favRunningEvent) {
    this.favRunningEvent = favRunningEvent;
  }

  /**
   * Compare whether two objects are equal and belong to the same Runner class.
   *
   * @param o - Object, the object to be compared with the current object.
   * @return Boolean, whether the two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Runner)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(getBest5KTime(), runner.getBest5KTime())
        && Objects.equals(getBestHalfMarathonTime(), runner.getBestHalfMarathonTime())
        && Objects.equals(getFavRunningEvent(), runner.getFavRunningEvent());
  }

  /**
   * Generate the hashcode of the Runner object.
   *
   * @return int, the hashcode of the Runner object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBest5KTime(), getBestHalfMarathonTime(),
        getFavRunningEvent());
  }
}
