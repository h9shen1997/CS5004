package p1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RunnerTest {

  Runner runner;

  @Before
  public void setUp() throws Exception {
    runner = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0, 1600.0,
        "Track");
    if (runner == null) {
      throw new NullPointerException("The Runner object has not been initialized yet");
    }
  }

  @Test
  public void getBest5KTime() {
    Double expectedTime = 580.0;
    assertEquals(expectedTime, runner.getBest5KTime());
  }

  @Test
  public void setBest5KTime() {
    Double expectedTime = 680.0;
    runner.setBest5KTime(680.0);
    assertEquals(expectedTime, runner.getBest5KTime());
  }

  @Test
  public void getBestHalfMarathonTime() {
    Double expectedTime = 1600.0;
    assertEquals(expectedTime, runner.getBestHalfMarathonTime());
  }

  @Test
  public void setBestHalfMarathonTime() {
    Double expectedTime = 1700.0;
    runner.setBestHalfMarathonTime(expectedTime);
    assertEquals(expectedTime, runner.getBestHalfMarathonTime());
  }

  @Test
  public void getFavRunningEvent() {
    String expectedEvent = "Track";
    assertEquals(expectedEvent, runner.getFavRunningEvent());
  }

  @Test
  public void setFavRunningEvent() {
    String expectedEvent = "Field";
    runner.setFavRunningEvent(expectedEvent);
    assertEquals(expectedEvent, runner.getFavRunningEvent());
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Runner runner1 = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0,
        1600.0, "Track");
    Runner runner2 = runner1;
    assertTrue(runner1.equals(runner2) && runner2.equals(runner1));
  }

  @Test
  public void testEqualsDifferentClass() {
    Runner runner = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0,
        1600.0, "Track");
    Name name = new Name("Haotian", "Shen", "Shen");
    assertFalse(runner.equals(name) || name.equals(runner));
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    Runner runner1 = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0,
        1600.0, "Track");
    Runner runner2 = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0,
        1600.0, "Track");
    assertTrue(runner1.equals(runner2) && runner2.equals(runner1));
  }

  @Test
  public void testEqualsIfGenerateSameHashcode() {
    Runner runner1 = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0,
        1600.0, "Track");
    Runner runner2 = new Runner(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", 580.0,
        1600.0, "Track");
    assertTrue(runner1.hashCode() == runner2.hashCode());
  }
}