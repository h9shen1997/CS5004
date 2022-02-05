package ModelView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import Exceptions.NoSeatsAvailableException;
import Exceptions.NoWheelchairRowException;
import org.junit.Test;

public class TheaterTest {

  Theater theater;

  @Test(expected = NoWheelchairRowException.class)
  public void createTheaterWithoutWheelchairRow() throws NoWheelchairRowException {
    theater = new Theater(10, 10, "AMC", new int[]{});
  }

  @Test(expected = IllegalArgumentException.class)
  public void createTheaterWithRowsLessThanWheelchairRow()
      throws IllegalArgumentException, NoWheelchairRowException {
    theater = new Theater(3, 10, "AMC", new int[]{1, 2, 3, 4});
  }

  @Test(expected = IllegalArgumentException.class)
  public void createTheaterWithWheelchairRowGreaterThanRowCapacity()
      throws NoWheelchairRowException {
    theater = new Theater(5, 10, "AMC", new int[]{1, 7, 8});
  }

  @Test
  public void getName() throws NoWheelchairRowException {
    theater = new Theater(10, 10, "AMC", new int[]{1, 3, 5});
    assertEquals("AMC", theater.getName());
  }

  @Test
  public void getRowCapacity() throws NoWheelchairRowException {
    theater = new Theater(10, 10, "AMC", new int[]{1, 3, 5});
    assertEquals(10, theater.getRowCapacity(), 0);
  }

  @Test(expected = NoSeatsAvailableException.class)
  public void getOptimalRowWhenPartySizeGreaterThanRowCapacity()
      throws NoSeatsAvailableException, NoWheelchairRowException {
    theater = new Theater(5, 5, "AMC", new int[]{1, 3, 4});
    theater.getOptimalRow(10, false);
  }

  @Test(expected = NoSeatsAvailableException.class)
  public void getOptimalRowWhenWheelchairRequiredButNoSeats()
      throws NoWheelchairRowException, NoSeatsAvailableException {
    theater = new Theater(5, 5, "AMC", new int[]{1});
    theater.changeSeatsToOccupied(5, "Megan", true);
    theater.getOptimalRow(5, true);
  }

  @Test
  public void getOptimalRowWhenWheelchairRequired()
      throws NoWheelchairRowException, NoSeatsAvailableException {
    theater = new Theater(7, 5, "AMC", new int[]{1, 3, 4});
    int optimalRow = theater.getOptimalRow(5, true);
    assertEquals(4, optimalRow, 0);
  }

  @Test
  public void getOptimalRowWhenWheelchairNotRequired()
      throws NoWheelchairRowException, NoSeatsAvailableException {
    theater = new Theater(7, 5, "AMC", new int[]{1, 3, 4});
    int optimalRow = theater.getOptimalRow(5, false);
    assertEquals(5, optimalRow, 0);
  }

  @Test
  public void getOptimalRowWhenWheelchairNotRequiredButNoNormalSeatsExist()
      throws NoWheelchairRowException, NoSeatsAvailableException {
    theater = new Theater(7, 5, "AMC", new int[]{1, 3, 4});
    theater.changeSeatsToOccupied(5, "Megan", false);
    theater.changeSeatsToOccupied(5, "Frank", false);
    theater.changeSeatsToOccupied(5, "Jack", false);
    theater.changeSeatsToOccupied(5, "Halo", false);
    int optimalRow = theater.getOptimalRow(5, false);
    assertEquals(4, optimalRow, 0);
  }

  @Test
  public void testToStringWhenNoSeatsOccupied() throws NoWheelchairRowException {
    theater = new Theater(5, 5, "AMC", new int[]{1, 3, 4});
    String testString =
        "= = = = =" + System.lineSeparator() + "_ _ _ _ _" + System.lineSeparator() +
            "= = = = =" + System.lineSeparator() + "= = = = =" + System.lineSeparator()
            + "_ _ _ _ _";
    assertEquals(testString, theater.toString());
  }

  @Test
  public void testToStringWhenSeatsOccupied()
      throws NoWheelchairRowException, NoSeatsAvailableException {
    theater = new Theater(5, 5, "AMC", new int[]{1, 3, 4});
    theater.changeSeatsToOccupied(3, "Megan", false);
    theater.changeSeatsToOccupied(3, "Frank", false);
    theater.changeSeatsToOccupied(3, "Jack", false);
    theater.changeSeatsToOccupied(3, "Halo", false);
    String testString =
        "= = = = =" + System.lineSeparator() + "X X X _ _" + System.lineSeparator() +
            "X X X = =" + System.lineSeparator() + "X X X = =" + System.lineSeparator()
            + "X X X _ _";
    assertEquals(testString, theater.toString());
  }

  @Test
  public void testEqualsWithSameContent() throws NoWheelchairRowException {
    theater = new Theater(5, 5, "AMC", new int[]{1, 3, 4});
    Theater copy = new Theater(5, 5, "AMC", new int[]{1, 3, 4});
    assertTrue(theater.equals(copy) && copy.equals(theater) && theater.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsWithDifferentContent() throws NoWheelchairRowException {
    theater = new Theater(5, 5, "AMC", new int[]{1, 3, 4});
    Theater copy = new Theater(5, 5, "AMC", new int[]{1, 2, 4});
    assertFalse(theater.equals(copy) || copy.equals(theater));
  }
}