import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TodoParser parse the csv file and check for errors
 */
public class TodoParser {

  private static final String CSV_FILE_DELIMITER = "\" *, *\"";
  private static final String ID = "id";
  private static final String TEXT = "text";
  private static final String COMPLETED = "completed";
  private static final String DUE = "due";
  private static final String PRIORITY = "priority";
  private static final String CATEGORY = "category";
  private static final String QUESTION_MARK = "?";
  private static final String NO_INCOMPLETE_MESSAGE = "There is no incomplete todo list items. Please try again!";
  private static final String NO_THIS_CATEGORY_MESSAGE = "There is no todo item that belongs to the provided category. Please try again!";
  private static final String NO_TODO_ITEMS_MESSAGE = "There is currently no todo item.";
  private static final String[] CSV_HEADER = new String[]{ID, TEXT, COMPLETED, DUE, PRIORITY,
      CATEGORY};
  private static final int ID_INDEX = 0;
  private static final int TEXT_INDEX = 1;
  private static final int COMPLETED_INDEX = 2;
  private static final int DUE_INDEX = 3;
  private static final int PRIORITY_INDEX = 4;
  private static final int CATEGORY_INDEX = 5;
  private static final int DEFAULT_PRIORITY = 3;
  private final List<Todo> allTodos = new ArrayList<>();
  private final Map<Flag, Object> options;

  /**
   * constructor to create a TodoParse with the specified options
   *
   * @param options -Map<String, Object>, a map of the flag to the possible actions
   */
  public TodoParser(Map<Flag, Object> options) {
    this.options = options;
  }

  /**
   * run the tasks based on command information
   *
   * @throws FileParsingException         - If any of the writing or reading to or from file fails
   * @throws IDNotExistException          - If the specific id is not found in the csv file
   * @throws EmptyFilteredResultException - If the filtered result of the csv file is empty
   */
  public void processCommandsBasedOnOption()
      throws FileParsingException, IDNotExistException, EmptyFilteredResultException {
    parseCSVFileToTodoObjects();

    if (options.containsKey(Flag.ADD_TODO)) {
      addTodo();
    }
    if (options.containsKey(Flag.COMPLETED_TODO)) {
      completeTodo();
    }
    if (options.containsKey(Flag.DISPLAY)) {
      display();
    }
    writeToCSVFile();
  }

  /**
   * parse the csv input file with all the supporter's information and store it
   *
   * @throws FileParsingException if the parsing of csv input file is incorrect
   */
  private void parseCSVFileToTodoObjects() throws FileParsingException {
    String csvFilePath = (String) options.get(Flag.CSV_FILE);
    try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {
      String line;
      int index = 0;
      while ((line = csvReader.readLine()) != null) {
        line = line.substring(1, line.length() - 1);
        String[] splitLine = line.split(CSV_FILE_DELIMITER);
        if (index > 0) {
          Todo todo = lineToTodoObject(splitLine);
          allTodos.add(todo);
        }
        index++;
      }
    } catch (IOException | DateTimeFormatException e) {
      throw new FileParsingException(
          "Error: Something went wrong while parsing csv input file. Please check either the file path or date time format.");
    }
  }

  /**
   * parse a certain line which is in form of a list of string, and convert it to a Todo object
   *
   * @param splitLine -String[] a line of the csv file saved as a list of the string
   * @return - Todo, a Todo object
   * @throws DateTimeFormatException, if there is any error when convert the string date to the
   *                                  LocalDate object
   */
  private Todo lineToTodoObject(String[] splitLine) throws DateTimeFormatException {
    Integer id = Integer.parseInt(splitLine[ID_INDEX]);
    String text = splitLine[TEXT_INDEX];
    boolean completed = Boolean.parseBoolean(splitLine[COMPLETED_INDEX]);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    LocalDate due =
        splitLine[DUE_INDEX].equals(QUESTION_MARK) ? null
            : LocalDate.parse(splitLine[DUE_INDEX], formatter);
    Integer priority = splitLine[PRIORITY_INDEX].equals(QUESTION_MARK) ? DEFAULT_PRIORITY
        : Integer.parseInt(splitLine[PRIORITY_INDEX]);
    String category =
        splitLine[CATEGORY_INDEX].equals(QUESTION_MARK) ? null : splitLine[CATEGORY_INDEX];
    return new Todo(id, text, completed, priority, due, category);
  }

  /**
   * Write everything to the csv file
   *
   * @throws FileParsingException if any of writing ot reading to or from file fails
   */
  private void writeToCSVFile() throws FileParsingException {
    String csvFilePath = (String) options.get(Flag.CSV_FILE);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
      StringBuilder sb = new StringBuilder();
      for (String s : CSV_HEADER) {
        sb.append("\"").append(s).append("\"").append(",");
      }
      sb.deleteCharAt(sb.length() - 1);
      writer.write(sb + System.lineSeparator());
      for (Todo todo : allTodos) {
        writer.write(todo.toString() + System.lineSeparator());
      }
    } catch (IOException e) {
      throw new FileParsingException(
          "Error: Something went wrong when writing to the " + csvFilePath
              + " file.");
    }
  }

  /**
   * Add new todo to the csv input file based on the flag option
   */
  private void addTodo() {
    int ID = allTodos.size() == 0 ? 1 : allTodos.get(allTodos.size() - 1).getId() + 1;
    String textDescription = (String) options.get(Flag.ADD_TODO);
    LocalDate due = (LocalDate) options.getOrDefault(Flag.DUE, null);
    String category = (String) options.getOrDefault(Flag.CATEGORY, null);
    Integer priority = (Integer) options.getOrDefault(Flag.PRIORITY, DEFAULT_PRIORITY);
    Todo addedTodoItem = new Todo(ID, textDescription, options.containsKey(Flag.COMPLETED),
        priority, due, category);
    allTodos.add(addedTodoItem);
  }

  /**
   * Change complete status to true if completed todo id exist in file, and update the csv file
   *
   * @throws IDNotExistException - if a specific id is not found in the todo list
   */
  @SuppressWarnings("unchecked")
  private void completeTodo() throws IDNotExistException {
    if (!options.containsKey(Flag.COMPLETED_TODO)) {
      return;
    }
    List<Integer> IDs = (ArrayList<Integer>) options.get(Flag.COMPLETED_TODO);
    for (int ID : IDs) {
      if (ID > allTodos.size()) {
        throw new IDNotExistException("The id provided in the --complete-todo flag does not exist");
      }
      allTodos.get(ID - 1).setCompleted(true);
    }
  }

  /**
   * print out the to do list
   *
   * @param todoList   - List<Todo>, list of todo object
   * @param errMessage - String, error message
   * @throws EmptyFilteredResultException - if the filtered result of todos list of empty
   */
  private void displayTodosInList(List<Todo> todoList, String errMessage)
      throws EmptyFilteredResultException {
    if (todoList.size() == 0) {
      throw new EmptyFilteredResultException(errMessage);
    }
    for (Todo todo : todoList) {
      System.out.println(todo.toString());
    }
    System.out.println();
  }

  /**
   * display the csv file based on the flag options
   *
   * @throws EmptyFilteredResultException - if the filtered result of the list is empty * ToDos list
   *                                      is empty.
   */
  private void display() throws EmptyFilteredResultException {
    displayHeader();
    List<Todo> sortedUnfilteredList = sortBasedOnOptions();
    if (!options.containsKey(Flag.SHOW_CATEGORY) && !options.containsKey(Flag.SHOW_INCOMPLETE)) {
      displayTodosInList(sortedUnfilteredList, NO_TODO_ITEMS_MESSAGE);
    }
    if (options.containsKey(Flag.SHOW_INCOMPLETE)) {
      List<Todo> incompleteTodoList = filterIncomplete(sortedUnfilteredList);
      displayTodosInList(incompleteTodoList, NO_INCOMPLETE_MESSAGE);
    }
    if (options.containsKey(Flag.SHOW_CATEGORY)) {
      List<Todo> sameCategoryTodoList = filterByCategory((String) options.get(Flag.SHOW_CATEGORY),
          sortedUnfilteredList);
      displayTodosInList(sameCategoryTodoList, NO_THIS_CATEGORY_MESSAGE);
    }
  }

  /**
   * display the header of the csv file
   */
  private void displayHeader() {
    StringBuilder sb = new StringBuilder();
    for (String header : CSV_HEADER) {
      sb.append("\"").append(header).append("\",");
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
  }

  /**
   * Filter the list to only include incomplete Todos
   *
   * @param unfilteredList - unfiltered list of todos
   * @return -List<Todo>, filtered list of todos
   */
  private List<Todo> filterIncomplete(List<Todo> unfilteredList) {
    List<Todo> incompleteList = new ArrayList<>();
    for (Todo todo : unfilteredList) {
      if (!todo.getCompleted()) {
        incompleteList.add(todo);
      }
    }
    return incompleteList;
  }

  /**
   * Filter the list to only include Todos with a particular category;
   *
   * @param unfilteredList - unfiltered list of todos
   * @return - List<Todo>, filtered list of todos
   */
  private List<Todo> filterByCategory(String category, List<Todo> unfilteredList) {
    List<Todo> sameCategoryList = new ArrayList<>();
    for (Todo todo : unfilteredList) {
      if (todo.getCategory() != null && todo.getCategory().equals(category)) {
        sameCategoryList.add(todo);
      }
    }
    return sameCategoryList;
  }

  /**
   * Sort the list of todos based on particular criteria. This is not in-place sort.
   *
   * @param isSortingByPriority - boolean, if it is true, then sort by priority, it is false, then
   *                            sort by date, if this argument is not provided, then return the copy
   *                            of the list.
   * @return - List<Todo>, a new list of todos after sorting, not in-place sorting
   */
  private List<Todo> sort(Boolean isSortingByPriority) {
    List<Todo> copy = new ArrayList<>(allTodos);
    if (isSortingByPriority == null) {
      return copy;
    }
    copy.sort((o1, o2) -> {
      if (isSortingByPriority) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
      } else {
        if (o1.getDue() != null && o2.getDue() != null) {
          return o1.getDue().compareTo(o2.getDue());
        } else if (o1.getDue() != null) {
          return -1;
        } else if (o2.getDue() != null) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    return copy;
  }


  /**
   * Sort the list of todos based on particular option. This is not in-place sort.
   *
   * @return - List<Todo>, a new list of todos after sorting, not in-place sorting
   */
  private List<Todo> sortBasedOnOptions() {
    if (options.containsKey(Flag.SORT_BY_DATE)) {
      return sort(false);
    }
    if (options.containsKey(Flag.SORT_BY_PRIORITY)) {
      return sort(true);
    }
    return sort(null);
  }
}
