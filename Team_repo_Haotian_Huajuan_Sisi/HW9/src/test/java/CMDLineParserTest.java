import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CMDLineParserTest {

  CMDLineParser parser = new CMDLineParser();

  @Test(expected = CMDLineParserException.class)
  public void testLessThanThreeCMDArgs() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testSortingByTwoFlag() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--display", "--sort-by-date",
        "--sort-by-priority"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testAddTodoNotMoreThanOnce() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--add-todo",
        "--todo-text", "Go shopping"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testCSVFilePathNotProvided() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "--add-todo", "--todo-text", "Go shopping"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testCSVFileFlagNotProvided() throws CMDLineParserException {
    String[] args = new String[]{"HW9Input/todos.csv", "--add-todo", "--todo-text", "Go shopping"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testTodoWithoutTodoText() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testTodoTextWithoutTodo() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--todo-text", "Go shopping"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testTodoTextWithoutDescription() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--todo-text"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testDueWithoutDueDate() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--todo-text",
        "Go shopping", "--due", "Not a due date"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testPriorityWithoutNumber() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--todo-text",
        "Go shopping", "--priority", "Not a number"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testPriorityWithWrongNumber() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--todo-text",
        "Go shopping", "--priority", "4"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testSetCategoryAsADefaultCommandName() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--todo-text",
        "Go shopping", "--priority", "4", "--category", "--completed"};
    parser.parseCommandLineArgs(args);
  }

  @Test(expected = CMDLineParserException.class)
  public void testCompleteTodoWithoutID() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--complete-todo",
        "Not an ID"};
    parser.parseCommandLineArgs(args);
  }

  @Test
  public void testDisplayOption() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--display"};
    Map<Flag, Object> map = parser.parseCommandLineArgs(args);
    assertTrue(map.containsKey(Flag.DISPLAY));
  }

  @Test
  public void testShowIncompleteOption() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--display",
        "--show-incomplete"};
    Map<Flag, Object> map = parser.parseCommandLineArgs(args);
    assertTrue(map.containsKey(Flag.SHOW_INCOMPLETE));
  }

  @Test
  public void testShowCategoryOption() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--display", "--show-category",
        "home"};
    Map<Flag, Object> map = parser.parseCommandLineArgs(args);
    assertTrue(map.containsKey(Flag.SHOW_CATEGORY));
  }

  @Test
  public void testSortByDateOption() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--display", "--sort-by-date"};
    Map<Flag, Object> map = parser.parseCommandLineArgs(args);
    assertTrue(map.containsKey(Flag.SORT_BY_DATE));
  }

  @Test
  public void testSortByPriorityOption() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--display",
        "--sort-by-priority"};
    Map<Flag, Object> map = parser.parseCommandLineArgs(args);
    assertTrue(map.containsKey(Flag.SORT_BY_PRIORITY));
  }

  @Test
  public void testProperCMDInput() throws CMDLineParserException {
    String[] args = new String[]{"--csv-file", "HW9Input/todos.csv", "--add-todo", "--todo-text",
        "Go shopping", "--completed", "--due", "2/14/2021", "--priority", "2", "--category",
        "shopping", "--complete-todo", "14", "--display", "--show-incomplete", "--show-category",
        "shopping", "--sort-by-date"};
    Map<Flag, Object> map = parser.parseCommandLineArgs(args);
    Map<Flag, Object> testMap = new HashMap<Flag, Object>() {
      {
        put(Flag.CSV_FILE, "HW9Input/todos.csv");
        put(Flag.ADD_TODO, "Go shopping");
        put(Flag.COMPLETED, true);
        put(Flag.DUE, LocalDate.parse("2/14/2021", DateTimeFormatter.ofPattern("M/d/yyyy")));
        put(Flag.PRIORITY, 2);
        put(Flag.CATEGORY, "shopping");
        put(Flag.COMPLETED_TODO, Collections.singletonList(14));
        put(Flag.DISPLAY, true);
        put(Flag.SHOW_CATEGORY, "shopping");
        put(Flag.SHOW_INCOMPLETE, true);
        put(Flag.SORT_BY_DATE, true);
      }
    };
    assertEquals(map, testMap);
  }
}