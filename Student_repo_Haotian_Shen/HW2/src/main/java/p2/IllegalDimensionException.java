package p2;

/**
 * Exception class that handles exception when the mail item size is greater than the dimension of
 * the locker.
 */
public class IllegalDimensionException extends Exception {

  /**
   * Constructor that creates an illegal dimension exception with customed message.
   *
   * @param errMessage - String, customed message.
   */
  public IllegalDimensionException(String errMessage) {
    super(errMessage);
  }
}
