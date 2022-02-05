package p1;

import java.util.Objects;

/**
 * Class BaseballPlayer stores information of a baseball player. This class inherited from Athlete
 * class.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  /**
   * Constructor for the class BaseballPlayer.
   *
   * @param athletesName   - Name, player's name represented as a string of first and last name.
   * @param height         - Double, player's height.
   * @param weight         - Double, player's weight.
   * @param league         - String, player's league.
   * @param team           - String, player's team.
   * @param averageBatting - Double, player's average batting.
   * @param seasonHomeRuns - Integer, player's seasonal home runs.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Getter for team.
   *
   * @return String, the baseball player's team.
   */
  public String getTeam() {
    return team;
  }

  /**
   * Setter for team.
   *
   * @param team - String, the new baseball player's team.
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * Getter for average batting.
   *
   * @return Double, the baseball player's average batting.
   */
  public Double getAverageBatting() {
    return averageBatting;
  }

  /**
   * Setter for average batting.
   *
   * @param averageBatting - Double, the new baseball player's average batting.
   */
  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  /**
   * Getter for seasonal home runs.
   *
   * @return Integer, the baseball player's seasonal home runs.
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }

  /**
   * Setter for seasonal home runs.
   *
   * @param seasonHomeRuns - Integer, the baseball player's new seasonal home runs.
   */
  public void setSeasonHomeRuns(Integer seasonHomeRuns) {
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Compare whether two objects are equal and belong to BaseballPlayer class.
   *
   * @param o - Object, the object to be compared with the current object.
   * @return Boolean, whether the two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BaseballPlayer)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(getTeam(), that.getTeam()) && Objects.equals(
        getAverageBatting(), that.getAverageBatting()) && Objects.equals(
        getSeasonHomeRuns(), that.getSeasonHomeRuns());
  }

  /**
   * Generate the hashcode of the current BaseballPlayer object.
   *
   * @return int, the hashcode of the current BaseballPlayer object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTeam(), getAverageBatting(), getSeasonHomeRuns());
  }
}
