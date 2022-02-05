package finalExam.p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OlympicAthleteDirectorySystemTest {

  OlympicAthleteDirectorySystem system;

  @Test
  public void isEmpty() {
    system = new EmptyOlympicAthleteDirectorySystem();
    assertTrue(system.isEmpty());
    OlympicAthlete a = new OlympicAthlete("1", new Name("Frank", "W", "Rutherford"), "France",
        "soccer", "track", 5.0, 4.0);
    OlympicAthlete b = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "USA",
        "soccer", "sport", 5.0, 4.0);
    OlympicAthlete c = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "China",
        "basketball", "sport", 5.0, 4.0);
    OlympicAthlete d = new OlympicAthlete("3", new Name("Travis", "W", "Scott"), "China",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthlete e = new OlympicAthlete("4", new Name("Backer", "W", "Scott"), "USA", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete f = new OlympicAthlete("5", new Name("Fred", "W", "Scott"), "France", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete g = new OlympicAthlete("6", new Name("Tammy", "W", "Scott"), "Germany",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthleteDirectorySystem system = new NonEmptyOlympicAthleteDirectorySystem(a);
    system = system.add(a);
    system = system.add(b);
    system = system.add(c);
    system = system.add(d);
    system = system.add(e);
    system = system.add(f);
    system = system.add(g);
    assertFalse(system.isEmpty());
  }

  @Test
  public void removeWhenAthleteExist() throws OlympicAthleteNotFoundException {
    system = new EmptyOlympicAthleteDirectorySystem();
    OlympicAthlete a = new OlympicAthlete("1", new Name("Frank", "W", "Rutherford"), "France",
        "soccer", "track", 5.0, 4.0);
    OlympicAthlete b = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "USA",
        "soccer", "sport", 5.0, 4.0);
    OlympicAthlete c = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "China",
        "basketball", "sport", 5.0, 4.0);
    OlympicAthlete d = new OlympicAthlete("3", new Name("Travis", "W", "Scott"), "China",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthlete e = new OlympicAthlete("4", new Name("Backer", "W", "Scott"), "USA", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete f = new OlympicAthlete("5", new Name("Fred", "W", "Scott"), "France", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete g = new OlympicAthlete("6", new Name("Tammy", "W", "Scott"), "Germany",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthleteDirectorySystem system = new NonEmptyOlympicAthleteDirectorySystem(a);
    system = system.add(a);
    system = system.add(b);
    system = system.add(c);
    system = system.add(d);
    system = system.add(e);
    system = system.add(f);
    system = system.add(g);
    assertEquals(6, system.count(), 0);
    system = system.remove(b);
    system = system.remove(d);
    assertEquals(4, system.count(), 0);
  }

  @Test(expected = OlympicAthleteNotFoundException.class)
  public void removeWhenAthleteDoesNotExist() throws OlympicAthleteNotFoundException {
    system = new EmptyOlympicAthleteDirectorySystem();
    OlympicAthlete a = new OlympicAthlete("1", new Name("Frank", "W", "Rutherford"), "France",
        "soccer", "track", 5.0, 4.0);
    OlympicAthlete b = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "USA",
        "soccer", "sport", 5.0, 4.0);
    OlympicAthlete c = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "China",
        "basketball", "sport", 5.0, 4.0);
    OlympicAthlete d = new OlympicAthlete("3", new Name("Travis", "W", "Scott"), "China",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthlete e = new OlympicAthlete("4", new Name("Backer", "W", "Scott"), "USA", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete f = new OlympicAthlete("5", new Name("Fred", "W", "Scott"), "France", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete g = new OlympicAthlete("6", new Name("Tammy", "W", "Scott"), "Germany",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthleteDirectorySystem system = new NonEmptyOlympicAthleteDirectorySystem(a);
    system = system.add(a);
    system = system.add(b);
    system = system.add(c);
    system = system.add(d);
    system = system.add(e);
    system = system.remove(g);
  }

  @Test(expected = OlympicAthleteNotFoundException.class)
  public void removeWhenSystemIsEmpty() throws OlympicAthleteNotFoundException {
    system = new EmptyOlympicAthleteDirectorySystem();
    OlympicAthlete a = new OlympicAthlete("1", new Name("Frank", "W", "Rutherford"), "France",
        "soccer", "track", 5.0, 4.0);
    OlympicAthlete b = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "USA",
        "soccer", "sport", 5.0, 4.0);
    OlympicAthlete c = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "China",
        "basketball", "sport", 5.0, 4.0);
    system = system.add(a);
    system = system.add(b);
    system = system.add(c);
    system = system.remove(a);
    system = system.remove(b);
    system = system.remove(c);
    system = system.remove(c);
  }

  @Test
  public void containsSpecifiedAthlete() {
    system = new EmptyOlympicAthleteDirectorySystem();
    OlympicAthlete a = new OlympicAthlete("1", new Name("Frank", "W", "Rutherford"), "France",
        "soccer", "track", 5.0, 4.0);
    OlympicAthlete b = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "USA",
        "soccer", "sport", 5.0, 4.0);
    OlympicAthlete c = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "China",
        "basketball", "sport", 5.0, 4.0);
    OlympicAthlete d = new OlympicAthlete("3", new Name("Travis", "W", "Scott"), "China",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthlete e = new OlympicAthlete("4", new Name("Backer", "W", "Scott"), "USA", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete f = new OlympicAthlete("5", new Name("Fred", "W", "Scott"), "France", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete g = new OlympicAthlete("6", new Name("Tammy", "W", "Scott"), "Germany",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthleteDirectorySystem system = new NonEmptyOlympicAthleteDirectorySystem(a);
    system = system.add(a);
    system = system.add(b);
    system = system.add(c);
    system = system.add(d);
    system = system.add(e);
    system = system.add(f);
    assertTrue(system.contains(a));
    assertFalse(system.contains(g));
  }

  @Test
  public void findSameSport() {
    system = new EmptyOlympicAthleteDirectorySystem();
    OlympicAthlete a = new OlympicAthlete("1", new Name("Frank", "W", "Rutherford"), "France",
        "Soccer", "track", 5.0, 4.0);
    OlympicAthlete b = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "USA",
        "Soccer", "sport", 5.0, 4.0);
    OlympicAthlete c = new OlympicAthlete("2", new Name("Happy", "W", "Rutherford"), "China",
        "Basketball", "sport", 5.0, 4.0);
    OlympicAthlete d = new OlympicAthlete("3", new Name("Travis", "W", "Scott"), "China",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthlete e = new OlympicAthlete("4", new Name("Backer", "W", "Scott"), "USA", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete f = new OlympicAthlete("5", new Name("Fred", "W", "Scott"), "France", "Swimming",
        "sport", 5.0, 4.0);
    OlympicAthlete g = new OlympicAthlete("6", new Name("Tammy", "W", "Scott"), "Germany",
        "Swimming", "sport", 5.0, 4.0);
    OlympicAthleteDirectorySystem system = new NonEmptyOlympicAthleteDirectorySystem(a);
    system = system.add(a);
    system = system.add(b);
    system = system.add(c);
    system = system.add(d);
    system = system.add(e);
    system = system.add(f);
    system = system.add(g);
    OlympicAthleteDirectorySystem systemWithSwimming = system.findSameSport("Swimming");
    assertEquals(4, systemWithSwimming.count(), 0);
    assertTrue(systemWithSwimming.contains(d));
    assertTrue(systemWithSwimming.contains(e));
    assertTrue(systemWithSwimming.contains(f));
    assertTrue(systemWithSwimming.contains(g));
    OlympicAthleteDirectorySystem systemWithSoccer = system.findSameSport("Soccer");
    assertEquals(1, systemWithSoccer.count(), 0);
    OlympicAthleteDirectorySystem systemWithNonExist = system.findSameSport("NonExist");
    assertEquals(0, systemWithNonExist.count(), 0);
  }
}