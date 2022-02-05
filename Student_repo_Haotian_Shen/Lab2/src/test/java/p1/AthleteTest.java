package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AthleteTest {

  private Athlete athlete;

  @Before
  public void setUp() throws Exception {
    Name expectedName = new Name("Russell", "Carrington", "Wilson");
    athlete = new Athlete(expectedName, 5.11, 198.8, "NFL");
    if (athlete == null) {
      throw new NullPointerException("The athlete object has not been initialized yet");
    }
  }

  @Test
  public void getAthletesName() {
    Name expectedName = new Name("Russell", "Carrington", "Wilson");
    assertEquals(expectedName, athlete.getAthletesName());
  }

  @Test
  public void setAthletesName() {
    Name expectedName = new Name("Haotian", "Shen", "Shen");
    athlete.setAthletesName(expectedName);
    assertEquals(expectedName, athlete.getAthletesName());
  }

  @Test
  public void getHeight() {
    Double expectedHeight = 5.11;
    assertEquals(expectedHeight, athlete.getHeight());
  }

  @Test
  public void setHeight() {
    Double expectedHeight = 7.11;
    athlete.setHeight(expectedHeight);
    assertEquals(expectedHeight, athlete.getHeight());
  }

  @Test
  public void getWeight() {
    Double expectedWeight = 198.8;
    assertEquals(expectedWeight, athlete.getWeight());
  }

  @Test
  public void setWeight() {
    Double expectedWeight = 200.1;
    athlete.setWeight(expectedWeight);
    assertEquals(expectedWeight, athlete.getWeight());
  }

  @Test
  public void getLeague() {
    String expectedLeague = "NFL";
    assertEquals(expectedLeague, athlete.getLeague());
  }

  @Test
  public void setLeague() {
    String expectedLeague = "NBA";
    athlete.setLeague(expectedLeague);
    assertEquals(expectedLeague, athlete.getLeague());
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Name expectedName = new Name("Russell", "Carrington", "Wilson");
    Athlete a = new Athlete(expectedName, 5.11, 198.8, "NFL");
    Athlete b = a;
    assertTrue(a.equals(b) && b.equals(a));
  }

  @Test
  public void testEqualsDifferentClass() {
    Name expectedName = new Name("Russell", "Carrington", "Wilson");
    Athlete a = new Athlete(expectedName, 5.11, 198.8, "NFL");
    assertFalse(a.equals(expectedName) || expectedName.equals(a));
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    Name expectedNameOne = new Name("Russell", "Carrington", "Wilson");
    Athlete a = new Athlete(expectedNameOne, 5.11, 198.8, "NFL");
    Name expectedNameTwo = new Name("Russell", "Carrington", "Wilson");
    Athlete b = new Athlete(expectedNameTwo, 5.11, 198.8, "NFL");
    assertTrue(a.equals(b) && b.equals(a));
  }

  @Test
  public void testEqualsIfGenerateSameHashcode() {
    Name expectedNameOne = new Name("Russell", "Carrington", "Wilson");
    Athlete a = new Athlete(expectedNameOne, 5.11, 198.8, "NFL");
    Name expectedNameTwo = new Name("Russell", "Carrington", "Wilson");
    Athlete b = new Athlete(expectedNameTwo, 5.11, 198.8, "NFL");
    assertTrue(a.hashCode() == b.hashCode());
  }
}