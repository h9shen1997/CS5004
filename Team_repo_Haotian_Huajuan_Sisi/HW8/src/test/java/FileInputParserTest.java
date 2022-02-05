import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileInputParserTest {

  private static final String INPUT_DIRECTORY = "HW8input";
  private static final String VALID_EMAIL_TEMP_DIR =
      INPUT_DIRECTORY + File.separator + "test-email-template.txt";
  private static final String VALID_LETTER_TEMP_DIR =
      INPUT_DIRECTORY + File.separator + "test-letter-template.txt";
  private static final String VALID_CSV_DIR =
      INPUT_DIRECTORY + File.separator + "test-supporter.csv";
  private static final String INVALID_EMAIL_TEMP_DIR = "email-not-exist-file.txt";
  private static final String INVALID_CSV_DIR = "test-supporter-not-exist.csv";

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void testWriteEmail()
      throws FileParsingException, IOException {

    String outputDir = tempFolder.getRoot().getPath();
    Map<Flag, String> options = new HashMap<Flag, String>() {{
      put(Flag.EMAIL, VALID_EMAIL_TEMP_DIR);
      put(Flag.CSV_FILE, VALID_CSV_DIR);
      put(Flag.OUTPUT_DIR, outputDir);
    }};

    FileInputParser parser = new FileInputParser(options);
    parser.writeToFolderForAllSupportersBasedOnOptions();

    String emailOutputFilePath = outputDir + File.separator + "James_Butt_email.txt";
    File emailOutputFile = new File(emailOutputFilePath);
    assertTrue(emailOutputFile.exists());

    List<String> emailOutputFileLines = Files.readAllLines(Paths.get(emailOutputFilePath));
    List<String> emailExpectedFileLines = new ArrayList<String>() {{
      add("To:jbutt@gmail.com");
      add("Subject: Test email 1");
      add("Dear James Butt,");
      add("Your website link is http://www.bentonjohnbjr.com");
    }};
    assertEquals(emailExpectedFileLines, emailOutputFileLines);
  }

  @Test
  public void testWriteLetter()
      throws FileParsingException, IOException {

    String outputDir = tempFolder.getRoot().getPath();
    Map<Flag, String> options = new HashMap<Flag, String>() {{
      put(Flag.LETTER, VALID_LETTER_TEMP_DIR);
      put(Flag.CSV_FILE, VALID_CSV_DIR);
      put(Flag.OUTPUT_DIR, outputDir);
    }};

    FileInputParser parser = new FileInputParser(options);
    parser.writeToFolderForAllSupportersBasedOnOptions();

    String letterOutputFilePath = outputDir + File.separator + "James_Butt_letter.txt";
    File letterOutputFile = new File(letterOutputFilePath);
    assertTrue(letterOutputFile.exists());

    List<String> letterOutputFileLines = Files.readAllLines(Paths.get(letterOutputFilePath));
    List<String> letterExpectedFileLines = new ArrayList<String>() {
      {
        add("James Butt");
        add("6649 N Blue Gum St");
        add("New Orleans, LA, 70116");
        add("Dear James Butt,");
        add("Test letter!");
      }
    };
    assertEquals(letterExpectedFileLines, letterOutputFileLines);
  }


  @Test(expected = FileParsingException.class)
  public void InvalidOutputDirectoryTest() throws FileParsingException {
    String outPutDir = "InvalidOutputDirectory";
    Map<Flag, String> options = new HashMap<Flag, String>() {{
      put(Flag.EMAIL, VALID_EMAIL_TEMP_DIR);
      put(Flag.CSV_FILE, VALID_CSV_DIR);
      put(Flag.OUTPUT_DIR, outPutDir);
    }};
    FileInputParser parser = new FileInputParser(options);
    parser.writeToFolderForAllSupportersBasedOnOptions();
  }

  @Test(expected = FileParsingException.class)
  public void InvalidCSVDirectoryTest() throws FileParsingException {
    String outputDir = tempFolder.getRoot().getPath();
    Map<Flag, String> options = new HashMap<Flag, String>() {{
      put(Flag.EMAIL, VALID_EMAIL_TEMP_DIR);
      put(Flag.CSV_FILE, INVALID_CSV_DIR);
      put(Flag.OUTPUT_DIR, outputDir);
    }};
    FileInputParser parser = new FileInputParser(options);
    parser.writeToFolderForAllSupportersBasedOnOptions();
  }

  @Test(expected = FileParsingException.class)
  public void InvalidEmailDirectoryTest() throws FileParsingException {
    String outputDir = tempFolder.getRoot().getPath();
    Map<Flag, String> options = new HashMap<Flag, String>() {{
      put(Flag.EMAIL, INVALID_EMAIL_TEMP_DIR);
      put(Flag.CSV_FILE, VALID_CSV_DIR);
      put(Flag.OUTPUT_DIR, outputDir);
    }};
    FileInputParser parser = new FileInputParser(options);
    parser.writeToFolderForAllSupportersBasedOnOptions();
  }
}