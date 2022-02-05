package problem1;

/**
 * Priority queue empty exception handles the exception when the queue is currently empty and still
 * try to peek or pop element from it.
 */
public class PriorityQueueEmptyException extends Exception {

  /**
   * Constructor for priority queue emepty exception.
   *
   * @param err - String, error message.
   */
  public PriorityQueueEmptyException(String err) {
    super(err);
  }
}
