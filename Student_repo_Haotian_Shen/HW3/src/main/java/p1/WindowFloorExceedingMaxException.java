package p1;

/**
 * Window floor exception for when the window floor is greater than 3.
 */
public class WindowFloorExceedingMaxException extends Exception {

  /**
   * Constructor for window floor exception with a customed error message.
   *
   * @param errMessage - String, customed error message.
   */
  public WindowFloorExceedingMaxException(String errMessage) {
    super(errMessage);
  }
}
