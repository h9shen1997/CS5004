/**
 * EmptyFilteredResultException is a File Parsing error exception, it will be thrown if the filtered
 * ToDos list is empty.
 */
public class EmptyFilteredResultException extends Exception {

  /**
   * Constructor for EmptyFilteredResultException with an error message.
   *
   * @param err - String, error message.
   */
  public EmptyFilteredResultException(String err) {
    super(err);
  }
}
