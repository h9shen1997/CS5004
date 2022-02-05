package p1;

/**
 * Exception class for when electrical service employee is greater than 4.
 */
public class ElectricalServiceIllegalException extends Exception {

  /**
   * Constructor for Electrical Service Exception with a customed error message.
   *
   * @param errMessage - String, error message.
   */
  public ElectricalServiceIllegalException(String errMessage) {
    super(errMessage);
  }
}
