import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This is a concrete class that has unique id, text, completed, due, priority, and, category. Once
 * it is created, all fields should be immutable with except completed
 */
public class Todo {

  private static final String DEFAULT_PRIORITY_STRING = "3";
  private static final String DATE_TIME_FORMAT = "M/d/yyyy";
  private static final String QUESTION_MARK = "?";
  private final Integer id;
  private final String text;
  private final LocalDate due;
  private final Integer priority;
  private final String category;
  private Boolean completed;

  /**
   * Constructor1 that creates a new object
   *
   * @param id        - specific id of the task
   * @param text      - a description of the task to be done. This field is required.
   * @param completed - indicates whether the task is completed or incomplete. If not specified,
   *                  this field should be false by default.
   * @param priority  - an integer indicating the priority of the task. This field is optional. If
   *                  the user chooses to specify a priority, it must be between 1 and 3.
   * @param due       - a due date. This field is optional.
   * @param category  - a user-specified String that can be used to group related todos, e.g.,
   *                  “school”, “work”, “home”. This field is optional.
   */
  public Todo(Integer id, String text, boolean completed, Integer priority, LocalDate due,
      String category) {
    this.id = id;
    this.text = text;
    this.completed = completed;
    this.due = due;
    this.priority = priority;
    this.category = category;
  }

  /**
   * Getter for ID.
   *
   * @return -Integer, specific id of the task
   */
  public Integer getId() {
    return id;
  }

  /**
   * Getter for completed.
   *
   * @return - boolean, return true if the task is completed, otherwise return false
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Setter for completed.
   */
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  /**
   * Getter for due date.
   *
   * @return - LocalDate, due date of the task
   */
  public LocalDate getDue() {
    return due;
  }

  /**
   * Getter for priority.
   *
   * @return - Integer, priority of the task, between 1 and 3.
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Getter for category.
   *
   * @return - String, category of the task.
   */
  public String getCategory() {
    return category;
  }

  /**
   * String expression of the Todo object.
   *
   * @return - String, string representation of the object
   */
  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    String dueString = this.due == null ? QUESTION_MARK : formatter.format(this.due);
    String priorityString =
        this.priority == null ? DEFAULT_PRIORITY_STRING : String.valueOf(this.priority);
    String categoryString = this.category == null ? QUESTION_MARK : this.category;
    return "\"" + id + "\","
        + "\"" + text + "\","
        + "\"" + completed + "\","
        + "\"" + dueString + "\","
        + "\"" + priorityString + "\","
        + "\"" + categoryString + "\"";
  }
}
