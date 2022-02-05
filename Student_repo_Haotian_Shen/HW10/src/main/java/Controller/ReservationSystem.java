package Controller;

import Exceptions.NoWheelchairRowException;
import ModelView.Theater;

/**
 * Reservation system class is the controller to call the interactive interface.
 */
public class ReservationSystem {

  /**
   * Called the main method to trigger the interactive interface. This will create a theater and let
   * the user book seats for this theater.
   *
   * @param args - String[], command line arguments, which is not used in this interactive
   *             interface.
   */
  public static void main(String[] args) {
    Theater theater;
    try {
      theater = new Theater(8, 10, "AMC", new int[]{1, 2, 3, 4});
    } catch (NoWheelchairRowException | IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return;
    }
    ReservationService rs = new ReservationService(theater);
    rs.process();
  }
}
