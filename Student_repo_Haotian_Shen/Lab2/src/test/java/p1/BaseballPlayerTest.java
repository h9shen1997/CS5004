package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {

  BaseballPlayer player;

  @Before
  public void setUp() throws Exception {
    player = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8, "NFL", "Eagle",
        3.5, 3);
    if (player == null) {
      throw new NullPointerException("The player object has not been initialized yet");
    }
  }

  @Test
  public void getTeam() {
    String expectedTeam = "Eagle";
    assertEquals(expectedTeam, player.getTeam());
  }

  @Test
  public void setTeam() {
    String expectedTeam = "Whale";
    player.setTeam(expectedTeam);
    assertEquals(expectedTeam, player.getTeam());
  }

  @Test
  public void getAverageBatting() {
    Double expectedBatting = 3.5;
    assertEquals(expectedBatting, player.getAverageBatting());
  }

  @Test
  public void setAverageBatting() {
    Double expectedBatting = 3.9;
    player.setAverageBatting(expectedBatting);
    assertEquals(expectedBatting, player.getAverageBatting());
  }

  @Test
  public void getSeasonHomeRuns() {
    Integer expectedRun = 3;
    assertEquals(expectedRun, player.getSeasonHomeRuns());
  }

  @Test
  public void setSeasonHomeRuns() {
    Integer expectedRun = 4;
    player.setSeasonHomeRuns(expectedRun);
    assertEquals(expectedRun, player.getSeasonHomeRuns());
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    BaseballPlayer player1 = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8,
        "NFL", "Eagle", 3.5, 3);
    BaseballPlayer player2 = player1;
    assertTrue(player1.equals(player2) && player2.equals(player1));
  }

  @Test
  public void testEqualsDifferentClass() {
    BaseballPlayer player = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8,
        "NFL", "Eagle", 3.5, 3);
    Name name = new Name("Haotian", "Shen", "Shen");
    assertFalse(name.equals(player) || player.equals(name));
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    BaseballPlayer player1 = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8,
        "NFL", "Eagle", 3.5, 3);
    BaseballPlayer player2 = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8,
        "NFL", "Eagle", 3.5, 3);
    assertTrue(player1.equals(player2) && player2.equals(player1));
  }

  @Test
  public void testEqualsIfGenerateSameHashcode() {
    BaseballPlayer player1 = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8,
        "NFL", "Eagle", 3.5, 3);
    BaseballPlayer player2 = new BaseballPlayer(new Name("Haotian", "Shen", "Shen"), 7.11, 198.8,
        "NFL", "Eagle", 3.5, 3);
    assertTrue(player1.hashCode() == player2.hashCode());
  }
}