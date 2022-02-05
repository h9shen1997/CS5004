package Controller;

import static org.junit.Assert.*;

import Exceptions.NoWheelchairRowException;
import ModelView.Operation;
import ModelView.Theater;
import org.junit.Test;

public class ReservationServiceTest {
  ReservationService rs;

  @Test
  public void getOperationWhenReserve() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    assertEquals(Operation.RESERVE, rs.getOperation("reserve 3"));
  }

  @Test
  public void getOperationWhenDone() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    assertEquals(Operation.DONE, rs.getOperation("done"));
  }

  @Test
  public void getOperationWhenShow() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    assertEquals(Operation.SHOW, rs.getOperation("show"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void getOperationWhenUsingWrongInput() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    rs.getOperation("something wrong");
  }

  @Test
  public void updateTheaterRowWhenWheelchairNotRequired() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    rs.updateTheaterWithUserInfoAndDisplay(3, "Frank", false);
    String testString = "= = = = =" + System.lineSeparator() + "X X X _ _" + System.lineSeparator() +
        "= = = = =" + System.lineSeparator() + "= = = = =" + System.lineSeparator() + "_ _ _ _ _";
    assertEquals(testString, rs.getTheater().toString());
  }

  @Test
  public void updateTheaterRowWhenWheelchairRequired() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    rs.updateTheaterWithUserInfoAndDisplay(3, "Frank", true);
    String testString = "= = = = =" + System.lineSeparator() + "_ _ _ _ _" + System.lineSeparator() +
        "X X X = =" + System.lineSeparator() + "= = = = =" + System.lineSeparator() + "_ _ _ _ _";
    assertEquals(testString, rs.getTheater().toString());
  }

  @Test
  public void updateTheaterRowWhenWheelchairNotRequiredButNoNormalSeatsLeft() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 3, 4}));
    rs.updateTheaterWithUserInfoAndDisplay(3, "Frank", false);
    rs.updateTheaterWithUserInfoAndDisplay(3, "Megan", false);
    rs.updateTheaterWithUserInfoAndDisplay(3, "Joey", false);
    String testString = "= = = = =" + System.lineSeparator() + "X X X _ _" + System.lineSeparator() +
        "X X X = =" + System.lineSeparator() + "= = = = =" + System.lineSeparator() + "X X X _ _";
    assertEquals(testString, rs.getTheater().toString());
  }

  @Test
  public void updateTheaterRowWhenNoWheelchairRowAvailable() throws NoWheelchairRowException {
    rs = new ReservationService(new Theater(5, 5, "AMC", new int[]{1, 4}));
    rs.updateTheaterWithUserInfoAndDisplay(3, "Frank", true);
    rs.updateTheaterWithUserInfoAndDisplay(3, "Megan", true);
    rs.updateTheaterWithUserInfoAndDisplay(3, "Joey", true);
    String testString = "X X X = =" + System.lineSeparator() + "_ _ _ _ _" + System.lineSeparator() +
        "_ _ _ _ _" + System.lineSeparator() + "X X X = =" + System.lineSeparator() + "_ _ _ _ _";
    assertEquals(testString, rs.getTheater().toString());
  }
}