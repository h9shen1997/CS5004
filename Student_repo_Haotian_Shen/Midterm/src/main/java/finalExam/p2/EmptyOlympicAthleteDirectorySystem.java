package finalExam.p2;

public class EmptyOlympicAthleteDirectorySystem implements OlympicAthleteDirectorySystem {

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Integer count() {
    return 0;
  }

  @Override
  public OlympicAthleteDirectorySystem add(OlympicAthlete o) {
    return new NonEmptyOlympicAthleteDirectorySystem(o);
  }

  @Override
  public OlympicAthleteDirectorySystem remove(OlympicAthlete o)
      throws OlympicAthleteNotFoundException {
    throw new OlympicAthleteNotFoundException("There is no athlete in the directory");
  }

  @Override
  public Boolean contains(OlympicAthlete o) {
    return false;
  }

  @Override
  public OlympicAthleteDirectorySystem findSameSport(String sport) {
    return null;
  }

  @Override
  public OlympicAthleteDirectorySystem findSameCountry(String country) {
    return null;
  }

  @Override
  public OlympicAthlete getFromID(String id) throws InvalidAthleteIDException {
    throw new InvalidAthleteIDException(
        "There is no athlete in the directory yet, so the ID is invalid.");
  }

  @Override
  public OlympicAthleteDirectorySystem getRest() {
    return null;
  }

  @Override
  public void setRest(OlympicAthleteDirectorySystem rest) {
  }

  @Override
  public void addHelper(OlympicAthlete o, OlympicAthleteDirectorySystem prev) {
  }

  @Override
  public void removeHelper(OlympicAthlete o, OlympicAthleteDirectorySystem prev) {
  }

  @Override
  public Boolean alreadyExistInSystem(OlympicAthlete o) {
    return false;
  }

  @Override
  public void findSameSportHelper(String sport) {
  }

  @Override
  public void findSameCountryHelper(String country) {
  }
}
