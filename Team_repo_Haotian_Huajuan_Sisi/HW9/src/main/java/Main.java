import java.util.Map;

/**
 * Main is only responsible to trigger the command line argument, read,write, and display the
 * specific toDos list based on given options
 */
public class Main {

  /**
   * Trigger the command line arguments parsing, read the input csv file, display and update the
   * specific csv file given input arguments
   *
   * @param args - String[], command line arguments.
   */
  public static void main(String[] args) {
    CMDLineParser parser = new CMDLineParser();
    try {
      Map<Flag, Object> todoCommands = parser.parseCommandLineArgs(args);
      TodoParser todoParser = new TodoParser(todoCommands);
      todoParser.processCommandsBasedOnOption();
    } catch (CMDLineParserException | FileParsingException | EmptyFilteredResultException | IDNotExistException e) {
      System.out.println(e.getMessage());
    }
  }
}
