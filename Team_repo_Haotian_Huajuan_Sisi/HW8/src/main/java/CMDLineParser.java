import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * CMDLineParser parse the command line arguments and check for errors.
 */
public class CMDLineParser {

  private static final String EMAIL_FLAG = "--email";
  private static final String EMAIL_TEMPLATE_FLAG = "--email-template";
  private static final String LETTER_FLAG = "--letter";
  private static final String LETTER_TEMPLATE_FLAG = "--letter-template";
  private static final String OUTPUT_DIR_FLAG = "--output-dir";
  private static final String CSV_FILE_FLAG = "--csv-file";
  private static final int ARGS_MIN = 4;
  private static final int ARGS_MAX = 10;

  /**
   * Print the usage message if any command line parser exception occurs. This method is static
   * because we do not need a CMDLineParser object to call it. The method is implemented in a
   * cross-platform way.
   *
   * @return - String, correct usage message with examples.
   */
  public static String printUsageMessage() {
    String usageMessage = "Usage:" + System.lineSeparator()
        + "--email Generate email messages. If this option is provided, then --email-template must also be provided."
        + System.lineSeparator()
        + "--email-template <path/to/file> A filename for the email template."
        + System.lineSeparator() +
        "--letter Generate letters. If the option is provided, then --letter-template must also be provided."
        + System.lineSeparator() +
        "--letter-template <path/to/file> A filename for the letter template."
        + System.lineSeparator() +
        "--output-dir <path/to/file> The folder to store all generated files. The option is required."
        + System.lineSeparator() +
        "--csv-file <path/to/file> The CSV file to process. This option is required."
        + System.lineSeparator() + System.lineSeparator() +
        "Examples:" + System.lineSeparator()
        + "--email --email-template email-template.txt --output-dir -emails --csv-file customer.csv"
        +
        System.lineSeparator() + System.lineSeparator()
        + "--letter --letter-template letter-template.txt --output-dir letters --cvs-file customer.cvs";
    return usageMessage;
  }

  /**
   * Parse the command line arguments and check for possible error.
   *
   * @param args - String[], command line arguments.
   * @return - Map<Flag, String>, a mapping of the provided flag to the possible file path.
   * @throws CMDLineParserException If command line arguments is not provided correctly.
   */
  public Map<Flag, String> parseCommandLineArgs(String[] args) throws CMDLineParserException {

    Map<Flag, String> optionToPath = new HashMap<>();

    checkCMDArgsNumValid(args);
    checkNumForEachCommandLineArg(args);
    findEmailAndEmailTemplate(args, optionToPath);
    findLetterAndLetterTemplate(args, optionToPath);
    findOutputDir(args, optionToPath);
    findCSVFile(args, optionToPath);

    return optionToPath;
  }

  /**
   * Check if the command line arguments number is between 4 and 10, inclusive. The --output-dir and
   * --csv-file are required with their file paths, so the minimum command line arguments are 4. The
   * maximum command line arguments occurs when all the flags are provided.
   *
   * @param args - String[], command line arguments.
   * @throws CMDLineParserException If the number of command line arguments are not between 4 and
   *                                10, inclusive.
   */
  private void checkCMDArgsNumValid(String[] args) throws CMDLineParserException {
    if (args.length < ARGS_MIN || args.length > ARGS_MAX) {
      throw new CMDLineParserException(
          "Error: The number of command line arguments need to be greater than or equal to 4 and less than or equal to 10.");
    }
  }

  /**
   * Check if each command line arguments only occur once. Repetition of the command line arguments
   * should be invalid.
   *
   * @param args - String[], command line arguments.
   * @throws CMDLineParserException If there is a command line argument occurs more than once.
   */
  private void checkNumForEachCommandLineArg(String[] args) throws CMDLineParserException {
    Map<String, Integer> flagOccurrenceCounter = new HashMap<>();
    for (int i = 0; i < args.length; i++) {
      flagOccurrenceCounter.put(args[i], flagOccurrenceCounter.getOrDefault(args[i], 0) + 1);
      if (flagOccurrenceCounter.get(args[i]) > 1) {
        throw new CMDLineParserException(
            "Error: Do not provide the same command line arguments more than once.");
      }
    }
  }

  /**
   * Check if the csv file path exists. If --csv-file is provided and the path is also provided,
   * save it in the optionToPath.
   *
   * @param args         - String[], command line arguments.
   * @param optionToPath - Map<Flag, String>, a map of the flag value to its path value.
   * @throws CMDLineParserException If either --csv-file is not provided or the file path is
   *                                invalid.
   */
  private void findCSVFile(String[] args, Map<Flag, String> optionToPath)
      throws CMDLineParserException {

    boolean hasCSVFile = false;
    boolean hasCSVFilePath = false;
    String CSVFilePath = null;

    for (int i = 0; i < args.length; i++) {
      if (hasCSVFile && hasCSVFilePath) {
        break;
      }
      if (args[i].equals(CSV_FILE_FLAG)) {
        hasCSVFile = true;
        if (i + 1 < args.length) {
          String possibleCSVFilePath = args[i + 1];
          try {
            Paths.get(possibleCSVFilePath);
            hasCSVFilePath = true;
            CSVFilePath = possibleCSVFilePath;
          } catch (InvalidPathException ipe) {
            throw new CMDLineParserException(
                "Error: --csv-file is provided but the csv file path is either not provided or not correct.");
          }
        } else {
          throw new CMDLineParserException(
              "Error: --csv-file is provided but the csv file path is not provided.");
        }
      }
    }
    if (!hasCSVFile) {
      throw new CMDLineParserException("Error: --csv-file is required but is not provided.");
    }
    optionToPath.put(Flag.CSV_FILE, CSVFilePath);
  }

  /**
   * Check if the output directory exists. If the --output-dir is provided and the path is provided,
   * save it in optionToPath.
   *
   * @param args         - String[], command line arguments.
   * @param optionToPath - Map<Flag, String>, a map of the flag value to its path value.
   * @throws CMDLineParserException If either the --output-dir is not provided or the file path is
   *                                invalid.
   */
  private void findOutputDir(String[] args, Map<Flag, String> optionToPath)
      throws CMDLineParserException {
    boolean hasOutputDir = false;
    boolean hasOutputDirFolder = false;
    String outputDirFolderPath = null;
    for (int i = 0; i < args.length; i++) {
      if (hasOutputDir && hasOutputDirFolder) {
        break;
      }
      if (args[i].equals(OUTPUT_DIR_FLAG)) {
        hasOutputDir = true;
        if (i + 1 < args.length) {
          String possibleOutputDirFolderPath = args[i + 1];
          try {
            Paths.get(possibleOutputDirFolderPath);
            hasOutputDirFolder = true;
            outputDirFolderPath = possibleOutputDirFolderPath;
          } catch (InvalidPathException ipe) {
            throw new CMDLineParserException(
                "Error: --output-dir is provided but the output folder path is either not provided or not correct.");
          }
        } else {
          throw new CMDLineParserException(
              "Error: --output-dir is provided but the output folder path is not provided.");
        }
      }
    }
    if (!hasOutputDir) {
      throw new CMDLineParserException("Error: --output-dir is required but is not provided");
    }
    optionToPath.put(Flag.OUTPUT_DIR, outputDirFolderPath);
  }

  /**
   * Check if both --email and --email-template exist and the file path is provided and correct. If
   * all of these are correct, put email and its email template file path into the optionToPath.
   *
   * @param args         - String[], command line arguments.
   * @param optionToPath - Map<Flag, String>, a map of the flag value to its path value.
   * @throws CMDLineParserException If only one of --email and --email-template is provided or if
   *                                both are provided but the template file path is incorrect.
   */
  private void findEmailAndEmailTemplate(String[] args, Map<Flag, String> optionToPath)
      throws CMDLineParserException {
    boolean hasEmail = false;
    boolean hasEmailTemplate = false;
    boolean hasEmailTemplateFilePath = false;
    String emailTemplateFilePath = null;
    for (int i = 0; i < args.length; i++) {
      if (hasEmail && hasEmailTemplate && hasEmailTemplateFilePath) {
        break;
      }
      if (args[i].equals(EMAIL_FLAG)) {
        hasEmail = true;
      } else if (args[i].equals(EMAIL_TEMPLATE_FLAG)) {
        hasEmailTemplate = true;
        if (i + 1 < args.length) {
          String possibleEmailTemplateFilePath = args[i + 1];
          try {
            Paths.get(possibleEmailTemplateFilePath);// may not get successfully
            hasEmailTemplateFilePath = true;
            emailTemplateFilePath = possibleEmailTemplateFilePath;
          } catch (InvalidPathException ipe) {
            throw new CMDLineParserException(
                "Error: The email template path is either not provided or not correct.");
          }
        } else {
          throw new CMDLineParserException("Error: The email template path is not provided.");
        }
      }
    }
    if (hasEmail && hasEmailTemplate && hasEmailTemplateFilePath) {
      optionToPath.put(Flag.EMAIL, emailTemplateFilePath);
    } else if (hasEmail) {
      throw new CMDLineParserException(
          "Error: --email provided but no --email-template was given.");
    } else if (hasEmailTemplate) {
      throw new CMDLineParserException(
          "Error: --email-template provided but no --email was given.");
    }
  }

  /**
   * Check if both --letter and --letter-template exist and the file path is provided and correct.
   * If all of these are correct, put letter and its letter template file path into the
   * optionToPath.
   *
   * @param args         - String[], command line arguments.
   * @param optionToPath - Map<Flag, String>, a map of the flag value to its path value.
   * @throws CMDLineParserException If only one of --letter and --letter-template is provided or if
   *                                both are provided but the template file path is incorrect.
   */
  private void findLetterAndLetterTemplate(String[] args, Map<Flag, String> optionToPath)
      throws CMDLineParserException {
    boolean hasLetter = false;
    boolean hasLetterTemplate = false;
    boolean hasLetterTemplateFilePath = false;
    String letterTemplateFilePath = null;
    for (int i = 0; i < args.length; i++) {
      if (hasLetter && hasLetterTemplate && hasLetterTemplateFilePath) {
        break;
      }
      if (args[i].equals(LETTER_FLAG)) {
        hasLetter = true;
      } else if (args[i].equals(LETTER_TEMPLATE_FLAG)) {
        hasLetterTemplate = true;
        if (i + 1 < args.length) {
          String possibleLetterTemplateFilePath = args[i + 1];
          try {
            Paths.get(possibleLetterTemplateFilePath);
            hasLetterTemplateFilePath = true;
            letterTemplateFilePath = possibleLetterTemplateFilePath;
          } catch (InvalidPathException ipe) {
            throw new CMDLineParserException(
                "Error: The letter template path is either not provided or not correct.");
          }
        } else {
          throw new CMDLineParserException("Error: The letter template path is not provided.");
        }
      }
    }
    if (hasLetter && hasLetterTemplate && hasLetterTemplateFilePath) {
      optionToPath.put(Flag.LETTER, letterTemplateFilePath);
    } else if (hasLetter) {
      throw new CMDLineParserException(
          "Error: --letter provided but no --letter-template was given.");
    } else if (hasLetterTemplate) {
      throw new CMDLineParserException(
          "Error: --letter-template provided but no --letter was given.");
    }
  }
}
