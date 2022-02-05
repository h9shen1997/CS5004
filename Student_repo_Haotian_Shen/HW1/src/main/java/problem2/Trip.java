package problem2;

/**
 * Trip has a pair of starting and ending location and a pair of starting and ending time to
 * describe the trip.
 */
public class Trip {

  private static final int HOUR_TO_MINUTES_CONVERSION = 60;
  private static final int MINUTES_TO_SECONDS_CONVERSION = 60;
  private static final int HOUR_TO_SECONDS_CONVERSION =
      HOUR_TO_MINUTES_CONVERSION * MINUTES_TO_SECONDS_CONVERSION;
  private String startLoc;
  private String endLoc;
  private Time startTime;
  private Time endTime;

  /**
   * Constructor that creates a new trip object with the specified starting and ending location and
   * starting and ending time.
   *
   * @param startLoc  - starting location of the Trip.
   * @param endLoc    - ending location of the Trip.
   * @param startTime - starting time of the Trip.
   * @param endTime   - ending time of the trip.
   */
  public Trip(String startLoc, String endLoc, Time startTime, Time endTime) {
    this.startLoc = startLoc;
    this.endLoc = endLoc;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Returns the starting location of the Trip.
   *
   * @return the starting location of the Trip.
   */
  public String getStartLoc() {
    return startLoc;
  }

  /**
   * Sets the starting location of the Trip with the specified starting location.
   *
   * @param startLoc - new starting location
   */
  public void setStartLoc(String startLoc) {
    this.startLoc = startLoc;
  }

  /**
   * Returns the ending location of the Trip.
   *
   * @return the ending location of the Trip.
   */
  public String getEndLoc() {
    return endLoc;
  }

  /**
   * Sets the ending location of the Trip with the specified ending location.
   *
   * @param endLoc - new ending location.
   */
  public void setEndLoc(String endLoc) {
    this.endLoc = endLoc;
  }

  /**
   * Returns the stating time of the Trip.
   *
   * @return the starting time of the Trip.
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * Sets the starting time of the Trip with the specified starting time.
   *
   * @param startTime - new starting time.
   */
  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }

  /**
   * Returns the ending time of the Trip.
   *
   * @return the ending time of the Trip.
   */
  public Time getEndTime() {
    return endTime;
  }

  /**
   * Sets the ending time of the Trip with the specified ending time.
   *
   * @param endTime - new ending time.
   */
  public void setEndTime(Time endTime) {
    this.endTime = endTime;
  }

  /**
   * Returns the duration of the trip using ending time to subtract starting time.
   *
   * @return the duration of the trip.
   */
  public Time getDuration() throws IllegalArgumentException {
    Time startTime = getStartTime();
    Time endTime = getEndTime();
    Integer startHour = startTime.getHour();
    Integer endHour = endTime.getHour();
    Integer startMinutes = startTime.getMinutes();
    Integer endMinutes = endTime.getMinutes();
    Integer startSeconds = startTime.getSeconds();
    Integer endSeconds = endTime.getSeconds();
    if (endHour < startHour) {
      throw new IllegalArgumentException("The ending hour " + endHour +
          " cannot be smaller than the starting hour " + startHour + " of a " +
          "trip");
    } else if (endHour == startHour) {
      if (endMinutes < startMinutes) {
        throw new IllegalArgumentException("If the starting and ending " +
            "hour are the same for the trip, then the ending minutes " + endMinutes
            + " cannot be smaller than the starting minutes " + startMinutes + " of a trip");
      } else if (endMinutes == startMinutes) {
        if (endSeconds < startSeconds) {
          throw new IllegalArgumentException("If the starting and ending " +
              "hours and minutes are the same for the trip, then the ending " +
              "seconds " + endSeconds + " cannot be smaller than the starting" +
              " secodns " + startSeconds + " of a trip");
        }
      }
    }
    return calculateDifferenceOfStartAndEndTime(startHour, startMinutes, startSeconds, endHour,
        endMinutes, endSeconds);
  }

  /**
   * Helper method that calculate the duration from the starting time and ending time based on the
   * hour, minute, and second of the two Time objects.
   *
   * @param startHour    - starting hour.
   * @param startMinutes - starting minute.
   * @param startSeconds - starting second.
   * @param endHour      - ending hour.
   * @param endMinutes   - ending minute.
   * @param endSeconds   - ending second.
   * @return the duration of time from starting time to ending time.
   */
  private Time calculateDifferenceOfStartAndEndTime(Integer startHour, Integer startMinutes,
      Integer startSeconds, Integer endHour, Integer endMinutes, Integer endSeconds) {
    Integer totalSecondsOfStartTime =
        startHour * HOUR_TO_SECONDS_CONVERSION + startMinutes * MINUTES_TO_SECONDS_CONVERSION
            + startSeconds;
    Integer totalSecondsOfEndTime =
        endHour * HOUR_TO_SECONDS_CONVERSION + endMinutes * MINUTES_TO_SECONDS_CONVERSION
            + endSeconds;
    Integer duration = totalSecondsOfEndTime - totalSecondsOfStartTime;
    Integer durationHour = duration / HOUR_TO_SECONDS_CONVERSION;
    Integer remainingAfterHour = duration % HOUR_TO_SECONDS_CONVERSION;
    Integer durationMinute = remainingAfterHour / MINUTES_TO_SECONDS_CONVERSION;
    Integer durationSecond = remainingAfterHour % MINUTES_TO_SECONDS_CONVERSION;
    return new Time(durationHour, durationMinute, durationSecond);
  }
}
