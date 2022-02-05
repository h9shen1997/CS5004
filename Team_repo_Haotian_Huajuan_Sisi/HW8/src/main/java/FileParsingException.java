/**
 * FileParsingException happens when reading or writing to a file and fails.
 */
public class FileParsingException extends Exception {

  /**
   * Constructor to create a FileParsingException with the specified message.
   *
   * @param message - String, specified error message.
   */
  public FileParsingException(String message) {
    super(message);
  }
}
