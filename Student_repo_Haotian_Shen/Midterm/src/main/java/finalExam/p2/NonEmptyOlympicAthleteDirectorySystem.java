package finalExam.p2;

public class NonEmptyOlympicAthleteDirectorySystem implements OlympicAthleteDirectorySystem {

  private static OlympicAthleteDirectorySystem dummyHeadForSameSport;
  private static OlympicAthleteDirectorySystem dummyHeadForSameCountry;
  private final OlympicAthlete athlete;
  private OlympicAthleteDirectorySystem rest;

  public NonEmptyOlympicAthleteDirectorySystem(OlympicAthlete athlete) {
    this.athlete = athlete;
    this.rest = new EmptyOlympicAthleteDirectorySystem();
  }

  public NonEmptyOlympicAthleteDirectorySystem(OlympicAthlete athlete,
      OlympicAthleteDirectorySystem rest) {
    this.athlete = athlete;
    this.rest = rest;
  }

  public OlympicAthlete getAthlete() {
    return athlete;
  }

  @Override
  public OlympicAthleteDirectorySystem getRest() {
    return rest;
  }

  @Override
  public void setRest(OlympicAthleteDirectorySystem rest) {
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Integer count() {
    return 1 + getRest().count();
  }

  @Override
  public OlympicAthleteDirectorySystem add(OlympicAthlete o) {
    OlympicAthleteDirectorySystem head = this;
    if (alreadyExistInSystem(o)) {
      if (getAthlete().getAthleteID().equals(o.getAthleteID())) {
        return new NonEmptyOlympicAthleteDirectorySystem(o, getRest());
      } else {
        addHelper(o, this);
        return head;
      }
    }
    return new NonEmptyOlympicAthleteDirectorySystem(o, this);
  }

  @Override
  public void addHelper(OlympicAthlete o, OlympicAthleteDirectorySystem prev) {
    OlympicAthleteDirectorySystem next = getRest();
    if (getAthlete().getAthleteID().equals(o.getAthleteID())) {
      prev.setRest(new NonEmptyOlympicAthleteDirectorySystem(o, next));
      return;
    }
    next.addHelper(o, this);
  }

  @Override
  public OlympicAthleteDirectorySystem remove(OlympicAthlete o)
      throws OlympicAthleteNotFoundException {
    if (!alreadyExistInSystem(o)) {
      throw new OlympicAthleteNotFoundException(
          "The specified athlete was not found in the directory system");
    }
    OlympicAthleteDirectorySystem head = this;
    if (getAthlete().getAthleteID().equals(o.getAthleteID())) {
      return getRest();
    }
    removeHelper(o, this);
    return head;
  }

  @Override
  public void removeHelper(OlympicAthlete o, OlympicAthleteDirectorySystem prev) {
    OlympicAthleteDirectorySystem next = getRest();
    if (getAthlete().getAthleteID().equals(o.getAthleteID())) {
      prev.setRest(next);
      return;
    }
    next.removeHelper(o, this);
  }

  @Override
  public Boolean alreadyExistInSystem(OlympicAthlete o) {
    if (getAthlete().getAthleteID().equals(o.getAthleteID())) {
      return true;
    }
    return getRest().alreadyExistInSystem(o);
  }

  @Override
  public Boolean contains(OlympicAthlete o) {
    if (o.getAthleteID().equals(getAthlete().getAthleteID())) {
      return true;
    }
    return getRest().contains(o);
  }

  @Override
  public OlympicAthleteDirectorySystem findSameSport(String sport) {
    dummyHeadForSameSport = new EmptyOlympicAthleteDirectorySystem();
    findSameSportHelper(sport);
    return dummyHeadForSameSport;
  }

  @Override
  public void findSameSportHelper(String sport) {
    if (getAthlete().getSport().equals(sport)) {
      dummyHeadForSameSport = dummyHeadForSameSport.add(getAthlete());
    }
    getRest().findSameSportHelper(sport);
  }

  @Override
  public OlympicAthleteDirectorySystem findSameCountry(String country) {
    dummyHeadForSameCountry = new EmptyOlympicAthleteDirectorySystem();
    findSameCountryHelper(country);
    return dummyHeadForSameCountry;
  }

  @Override
  public void findSameCountryHelper(String country) {
    if (getAthlete().getHomeCountry().equals(country)) {
      dummyHeadForSameCountry = dummyHeadForSameCountry.add(getAthlete());
    }
    getRest().findSameCountryHelper(country);
  }

  @Override
  public OlympicAthlete getFromID(String id) throws InvalidAthleteIDException {
    if (getAthlete().getAthleteID().equals(id)) {
      return getAthlete();
    }
    return getRest().getFromID(id);
  }
}
