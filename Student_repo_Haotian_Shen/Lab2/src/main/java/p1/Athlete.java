package p1;

import java.util.Objects;

public class Athlete {

  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  public Athlete() {
  }

  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  public Name getAthletesName() {
    return athletesName;
  }

  public void setAthletesName(Name athletesName) {
    this.athletesName = athletesName;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Athlete)) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(getAthletesName(), athlete.getAthletesName())
        && Objects.equals(getHeight(), athlete.getHeight()) && Objects.equals(
        getWeight(), athlete.getWeight()) && Objects.equals(getLeague(),
        athlete.getLeague());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAthletesName(), getHeight(), getWeight(), getLeague());
  }
}


