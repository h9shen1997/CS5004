package p2;

/**
 * Exception class that handles exception when the locker is already occupied when trying to add a
 * new mail item.
 */
public class LockerOccupiedException extends Exception {

  /**
   * Constructor that creates a locker occupied exception with customed message.
   *
   * @param errMessage - String, customed message.
   */
  public LockerOccupiedException(String errMessage) {
    super(errMessage);
  }
}
