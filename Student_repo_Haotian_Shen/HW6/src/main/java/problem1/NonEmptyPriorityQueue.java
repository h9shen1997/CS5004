package problem1;

import java.util.Objects;

/**
 * A non-empty priority queue element has a priority and a value associated with it. It also
 * contains information for the rest of the other elements in the priority queue.
 */
public class NonEmptyPriorityQueue implements PriorityQueue {

  private final Integer priority;
  private final String value;
  private PriorityQueue rest;

  /**
   * Constructor that creates a new non-empty priority queue with the specified priority and value
   * for its first element.
   *
   * @param priority - specified priority for first element.
   * @param value    - specified value for first element.
   */
  public NonEmptyPriorityQueue(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
    this.rest = new EmptyPriorityQueue();
  }

  /**
   * Helper constructor to add the current element with the specified priority and value to the head
   * of the rest of the priority queue. This is a private helper constructor method that only used
   * in the add method.
   *
   * @param priority - Integer, the specified priority.
   * @param value    - String, the specified value.
   * @param rest     - PriorityQueue, the rest of the priority queue elements.
   */
  private NonEmptyPriorityQueue(Integer priority, String value, PriorityQueue rest) {
    this(priority, value);
    this.rest = rest;
  }

  /**
   * Getter for current element's priority.
   *
   * @return - Integer, the current element's priority.
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Getter for current element's string value.
   *
   * @return - String, the current element's string value.
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Getter for rest of the element after this current element in the priority queue.
   *
   * @return - PriorityQueue, the rest of the elements.
   */
  public PriorityQueue getRest() {
    return this.rest;
  }

  /**
   * Setter for the rest of the element in the priority queue based on the passed in element.
   *
   * @param rest - PriorityQueue, the rest of the elements.
   */
  public void setRest(PriorityQueue rest) {
    this.rest = rest;
  }

  /**
   * Create an empty priority queue.
   *
   * @return - PriorityQueue, the new empty priority queue.
   */
  @Override
  public PriorityQueue createEmpty() {
    return new EmptyPriorityQueue();
  }

  /**
   * Determine if the priority queue is empty or not.
   *
   * @return - always true since this is a non-empty priority queue.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Add the element with the specified priority and value into the priority queue. If the specified
   * element's priority is greater than or equal to the largest priority element in the priority
   * queue, then, simply set the current priority queue as the rest of the elements for the added
   * element. Otherwise, call addHelper method to recursively add the element to the correct
   * position. If the two items have the same priority, then the priority is determined based on
   * which string is greater.
   *
   * @param priority - Integer, the priority of the new object.
   * @param value    - String, the value of the new object.
   * @return - the new priority queue with the element added.
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    // If the element is already greater than or equal to the peek element in the queue, then simply
    // add this value as the new peek element of this priority queue.
    if (priority.compareTo(getPriority()) > 0) {
      return new NonEmptyPriorityQueue(priority, value, this);
    } else if (priority.equals(getPriority())) {
      if (value.compareTo(getValue()) >= 0) {
        return new NonEmptyPriorityQueue(priority, value, this);
      }
    }
    // Store a reference to the head of the priority queue and call the recursive addHelper method
    // to add the element to the correct position.
    PriorityQueue headPQ = this;
    addHelper(priority, value, headPQ);
    return this;
  }

  /**
   * Helper method to add the element to the correct position. It will maintain a reference to the
   * previous element in the priority queue, and if the current position is the correct insert
   * position, it will set the previous element's rest as the newly added element, and then set the
   * newly added element's rest as the previous rest element of the previous reference.
   *
   * @param priority - Integer, specified priority.
   * @param value    - String, specified string value.
   * @param prev     - PriorityQueue, a reference to the previous element in the priority queue.
   */
  private void addHelper(Integer priority, String value, PriorityQueue prev) {
    // Get the previous element's rest.
    PriorityQueue cur = prev.getRest();

    // If the current priority is null, which means it is at the empty priority queue position, it
    // will be a new non-empty priority queue element with the rest set to a new empty priority
    // queue.
    if (cur.getPriority() == null) {
      prev.setRest(new NonEmptyPriorityQueue(priority, value, new EmptyPriorityQueue()));
      return;
    } else if (priority.compareTo(cur.getPriority()) > 0) {
      prev.setRest(new NonEmptyPriorityQueue(priority, value, cur));
      return;
    } else if (priority.equals(cur.getPriority())) {
      if (value.compareTo(cur.getValue()) >= 0) {
        prev.setRest(new NonEmptyPriorityQueue(priority, value, cur));
        return;
      }
    }

    // Recursively call addHelper method with the previous element set to the rest of the previous
    // element.
    addHelper(priority, value, cur);
  }

  /**
   * Display the element with the highest priority in the queue without removing.
   *
   * @return - String, the value of the element.
   */
  @Override
  public String peek() {
    return this.value;
  }

  /**
   * Remove the element with the highest priority and return the new priority queue.
   *
   * @return - the priority queue with the element removed.
   */
  @Override
  public PriorityQueue pop() {
    return this.rest;
  }

  /**
   * Compare whether two elements are equal. This method will call the recursive function to
   * determine if the two object are equal in the order of priority and value.
   *
   * @param o - the other non-empty priority queue.
   * @return - whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonEmptyPriorityQueue)) {
      return false;
    }
    NonEmptyPriorityQueue that = (NonEmptyPriorityQueue) o;
    return equalsRecursive(that);
  }

  /**
   * Compare recursive whether the two non-empty queue are equal. If the current priority and value
   * are the same, then recursively check the rest of the element.
   *
   * @param o - the other priority queue object.
   * @return - whether equal.
   */
  @Override
  public boolean equalsRecursive(PriorityQueue o) {
    boolean curEqual =
        Objects.equals(getPriority(), o.getPriority()) && Objects.equals(getValue(), o.getValue());
    if (getRest() != null && o.getRest() != null) {
      return curEqual && getRest().equalsRecursive(o.getRest());
    }
    return curEqual;
  }

  /**
   * Generate the hashcode of a non-empty priority queue recursively.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getPriority(), getValue()) + getRest().hashCode();
  }

  /**
   * String expression of the non-empty priority queue.
   *
   * @return - string expression.
   */
  @Override
  public String toString() {
    return "NonEmptyPriorityQueue{" +
        "priority=" + priority +
        ", value='" + value + '\'' +
        ", rest=" + rest +
        '}';
  }
}
