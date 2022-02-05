package problem2;

/**
 * Time is a simple object that is composed of a hour, a minute, and a second components.
 */
public class Time {

  private Integer hour;
  private Integer minutes;
  private Integer seconds;

  /**
   * Constructor that creates a new Time object with the specified hour, minute, and second.
   *
   * @param hour    - hour of the Time
   * @param minutes - minute of the Time
   * @param seconds - second of the Time
   */
  public Time(Integer hour, Integer minutes, Integer seconds) {
    this.hour = hour;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  /**
   * Returns the hour of the Time.
   *
   * @return the hour of the Time.
   */
  public Integer getHour() {
    return hour;
  }

  /**
   * Sets the hour of the Time with the specified hour.
   *
   * @param hour - new hour of the Time.
   */
  public void setHour(Integer hour) {
    this.hour = hour;
  }

  /**
   * Returns the minute of the Time.
   *
   * @return the minute of the Time.
   */
  public Integer getMinutes() {
    return minutes;
  }

  /**
   * Sets the minute of the Time with the specified minute
   *
   * @param minutes - new minute of the Time.
   */
  public void setMinutes(Integer minutes) {
    this.minutes = minutes;
  }

  /**
   * Returns the second of the Time.
   *
   * @return the second of the Time.
   */
  public Integer getSeconds() {
    return seconds;
  }

  /**
   * Sets the second of the Time with the specified second.
   *
   * @param seconds - new second of the Time.
   */
  public void setSeconds(Integer seconds) {
    this.seconds = seconds;
  }
}
