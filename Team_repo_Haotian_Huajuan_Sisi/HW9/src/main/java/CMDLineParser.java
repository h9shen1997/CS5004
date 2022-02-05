import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * CMDLineParse parse the command line arguments and check for errors.
 */
public class CMDLineParser {

  private static final String CSV_FILE_FLAG = "--csv-file";
  private static final String ADD_TODO_FLAG = "--add-todo";
  private static final String TODO_TEXT_FLAG = "--todo-text";
  private static final String COMPLETED_FLAG = "--completed";
  private static final String DUE_FLAG = "--due";
  private static final String PRIORITY_FLAG = "--priority";
  private static final String CATEGORY_FLAG = "--category";
  private static final String COMPLETE_TODO_FLAG = "--complete-todo";
  private static final String DISPLAY_FLAG = "--display";
  private static final String SHOW_INCOMPLETE_FLAG = "--show-incomplete";
  private static final String SHOW_CATEGORY_FLAG = "--show-category";
  private static final String SORT_BY_DATE_FLAG = "--sort-by-date";
  private static final String SORT_BY_PRIORITY_FLAG = "--sort-by-priority";
  private static final int MIN_NUM_OF_ARGS = 3;
  private static final int DEFAULT_PRIORITY = 3;


  /**
   * parse the command line arguments and check for possible error
   *
   * @param args - string[], command line arguments
   * @return - Map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if command line arguments is not provided correctly
   */
  public Map<Flag, Object> parseCommandLineArgs(String[] args) throws CMDLineParserException {
    Map<Flag, Object> todoOption = new HashMap<>();
    checkCMDArgsNumValid(args);
    checkNumOfCommandLineArg(args);
    checkSortByDate(args, todoOption);
    checkSortByPriority(args, todoOption);
    checkIfSortingByTwoFlag(todoOption);
    checkCSVFile(args, todoOption);
    checkAddTodoAndTodoText(args, todoOption);
    checkCompleted(args, todoOption);
    checkDue(args, todoOption);
    checkPriority(args, todoOption);
    checkCategory(args, todoOption);
    checkCompleteTodo(args, todoOption);
    checkDisplay(args, todoOption);
    checkShowIncomplete(args, todoOption);
    checkShowCategory(args, todoOption);
    return todoOption;
  }

  /**
   * check if command line arguments number is larger than 3. The --display can without any
   * arguments, but it also needs to read the csv file and its path. so the minimum command line
   * argument is 3. There is no maximum command line arguments since user can complete multiple
   * todos tasks by repeating.
   *
   * @param args - string[], command line arguments
   * @throws CMDLineParserException if the number of command line arguments are less than 3.
   */
  private void checkCMDArgsNumValid(String[] args) throws CMDLineParserException {
    if (args.length < MIN_NUM_OF_ARGS) {
      throw new CMDLineParserException(
          "Error: The number of command line arguments need to be greater than or equal to 3.");
    }
  }

  /**
   * This method aims to check if the user request SortByDate and SortByPriority at the same time.
   *
   * @param todoOption - Map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException Throw exception if the user request SortByDate and
   *                                SortByPriority at the same time.
   */
  private void checkIfSortingByTwoFlag(Map<Flag, Object> todoOption) throws CMDLineParserException {
    if (todoOption.containsKey(Flag.SORT_BY_PRIORITY) && todoOption.containsKey(
        Flag.SORT_BY_DATE)) {
      throw new CMDLineParserException(
          "Error: --sort-by-date cannot be combined with --sort-by-priority.");
    }
  }


  /**
   * This method aims to check if there are any flags that occur more than once in the command line
   * arguments
   *
   * @param args - String[], command line arguments
   * @throws CMDLineParserException Throw exception if there are any flags except --complete-todo
   *                                flag occur more than once in the command line arguments
   */
  private void checkNumOfCommandLineArg(String[] args) throws CMDLineParserException {
    Set<String> flagSet = new HashSet<>();
    for (String arg : args) {
      if (isCommand(arg) && !arg.equals(COMPLETE_TODO_FLAG) && flagSet.contains(arg)) {
        throw new CMDLineParserException(
            "Error: Except for --complete-todo flag, all other flags should only occur once in the command line arguments.");
      }
      flagSet.add(arg);
    }
  }

  /**
   * check if the csv file exists. if --csv file is provided and the path is also provided, save it
   * in the todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --csv-file is not provided ir the file path is
   *                                invalid
   */
  private void checkCSVFile(String[] args, Map<Flag, Object> todoOption)
      throws CMDLineParserException {
    boolean hasCSVFile = false;
    boolean hasCSVFilePath = false;
    String CSVFIlePath = null;

    for (int i = 0; i < args.length; i++) {
      if (hasCSVFilePath) {
        break;
      }
      if (args[i].equals(CSV_FILE_FLAG)) {
        hasCSVFile = true;
        if (i + 1 < args.length) {
          String possibleCVSFilePath = args[i + 1];
          if (isCommand(possibleCVSFilePath)) {
            throw new CMDLineParserException(
                "Error: --csv-file was provided but the csv file path was not provided");
          }
          try {
            Paths.get(possibleCVSFilePath);
            hasCSVFilePath = true;
            CSVFIlePath = possibleCVSFilePath;
          } catch (InvalidPathException ipe) {
            throw new CMDLineParserException(
                "Error: -- csv-file is provided but the csv file path is either not provided or not correct");
          }
        } else {
          throw new CMDLineParserException(
              "Error: --csv-file was provided but the csv file path was not provided");
        }
      }
    }
    if (!hasCSVFile) {
      throw new CMDLineParserException("Error: --csv-file was required but not provided");
    }
    todoOption.put(Flag.CSV_FILE, CSVFIlePath);
  }

  /**
   * check if --add-todo and --todo-text exists. if they both exist and description of text, save it
   * in todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --add-todo is not provided, or --todo-text or text are
   *                                not provided
   */
  private void checkAddTodoAndTodoText(String[] args, Map<Flag, Object> todoOption)
      throws CMDLineParserException {
    boolean hasAddTodo = false;
    boolean hasTodoText = false;
    boolean hasTextDescription = false;
    String textDescription = null;

    for (int i = 0; i < args.length; i++) {
      if (hasAddTodo && hasTextDescription) {
        break;
      }
      if (args[i].equals(ADD_TODO_FLAG)) {
        hasAddTodo = true;
      } else if (args[i].equals(TODO_TEXT_FLAG)) {
        hasTodoText = true;
        if (i + 1 < args.length) {
          String possibleTextDescription = args[i + 1];
          if (possibleTextDescription.length() == 0 || isCommand(possibleTextDescription)) {
            throw new CMDLineParserException(
                "Error: Text description was either not provided or not correct.");
          } else {
            textDescription = possibleTextDescription;
            hasTextDescription = true;
          }
        } else {
          throw new CMDLineParserException("Error: Text description was not provided.");
        }
      }
    }
    if (hasAddTodo && hasTextDescription) {
      todoOption.put(Flag.ADD_TODO, textDescription);
    } else if (hasAddTodo) {
      throw new CMDLineParserException(
          "Error: --add-todo was provided but no --todo-text was given.");
    } else if (hasTodoText) {
      throw new CMDLineParserException(
          "Error: --todo-text was provided but no --add-todo was given.");
    }
  }

  /**
   * check if --completed exists. if it exists, mark it true, and save it in todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkCompleted(String[] args, Map<Flag, Object> todoOption) {
    for (String arg : args) {
      if (arg.equals(COMPLETED_FLAG)) {
        todoOption.put(Flag.COMPLETED, true);
        return;
      }
    }
  }

  /**
   * check if --due exists. if --due and date format are provided, save it to todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --due is not provided or date format is not correct
   */
  private void checkDue(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(DUE_FLAG)) {
        if (i + 1 < args.length) {
          String possibleDate = args[i + 1];
          try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            LocalDate dueDate = LocalDate.parse(possibleDate, formatter);
            todoOption.put(Flag.DUE, dueDate);
            return;
          } catch (DateTimeParseException e) {
            throw new CMDLineParserException(
                "Error: The due date was either not provided or its format could not be parsed. Please try again!");
          }
        } else {
          throw new CMDLineParserException("Error: The due date was not provided.");
        }
      }
    }
  }

  /**
   * check if priority exists. if --priority and priority number exist, save them in the todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --priority is not provided or priority number is not
   *                                "1","2","3"
   */
  private void checkPriority(String[] args, Map<Flag, Object> todoOption)
      throws CMDLineParserException {

    boolean hasPriorityNum = false;
    int priorityNum = DEFAULT_PRIORITY;

    Set<String> priorityOptions = new HashSet<>(Arrays.asList("1", "2", "3"));

    for (int i = 0; i < args.length; i++) {
      if (hasPriorityNum) {
        break;
      }

      if (args[i].equals(PRIORITY_FLAG)) {
        if (i + 1 < args.length) {
          String possiblePriorityNum = args[i + 1];
          if (priorityOptions.contains(possiblePriorityNum)) {
            hasPriorityNum = true;
            priorityNum = Integer.parseInt(possiblePriorityNum);
          } else {
            throw new CMDLineParserException("Error: The priority number is not 1, 2 or 3.");
          }
        } else {
          throw new CMDLineParserException(
              "Error: --priority was provided but no value was given.");
        }
      }
    }
    todoOption.put(Flag.PRIORITY, priorityNum);
  }

  /**
   * check if category exists. if --category and category name exist, save them in the todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --category is not provided or priority name is not
   *                                provided
   */
  private void checkCategory(String[] args, Map<Flag, Object> todoOption)
      throws CMDLineParserException {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(CATEGORY_FLAG)) {
        if (i + 1 < args.length) {
          String possibleCategoryName = args[i + 1];
          if (isCommand(possibleCategoryName)) {
            throw new CMDLineParserException("Error: The category name was not provided.");
          } else {
            todoOption.put(Flag.CATEGORY, possibleCategoryName);
            return;
          }
        } else {
          throw new CMDLineParserException("Error: The category name was not provided.");
        }
      }
    }
  }

  /**
   * check if --completed-todo exists. if --completed-todo and id exist, save them in the
   * todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --completed-todo is not provided or id is not
   *                                provided
   */
  private void checkCompleteTodo(String[] args, Map<Flag, Object> todoOption)
      throws CMDLineParserException {
    List<Integer> completedIDs = new ArrayList<>();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(COMPLETE_TODO_FLAG)) {
        if (i + 1 < args.length) {
          String possibleID = args[i + 1];
          try {
            int id = Integer.parseInt(possibleID);
            completedIDs.add(id);
          } catch (NumberFormatException ipe) {
            throw new CMDLineParserException(
                "Error: The id was either not provided or not a number.");
          }
        } else {
          throw new CMDLineParserException("Error: The id was not provided.");
        }
      }
    }

    todoOption.put(Flag.COMPLETED_TODO, completedIDs);
  }


  /**
   * check if --display exists. if ---display exist, mark true, else mark false in the todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkDisplay(String[] args, Map<Flag, Object> todoOption) {
    for (String arg : args) {
      if (arg.equals(DISPLAY_FLAG)) {
        todoOption.put(Flag.DISPLAY, true);
        return;
      }
    }
  }

  /**
   * check if --show-incomplete exists. if --show-incomplete exist, mark true, else mark false in
   * the todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkShowIncomplete(String[] args, Map<Flag, Object> todoOption) {
    for (String arg : args) {
      if (arg.equals(SHOW_INCOMPLETE_FLAG)) {
        todoOption.put(Flag.SHOW_INCOMPLETE, true);
        return;
      }
    }
  }

  /**
   * check if --show-category exists. if --show-category exist, check if the user correctly provided
   * the category, if not throw CMDLineParserException
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException - if the user does not provide the correct category name, then
   *                                throw CMDLineParserException
   */
  private void checkShowCategory(String[] args, Map<Flag, Object> todoOption)
      throws CMDLineParserException {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(SHOW_CATEGORY_FLAG)) {
        if (i + 1 < args.length) {
          String possibleCategory = args[i + 1];
          if (isCommand(possibleCategory)) {
            throw new CMDLineParserException("Error: The category name was not provided.");
          } else {
            todoOption.put(Flag.SHOW_CATEGORY, possibleCategory);
            return;
          }
        } else {
          throw new CMDLineParserException("Error: The category name was not provided.");
        }
      }
    }
  }

  /**
   * check if --sort-by-date exists. if --sort-by-date exist, mark true, else mark false in the
   * todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkSortByDate(String[] args, Map<Flag, Object> todoOption) {
    for (String arg : args) {
      if (arg.equals(SORT_BY_DATE_FLAG)) {
        todoOption.put(Flag.SORT_BY_DATE, true);
        return;
      }
    }
  }

  /**
   * check if --sort-by-priority exists. if --sort-by-priority exist, mark true, else mark false in
   * the todoOption
   *
   * @param args       - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkSortByPriority(String[] args, Map<Flag, Object> todoOption) {
    for (String arg : args) {
      if (arg.equals(SORT_BY_PRIORITY_FLAG)) {
        todoOption.put(Flag.SORT_BY_PRIORITY, true);
      }
    }
  }

  /**
   * check if a specific argument is a valid command. If it is, return true, otherwise return false
   *
   * @param arg - string[], command line arguments
   * @return - boolean, return true if a specific argument is a valid command, otherwise return
   * false
   */
  private boolean isCommand(String arg) {
    Set<String> commands = new HashSet<>(
        Arrays.asList(CSV_FILE_FLAG, ADD_TODO_FLAG, TODO_TEXT_FLAG, COMPLETED_FLAG, DUE_FLAG,
            PRIORITY_FLAG, CATEGORY_FLAG,
            COMPLETE_TODO_FLAG, DISPLAY_FLAG, SHOW_INCOMPLETE_FLAG, SHOW_CATEGORY_FLAG,
            SORT_BY_DATE_FLAG, SORT_BY_PRIORITY_FLAG));
    return commands.contains(arg);
  }
}

