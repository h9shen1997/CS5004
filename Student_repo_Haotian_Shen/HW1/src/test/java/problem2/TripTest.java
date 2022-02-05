package problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TripTest {

  private Trip trip;

  @Before
  public void setUp() throws NullPointerException {
    Time startTime = new Time(5, 10, 35);
    Time endTime = new Time(7, 5, 25);
    trip = new Trip("Seattle", "Bellevue", startTime, endTime);
    if (trip == null) {
      throw new NullPointerException();
    }
  }

  @Test
  public void getStartLoc() {
    String expectedStartLoc = "Seattle";
    assertEquals("The starting location of the trip must be Seattle",
        expectedStartLoc, trip.getStartLoc());
  }

  @Test
  public void setStartLoc() {
    String expectedStartLoc = "Bellevue";
    trip.setStartLoc(expectedStartLoc);
    assertEquals("The starting location of the trip should be changed to Bellevue",
        expectedStartLoc, trip.getStartLoc());
  }

  @Test
  public void getEndLoc() {
    String expectedEndLoc = "Bellevue";
    assertEquals("The ending location of the trip must be Bellevue", expectedEndLoc,
        trip.getEndLoc());
  }

  @Test
  public void setEndLoc() {
    String expectedEndLoc = "Seattle";
    trip.setEndLoc(expectedEndLoc);
    assertEquals("The ending location after change should be Seattle",
        expectedEndLoc, trip.getEndLoc());
  }

  @Test
  public void getStartTime() {
    int hour = trip.getStartTime().getHour();
    int minutes = trip.getStartTime().getMinutes();
    int seconds = trip.getStartTime().getSeconds();
    assertEquals("The starting hour must be 5 hours", 5, hour);
    assertEquals("The starting minutes must be 10 minutes", 10, minutes);
    assertEquals("The starting seconds must be 35 seconds", 35, seconds);
  }

  @Test
  public void setStartTime() {
    Time expectedStartTime = new Time(10, 35, 46);
    trip.setStartTime(expectedStartTime);
    int hour = trip.getStartTime().getHour();
    int minutes = trip.getStartTime().getMinutes();
    int seconds = trip.getStartTime().getSeconds();
    assertEquals("The starting hour after change should be 10 hours", 10, hour);
    assertEquals("The starting minutes after change should be 35 minutes", 35, minutes);
    assertEquals("The starting seconds after change should be 46 seconds", 46, seconds);
  }

  @Test
  public void getEndTime() {
    int hour = trip.getEndTime().getHour();
    int minutes = trip.getEndTime().getMinutes();
    int seconds = trip.getEndTime().getSeconds();
    assertEquals("The ending hour must be 7 hours", 7, hour);
    assertEquals("The ending minutes must be 5 minutes", 5, minutes);
    assertEquals("The ending seconds must be 25 seconds", 25, seconds);
  }

  @Test
  public void setEndTime() {
    Time expectedEndTime = new Time(18, 15, 30);
    trip.setEndTime(expectedEndTime);
    int hour = trip.getEndTime().getHour();
    int minutes = trip.getEndTime().getMinutes();
    int seconds = trip.getEndTime().getSeconds();
    assertEquals("The ending hour after change should be 18 hours",
        18, hour);
    assertEquals("The ending minutes after change should be 15 minutes",
        15, minutes);
    assertEquals("The ending seconds after change should be 30 seconds",
        30, seconds);
  }

  @Test
  public void getDuration() {
    Time expectedStartTime = new Time(10, 35, 46);
    Time expectedEndTime = new Time(18, 15, 30);
    trip.setStartTime(expectedStartTime);
    trip.setEndTime(expectedEndTime);
    Time duration = trip.getDuration();
    int hour = duration.getHour();
    int minutes = duration.getMinutes();
    int seconds = duration.getSeconds();
    assertEquals("The duration hour must be 7 hours", 7,
        hour);
    assertEquals("The duration minutes must be 39 minutes", 39,
        minutes);
    assertEquals("The duration seconds must be 44 seconds", 44,
        seconds);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getDurationSameHourSameMinutesIllegalSeconds() {
    trip.setStartTime(new Time(2, 4, 36));
    trip.setEndTime(new Time(2, 4, 35));
    Time duration = trip.getDuration();
  }

  @Test
  public void getDurationDifferentHourSameMinutesIllegalSeconds() {
    trip.setStartTime(new Time(2, 4, 36));
    trip.setEndTime(new Time(4, 4, 34));
    Time duration = trip.getDuration();
    int hour = duration.getHour();
    int minutes = duration.getMinutes();
    int seconds = duration.getSeconds();
    assertEquals("The duration hour must be 1 hours", 1,
        hour);
    assertEquals("The duration minutes must be 59 minutes", 59,
        minutes);
    assertEquals("The duration seconds must be 58 seconds", 58,
        seconds);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getDurationSameHourIllegalMinutesSameSeconds() {
    trip.setStartTime(new Time(2, 4, 36));
    trip.setEndTime(new Time(2, 3, 36));
    Time duration = trip.getDuration();
  }

  @Test(expected = IllegalArgumentException.class)
  public void getDurationIllegalHourSameMinutesSameSeconds() {
    trip.setStartTime(new Time(2, 4, 36));
    trip.setEndTime(new Time(1, 4, 36));
    Time duration = trip.getDuration();
  }
}