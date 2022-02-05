package p1;

/**
 * Exception class to handle the exception when the room is not available.
 */
public class RoomNotAvailableException extends RuntimeException {

  /**
   * Constructor that creates a room not available exception with customed message.
   *
   * @param errorMessage - String, customed message.
   */
  public RoomNotAvailableException(String errorMessage) {
    super(errorMessage);
  }
}
