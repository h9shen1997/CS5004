/**
 * IDNotExistException is a File Parsing error exception, it will be thrown if the specific ID is
 * not found in the ToDos list
 */
public class IDNotExistException extends Exception {

  /**
   * Constructor for IDNotExistException with an error message.
   *
   * @param err - String, error message.
   */
  public IDNotExistException(String err) {
    super(err);
  }
}
