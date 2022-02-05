import static org.junit.Assert.*;

import java.io.File;
import java.util.Map;
import org.junit.Test;

public class CMDLineParserTest {
  CMDLineParser test = new CMDLineParser();

  @Test
  public void printUsageMessage()  {

    String s = "Usage:" + System.lineSeparator()
        + "--email Generate email messages. If this option is provided, then --email-template must also be provided." + System.lineSeparator()
        + "--email-template <path/to/file> A filename for the email template." + System.lineSeparator()
        + "--letter Generate letters. If the option is provided, then --letter-template must also be provided." + System.lineSeparator()
        + "--letter-template <path/to/file> A filename for the letter template." + System.lineSeparator()
        + "--output-dir <path/to/file> The folder to store all generated files. The option is required." + System.lineSeparator()
        + "--csv-file <path/to/file> The CSV file to process. This option is required." + System.lineSeparator()
        + System.lineSeparator()
        + "Examples:" + System.lineSeparator()
        + "--email --email-template email-template.txt --output-dir -emails --csv-file customer.csv" + System.lineSeparator()
        + System.lineSeparator()
        + "--letter --letter-template letter-template.txt --output-dir letters --cvs-file customer.cvs";
    assertEquals(s, CMDLineParser.printUsageMessage());
  }
  // has email flag, no email template
  @Test(expected = CMDLineParserException.class)
  public void testEmailFlagWithoutEmailTemplateFlag() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    CMDLineParser test = new CMDLineParser();
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }


  //email template, no email flag
  @Test(expected = CMDLineParserException.class)
  public void testEmailTemplateFlagWithoutEmailFlag()throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};
    CMDLineParser test = new CMDLineParser();
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  //email & email template without path
  @Test(expected = CMDLineParserException.class)
  public void testEmailAndEmailTemplateWithoutPath()throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--email", "--email-template"};
    CMDLineParser test = new CMDLineParser();
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  // email & email template with wrong path
  // correct path: any getable path
  // wrong path: path cannot be  read by Paths.get(), for example, "home\0"
  @Test(expected = CMDLineParserException.class)
  public void testEmailAndEmailTemplateWithWrongPath()throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8\0"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    CMDLineParser test = new CMDLineParser();
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  //letter flag, no letter template
  @Test(expected = CMDLineParserException.class)
  public void testLatterFlagWithoutLetterTemplateFlag()throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  //letter flag & letter template, no path
  @Test(expected = CMDLineParserException.class)
  public void testLetterFlagAndLetterTemplateFlagWithoutPath() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template"};
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  //letter flag & letter template, with wrong path
  @Test (expected = CMDLineParserException.class)
  public void testLetterFlagAndLetterTemplateWithWrongPath() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8\0"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  //no output dir
  @Test (expected = CMDLineParserException.class)
  public void testNoOutputdir() throws CMDLineParserException {
    String[] args = new String[] {"HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  // output-dir, wrong path
  @Test(expected = CMDLineParserException.class)
  public void testOutputdirWithWrongPath() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8\0" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv", "--letter","--letter-template", "HW8"+
        File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  // no cvs-file
  @Test(expected = CMDLineParserException.class)
  public void testNoCsvFlag() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  // no csv-file path
  @Test(expected = CMDLineParserException.class)
  public void testCsvFlagWithWrongPath() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output", "--cvs-file", "--letter","--letter-template",
        "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  //duplicate flag
  @Test(expected = CMDLineParserException.class)
  public void testDuplicateFlag() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir", "--output-dir", "HW8" + File.separator + "HW8output", "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt"};

    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  // args number lest than 4 args
  @Test(expected = CMDLineParserException.class)
  public void testLessThanMinCMDArgsNum() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir", "HW8" + File.separator + "HW8output", "--csv-file"};
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }

  // args number larger than 10
  @Test(expected = CMDLineParserException.class)
  public void testLargerThanMinCMDArgsNum() throws CMDLineParserException {
    String[] args = new String[] {"--output-dir",  "HW8" + File.separator + "HW8output",  "--csv-file", "HW8" + File.separator + "HW8input" + File.separator + "nonprofit-supporters.csv",
        "--letter","--letter-template", "HW8"+ File.separator +"HW8input"+ File.separator +"letter-template.txt", "--email", "--email-template", "HW8"+ File.separator +"HW8input"+ File.separator +"email-template.txt", "--letter"};
    Map<Flag, String> optionToPath = test.parseCommandLineArgs(args);
  }
}