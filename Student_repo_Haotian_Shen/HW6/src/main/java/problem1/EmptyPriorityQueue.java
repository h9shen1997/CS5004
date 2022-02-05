package problem1;

import java.util.Objects;

/**
 * An empty priority queue that has no priority or value.
 */
public final class EmptyPriorityQueue implements PriorityQueue {

  /**
   * Constructor for an empty priority queue.
   */
  public EmptyPriorityQueue() {
  }

  /**
   * Creates an empty priority queue.
   *
   * @return - a new empty priority queue.
   */
  @Override
  public PriorityQueue createEmpty() {
    return new EmptyPriorityQueue();
  }

  /**
   * Determine if empty priority queue is empty..
   *
   * @return - always true.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Add the element with the specified priority and value into the priority queue. This will return
   * a new non-empty priority queue, and the added element will be the only element in it.
   *
   * @param priority - Integer, the priority of the new object.
   * @param value    - String, the value of the new object.
   * @return - a new non-empty priority queue.
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new NonEmptyPriorityQueue(priority, value);
  }

  /**
   * Throw an exception when trying to peek from an empty priority queue.
   *
   * @return - will never return a string.
   * @throws PriorityQueueEmptyException always because the priority queue is empty.
   */
  @Override
  public String peek() throws PriorityQueueEmptyException {
    throw new PriorityQueueEmptyException("The priority queue is empty");
  }

  /**
   * Throw an exception when trying to pop from an empty priority queue.
   *
   * @return - will never return a new priotity queue.
   * @throws PriorityQueueEmptyException always because the priority queue is empty.
   */
  @Override
  public PriorityQueue pop() throws PriorityQueueEmptyException {
    throw new PriorityQueueEmptyException("The priority queue is empty");
  }

  /**
   * Get the priority of an empty priority queue.
   *
   * @return - always null.
   */
  @Override
  public Integer getPriority() {
    return null;
  }

  /**
   * Get the value of an empty priority queue.
   *
   * @return - always null.
   */
  @Override
  public String getValue() {
    return null;
  }

  /**
   * Get the rest of the empty priority queue.
   *
   * @return - always null.
   */
  @Override
  public PriorityQueue getRest() {
    return null;
  }

  /**
   * Set the rest of the empty priority queue. This function does not do anything, and it simply
   * exists to satisfy the requirement of the interface.
   *
   * @param rest - the rest of the priority queue.
   */
  @Override
  public void setRest(PriorityQueue rest) {
  }

  /**
   * Compare whether two empty priority queue are equal using the isEmpty function.
   *
   * @param o - the other priority queue object.
   * @return whether equal.
   */
  @Override
  public boolean equalsRecursive(PriorityQueue o) {
    return isEmpty() && o.isEmpty();
  }

  /**
   * Generate hashcode for the empty priority queue.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getPriority(), getValue(), getRest());
  }

  /**
   * Compare whether two empty priority queue objects are equal using the recursive equal method.
   *
   * @param o - the other empty priority queue object.
   * @return whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmptyPriorityQueue)) {
      return false;
    }
    EmptyPriorityQueue that = (EmptyPriorityQueue) o;
    return equalsRecursive(that);
  }

  /**
   * String expression of empty priority queue.
   *
   * @return string expression.
   */
  @Override
  public String toString() {
    return "EmptyPriorityQueue{}";
  }
}
