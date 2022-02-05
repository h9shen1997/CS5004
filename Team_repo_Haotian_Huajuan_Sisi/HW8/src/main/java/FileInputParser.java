import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Read the csv file and template files and use this information to replace placeholder in template
 * files and generate desired message based on the provided flag.
 */
public class FileInputParser {

  private static final String FIRST_NAME = "first_name";
  private static final String LAST_NAME = "last_name";
  private static final String TXT_FILE_SUFFIX = ".txt";
  private static final String PLACE_HOLDER_PATTERN = "\\[\\[(.+?)]]";
  private static final String CSV_FILE_DELIMITER = "\" *, *\"";
  private final Map<Flag, String> options;
  private final List<Map<String, String>> supportersInfo = new ArrayList<>();
  private List<String> emailTemplate = new ArrayList<>();
  private List<String> letterTemplate = new ArrayList<>();
  private List<String> csvFileHeader = new ArrayList<>();

  /**
   * Constructor to create a FileInputParser with the specified options.
   *
   * @param options - Map<Flag, String>, a mapping of the flag to the possible file path.
   */
  public FileInputParser(Map<Flag, String> options) {
    this.options = options;
  }

  /**
   * Write to the folder for all the supporters based on the flag option provided.
   *
   * @throws FileParsingException If any of the writing or reading to or from file fails.
   */
  public void writeToFolderForAllSupportersBasedOnOptions() throws FileParsingException {
    processCSVInputFile();
    processEmailTemplateFile();
    processLetterTemplateFile();
    String outputDirFolderPath = options.get(Flag.OUTPUT_DIR);
    Pattern placeholder = Pattern.compile(PLACE_HOLDER_PATTERN);
    for (Map<String, String> stringStringMap : supportersInfo) {
      if (options.containsKey(Flag.EMAIL)) {
        writeFlagTemplateToFolderForSingleSupporter(stringStringMap, outputDirFolderPath,
            placeholder, Flag.EMAIL, emailTemplate);
      }
      if (options.containsKey(Flag.LETTER)) {
        writeFlagTemplateToFolderForSingleSupporter(stringStringMap, outputDirFolderPath,
            placeholder, Flag.LETTER, letterTemplate);
      }
    }
  }

  /**
   * Generalized method to replace placeholder with a single supporter's information based on which
   * flag is provided.
   *
   * @param supporterInfo       - Map<String, String>, single supporter information.
   * @param outputDirFolderPath - String, output director folder.
   * @param placeholder         - Pattern, placeholder in the form of [[placeholder]].
   * @param flag                - Flag, flag provided.
   * @param templateToUse       - List<String>, template to be replaced.
   * @throws FileParsingException If writing to the file fails.
   */
  private void writeFlagTemplateToFolderForSingleSupporter(Map<String, String> supporterInfo,
      String outputDirFolderPath, Pattern placeholder, Flag flag, List<String> templateToUse)
      throws FileParsingException {
    String flagLowerCaseString = flag.name().toLowerCase();
    String writeFilePath =
        outputDirFolderPath + File.separator + supporterInfo.get(FIRST_NAME) + "_"
            + supporterInfo.get(LAST_NAME) + "_" + flagLowerCaseString + TXT_FILE_SUFFIX;
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilePath))) {
      Matcher m;
      for (String line : templateToUse) {
        m = placeholder.matcher(line);
        String updatedLine = replacePlaceholderWithSupporterInfo(supporterInfo, line, m);
        writer.write(updatedLine + System.lineSeparator());
      }
    } catch (IOException e) {
      throw new FileParsingException(
          "Error: Something went wrong when writing to the " + flagLowerCaseString
              + " template file.");
    }
  }

  /**
   * Helper method to replace the placeholder in the template file with the supporter information
   * using pattern matching.
   *
   * @param supporterInfo - Map<String, String>, single supporter information.
   * @param line          - String, each line in the template file.
   * @param m             - Matcher, pattern matcher.
   * @return - String, updated line with the placeholder replaced.
   */
  private String replacePlaceholderWithSupporterInfo(Map<String, String> supporterInfo, String line,
      Matcher m) {
    StringBuilder sb = new StringBuilder();
    int prevStart = 0;
    while (m.find()) {
      sb.append(line, prevStart, m.start());
      String placeholderString = m.group(1);
      sb.append(supporterInfo.get(placeholderString));
      prevStart = m.end();
    }
    if (prevStart < line.length()) {
      sb.append(line.substring(prevStart));
    }
    return sb.toString();
  }


  /**
   * Parse the email template all at once and store it.
   *
   * @throws FileParsingException If the parsing of email template file is incorrect.
   */
  private void processEmailTemplateFile() throws FileParsingException {
    if (options.containsKey(Flag.EMAIL)) {
      emailTemplate = readAllLineOfFile(Flag.EMAIL);
    }
  }

  /**
   * Parse the letter template all at once and store it.
   *
   * @throws FileParsingException If the parsing of letter template file is incorrect.
   */
  private void processLetterTemplateFile() throws FileParsingException {
    if (options.containsKey(Flag.LETTER)) {
      letterTemplate = readAllLineOfFile(Flag.LETTER);
    }
  }

  /**
   * Read all the lines of a template file based on the flag provided.
   *
   * @param flag - Flag, provided flag.
   * @throws FileParsingException If the parsing of template file is incorrect.
   */
  private List<String> readAllLineOfFile(Flag flag) throws FileParsingException {
    try {
      Path in = Paths.get(options.get(flag));
      return Files.readAllLines(in);
    } catch (IOException e) {
      throw new FileParsingException(
          "Error: Something went wrong while parsing " + flag.name().toLowerCase()
              + " template file.");
    }
  }

  /**
   * Parse the csv input file with all the supporter's information and store it.
   *
   * @throws FileParsingException If the parsing of csv input file is incorrect.
   */
  private void processCSVInputFile() throws FileParsingException {
    String csvFilePath = options.get(Flag.CSV_FILE);
    try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {
      String line;
      int index = 0;
      while ((line = csvReader.readLine()) != null) {
        line = line.substring(1, line.length() - 1);
        String[] splitLine = line.split(CSV_FILE_DELIMITER);
        if (index == 0) {
          csvFileHeader = Arrays.asList(splitLine);
        } else {
          Map<String, String> supporterInfo = new HashMap<>();
          for (int i = 0; i < csvFileHeader.size(); i++) {
            supporterInfo.put(csvFileHeader.get(i), splitLine[i]);
          }
          supportersInfo.add(supporterInfo);
        }
        index++;
      }
    } catch (IOException ioe) {
      throw new FileParsingException("Error: Something went wrong while parsing csv input file.");
    }
  }
}
