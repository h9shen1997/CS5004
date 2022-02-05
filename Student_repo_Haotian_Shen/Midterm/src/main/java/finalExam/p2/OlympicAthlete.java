package finalExam.p2;

import java.util.Objects;

/**
 * Class OlympicAthlete contains information about Olympic athletes.
 */
public class OlympicAthlete {

  private final String athleteID;
  private final Name athletesName;
  private final String homeCountry;
  private final String sport;
  private final String discipline;
  private final Double qualifyingResult;
  private final Double personalRecord;

  public OlympicAthlete(String athleteID, Name athletesName, String homeCountry, String sport,
      String discipline, Double qualifyingResult, Double personalRecord) {
    this.athleteID = athleteID;
    this.athletesName = athletesName;
    this.homeCountry = homeCountry;
    this.sport = sport;
    this.discipline = discipline;
    this.qualifyingResult = qualifyingResult;
    this.personalRecord = personalRecord;
  }

  public String getAthleteID() {
    return athleteID;
  }

  public Name getAthletesName() {
    return athletesName;
  }

  public String getHomeCountry() {
    return homeCountry;
  }

  public String getSport() {
    return sport;
  }

  public String getDiscipline() {
    return discipline;
  }

  public Double getQualifyingResult() {
    return qualifyingResult;
  }

  public Double getPersonalRecord() {
    return personalRecord;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OlympicAthlete)) {
      return false;
    }
    OlympicAthlete that = (OlympicAthlete) o;
    return Objects.equals(getAthleteID(), that.getAthleteID()) &&
        Objects.equals(getAthletesName(), that.getAthletesName()) &&
        Objects.equals(getHomeCountry(), that.getHomeCountry()) &&
        Objects.equals(getSport(), that.getSport()) &&
        Objects.equals(getDiscipline(), that.getDiscipline()) &&
        Objects.equals(getQualifyingResult(), that.getQualifyingResult()) &&
        Objects.equals(getPersonalRecord(), that.getPersonalRecord());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAthleteID(), getAthletesName(),
        getHomeCountry(), getSport(), getDiscipline(), getQualifyingResult(), getPersonalRecord());
  }

  @Override
  public String toString() {
    return "OlympicAthlete{" +
        "athleteID='" + athleteID + '\'' +
        ", athletesName=" + athletesName +
        ", homeCountry='" + homeCountry + '\'' +
        ", sport='" + sport + '\'' +
        ", discipline='" + discipline + '\'' +
        ", qualifyingResult=" + qualifyingResult +
        ", personalRecord=" + personalRecord +
        '}';
  }
}
