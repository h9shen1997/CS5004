import java.util.Map;

/**
 * Main is only responsible to trigger the command line argument parsing and file read and file
 * write.
 */
public class Main {

  /**
   * Trigger the command line arguments parsing, read the input csv file, and write to specified
   * template file if the flag is provided.
   *
   * @param args - String[], command line arguments.
   * @throws CMDLineParserException If the command line arguments is not provided correctly.
   */
  public static void main(String[] args) throws CMDLineParserException, FileParsingException {
    CMDLineParser parser = new CMDLineParser();
    Map<Flag, String> optionToPath = null;
    try {
      optionToPath = parser.parseCommandLineArgs(args);
      FileInputParser inputParser = new FileInputParser(optionToPath);
      inputParser.writeToFolderForAllSupportersBasedOnOptions();
    } catch (CMDLineParserException cmde) {
      System.out.println(cmde.getMessage());
      System.out.println(CMDLineParser.printUsageMessage());
    } catch (FileParsingException ioe) {
      System.out.println(ioe.getMessage());
    }
  }
}
