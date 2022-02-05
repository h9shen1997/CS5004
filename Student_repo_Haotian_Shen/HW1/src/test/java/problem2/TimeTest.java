package problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {

  private Time time;

  @Before
  public void setUp() throws Exception {
    time = new Time(10, 20, 36);
    if (time == null) {
      throw new NullPointerException("The Time object has not been initialized yet.");
    }
  }

  @Test
  public void getHour() {
    Integer expectedHour = 10;
    assertEquals("The hour of the time object must be 10", expectedHour,
        time.getHour());
  }

  @Test
  public void setHour() {
    Integer expectedHour = 15;
    time.setHour(expectedHour);
    assertEquals("The hour should be changed to 15", expectedHour,
        time.getHour());
  }

  @Test
  public void getMinutes() {
    Integer expectedMinute = 20;
    assertEquals("The minutes of the time object must be 20", expectedMinute
        , time.getMinutes());
  }

  @Test
  public void setMinutes() {
    Integer expectedMinute = 46;
    time.setMinutes(expectedMinute);
    assertEquals("The minutes should be chagned to 46", expectedMinute,
        time.getMinutes());
  }

  @Test
  public void getSeconds() {
    Integer expectedSecond = 36;
    assertEquals("The seconds of the time object must be 36", expectedSecond
        , time.getSeconds());
  }

  @Test
  public void setSeconds() {
    Integer expectedSecond = 3;
    time.setSeconds(expectedSecond);
    assertEquals("The seconds should be changed to 3", expectedSecond,
        time.getSeconds());
  }
}