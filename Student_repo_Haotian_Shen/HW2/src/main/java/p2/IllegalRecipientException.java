package p2;

/**
 * Exception class that handles exception when the recipient getting the mail item is not the
 * designated recipient.
 */
public class IllegalRecipientException extends Exception {

  /**
   * Constructor that creates an illegal recipient exception with customed message.
   *
   * @param errMessage - String, customed message.
   */
  public IllegalRecipientException(String errMessage) {
    super(errMessage);
  }

}
