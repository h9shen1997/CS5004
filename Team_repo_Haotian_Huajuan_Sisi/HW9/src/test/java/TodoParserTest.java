import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TodoParserTest {

  private static final String INPUT_DIRECTORY = "HW9input";
  private static final String VALID_TODOS_DIR = INPUT_DIRECTORY + File.separator + "todos.csv";
  private static final String VALID_TODOS_INCOMPLETE_DIR =
      INPUT_DIRECTORY + File.separator + "test-todos-incomplete.csv";
  private static final String VALID_TODOS_CATEGORY_DIR =
      INPUT_DIRECTORY + File.separator + "test-todos-category.csv";
  private static final String VALID_TODOS_SORT_BY_DATE_DIR =
      INPUT_DIRECTORY + File.separator + "test-todos-sort-date.csv";
  private static final String VALID_TODOS_SORT_BY_PRIORITY_DIR =
      INPUT_DIRECTORY + File.separator + "test-todos-sort-priority.csv";
  private static final String INVALID_DIR = "file_not_exist.csv";
  private static final String VALID_TEST_TODOS1_DIR =
      INPUT_DIRECTORY + File.separator + "test-todos1.csv";
  private static final String VALID_TEST_TODOS2_DIR =
      INPUT_DIRECTORY + File.separator + "test-todos2.csv";
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(
      "M/d/yyyy");
  private static final LocalDate DATE_1 = LocalDate.parse("12/10/2021", DATE_TIME_FORMATTER);


  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test(expected = FileParsingException.class)
  public void invalidFileDirectoryTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException {
    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, INVALID_DIR);
        put(Flag.DISPLAY, true);
      }
    };
    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

  }

  @Test(expected = EmptyFilteredResultException.class)
  public void emptyFilterResultExceptionTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException {
    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.DISPLAY, true);
        put(Flag.SHOW_CATEGORY, "invalidCategory");
      }
    };
    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

  }

  @Test
  public void testAddToDos()
      throws IOException, FileParsingException, EmptyFilteredResultException, IDNotExistException {
    String tempDir1 = tempFolder.getRoot().getPath() + File.separator + "test-todos1.csv";
    Files.copy(new File(VALID_TODOS_DIR).toPath(), new File(tempDir1).toPath(),
        StandardCopyOption.REPLACE_EXISTING);

    Map<Flag, Object> todoOptions1 = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, tempDir1);
        put(Flag.ADD_TODO, "final project");
        put(Flag.DUE, DATE_1);
        put(Flag.PRIORITY, 1);
        put(Flag.CATEGORY, "school");
      }
    };

    TodoParser parser = new TodoParser(todoOptions1);
    parser.processCommandsBasedOnOption();
    assertTrue(new File(tempDir1).exists());

    List<String> expectedOutput = Files.readAllLines(Paths.get(VALID_TEST_TODOS1_DIR));
    List<String> testOutput = Files.readAllLines(Paths.get(tempDir1));
    assertEquals(expectedOutput, testOutput);

  }

  @Test
  public void completeToDoTest()
      throws IOException, FileParsingException, EmptyFilteredResultException, IDNotExistException {
    String tempDir = tempFolder.getRoot().getPath() + File.separator + "test-todos2.csv";
    Files.copy(new File(VALID_TODOS_DIR).toPath(), new File(tempDir).toPath(),
        StandardCopyOption.REPLACE_EXISTING);

    List<Integer> completedIDs = new ArrayList<Integer>() {{
      add(7);
    }};
    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, tempDir);
        put(Flag.COMPLETED_TODO, completedIDs);
      }
    };

    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();
    assertTrue(new File(tempDir).exists());

    List<String> expectedOutput = Files.readAllLines(Paths.get(VALID_TEST_TODOS2_DIR));
    List<String> testOutput = Files.readAllLines(Paths.get(tempDir));
    assertEquals(expectedOutput, testOutput);

  }

  @Test(expected = IDNotExistException.class)
  public void invalidCompleteToDoIDsTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException {
    List<Integer> completedIDs = new ArrayList<Integer>() {
      {
        add(100);
      }
    };

    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.COMPLETED_TODO, completedIDs);
      }
    };
    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();
  }

  @Test
  public void displayTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException, IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.DISPLAY, true);
      }
    };

    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

    System.setOut(originalOut);

    String expected = new String(Files.readAllBytes(Paths.get(VALID_TODOS_DIR)),
        StandardCharsets.UTF_8);
    assertEquals(expected.trim(), outContent.toString().trim());

  }

  @Test
  public void displayIncompleteTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException, IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.DISPLAY, true);
        put(Flag.SHOW_INCOMPLETE, true);
      }
    };

    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

    System.setOut(originalOut);

    String expected = new String(Files.readAllBytes(Paths.get(VALID_TODOS_INCOMPLETE_DIR)),
        StandardCharsets.UTF_8);
    assertEquals(expected.trim(), outContent.toString().trim());
  }

  @Test
  public void showCategoryTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException, IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.DISPLAY, true);
        put(Flag.SHOW_CATEGORY, "school");
      }
    };

    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

    System.setOut(originalOut);

    String expected = new String(Files.readAllBytes(Paths.get(VALID_TODOS_CATEGORY_DIR)),
        StandardCharsets.UTF_8);
    assertEquals(expected.trim(), outContent.toString().trim());
  }

  @Test
  public void displayToDosAfterSortingByDateTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException, IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    System.setOut(new PrintStream(outContent));

    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.DISPLAY, true);
        put(Flag.SORT_BY_DATE, true);
      }
    };

    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

    System.setOut(originalOut);

    String expected = new String(Files.readAllBytes(Paths.get(VALID_TODOS_SORT_BY_DATE_DIR)),
        StandardCharsets.UTF_8);
    assertEquals(expected.trim(), outContent.toString().trim());
  }

  @Test
  public void displayToDosAfterSortingByPriorityTest()
      throws FileParsingException, EmptyFilteredResultException, IDNotExistException, IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    System.setOut(new PrintStream(outContent));

    Map<Flag, Object> todoOptions = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, VALID_TODOS_DIR);
        put(Flag.DISPLAY, true);
        put(Flag.SORT_BY_PRIORITY, true);
      }
    };

    TodoParser parser = new TodoParser(todoOptions);
    parser.processCommandsBasedOnOption();

    System.setOut(originalOut);

    String expected = new String(Files.readAllBytes(Paths.get(VALID_TODOS_SORT_BY_PRIORITY_DIR)),
        StandardCharsets.UTF_8);
    assertEquals(expected.trim(), outContent.toString().trim());
  }
}
