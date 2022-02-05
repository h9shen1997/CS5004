package finalExam.p2;

public interface OlympicAthleteDirectorySystem {

  /**
   * Determine if the system is empty.
   *
   * @return - Boolean, whether empty.
   */
  Boolean isEmpty();

  /**
   * Count the number of athlete currently in the system.
   *
   * @return - Integer, number of athletes.
   */
  Integer count();

  /**
   * Add the specified athlete into the system. If it already exists, update the athlete's
   * information.
   *
   * @param o - the added athlete.
   * @return - the system with the athlete added.
   */
  OlympicAthleteDirectorySystem add(OlympicAthlete o);

  /**
   * Remove the specified athlete from the system. If the system is empty or the athlete does not
   * exist in the system, it will throw an error.
   *
   * @param o - the removed athlete.
   * @return - the system with the athlete removed.
   * @throws OlympicAthleteNotFoundException - if the system is empty or the athlete unique ID is
   *                                         not found.
   */
  OlympicAthleteDirectorySystem remove(OlympicAthlete o) throws OlympicAthleteNotFoundException;

  /**
   * Check whether the system contains the specified athlete.
   *
   * @param o - the specified athlete.
   * @return - whether contains.
   */
  Boolean contains(OlympicAthlete o);

  /**
   * Find all the athletes that play the specified sport.
   *
   * @param sport - String, the specified sport.
   * @return - all the athlete for this sport.
   */
  OlympicAthleteDirectorySystem findSameSport(String sport);

  /**
   * Find all the athletes that come from the specified country.
   *
   * @param country - String, the specified country.
   * @return - all the athlete from this country.
   */
  OlympicAthleteDirectorySystem findSameCountry(String country);

  /**
   * Get the athlete with the unique ID.
   *
   * @param id - String, unique ID.
   * @return - the athlete with that ID.
   * @throws InvalidAthleteIDException - If the ID was not found in the system or if the system is
   *                                   empty.
   */
  OlympicAthlete getFromID(String id) throws InvalidAthleteIDException;

  /**
   * Helper method to get the rest of the athlete except for the calling athlete.
   *
   * @return - the rest of the athlete.
   */
  OlympicAthleteDirectorySystem getRest();

  /**
   * Helper method to set the rest of the athlete with the given system of athlete.
   *
   * @param rest - the rest of the athlete.
   */
  void setRest(OlympicAthleteDirectorySystem rest);

  /**
   * Helper method used in recursive add method. It maintains a reference to previous athlete in the
   * linked collection structure.
   *
   * @param o    - the added athlete.
   * @param prev - the previous athlete.
   */
  void addHelper(OlympicAthlete o, OlympicAthleteDirectorySystem prev);

  /**
   * Helper method used in recursive remove method. It maintains a reference to previous athlete in
   * the linked collection structure. So, it can simply connect to the rest of the athlete of the
   * removed athlete for easier processing.
   *
   * @param o    - the removed athlete.
   * @param prev - the previous athlete.
   */
  void removeHelper(OlympicAthlete o, OlympicAthleteDirectorySystem prev);

  /**
   * Helper method to check if the athlete is already contained in the system using its unique ID.
   * This method is used in add, contains, and remove.
   *
   * @param o - the specified athlete.
   * @return - whether the athlete already existed.
   */
  Boolean alreadyExistInSystem(OlympicAthlete o);

  /**
   * Helper method used in findSameSport to add the athlete having the same sport to the static
   * dummy head sport variable.
   *
   * @param sport - String, the specified sport.
   */
  void findSameSportHelper(String sport);

  /**
   * Helper method used in findSameCountry to add the athlete having the same sport to the static
   * dummy head country variable.
   *
   * @param country - String, the specified country.
   */
  void findSameCountryHelper(String country);
}
