package p2;

/**
 * Exception class that handles exception when the locker is empty when the recipient tries to get
 * mail item from it.
 */
public class EmptyLockerException extends Exception {

  /**
   * Constructor that creates an empty locker exception with customed message.
   *
   * @param errMessage - String, customed message.
   */
  public EmptyLockerException(String errMessage) {
    super(errMessage);
  }
}
