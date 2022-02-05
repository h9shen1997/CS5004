package problem1;

/**
 * PriorityQueue interface defines the functionality of a recursive priority queue data structure.
 * It contains a priority as an integer and a value associated with the priority as a string. The
 * priority queue is implemented as a max heap, so that the element with the highest priority is
 * always at the first element in the priority queue.
 */
public interface PriorityQueue {

  /**
   * Creates an empty priority queue with null priority and null value.
   *
   * @return - a new empty priority queue.
   */
  PriorityQueue createEmpty();

  /**
   * Determine if the priority queue is empty.
   *
   * @return - whether the priority queue is empty.
   */
  Boolean isEmpty();

  /**
   * Add the priority and value to the current priority queue and return a new priority queue. If
   * the priority is the same, then the priority will be determined by which string is greater. The
   * greater string value will always have a higher priority in the queue.
   *
   * @param priority - Integer, the priority of the new object.
   * @param value    - String, the value of the new object.
   * @return - a new priority queue.
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Display the element with the highest priority in the priority queue.
   *
   * @return the highest priority element.
   * @throws PriorityQueueEmptyException if the priority queue is empty.
   */
  String peek() throws PriorityQueueEmptyException;

  /**
   * Remove the element with the highest priority in the priority queue and return a new priority
   * queue.
   *
   * @return the new priority queue with the highest priority element removed.
   * @throws PriorityQueueEmptyException if the priority queue is empty.
   */
  PriorityQueue pop() throws PriorityQueueEmptyException;

  /**
   * Return the priority of the current element.
   *
   * @return - Integer, the priority.
   */
  Integer getPriority();

  /**
   * Return the value of the current element.
   *
   * @return - String, the value.
   */
  String getValue();

  /**
   * Get the rest of the element in the priority queue after this first priority element.
   *
   * @return - a priority queue representing the rest of the element from this element.
   */
  PriorityQueue getRest();

  /**
   * Set the rest of the element in the priority queue to the specified priority queue.
   *
   * @param pq - the specified rest object.
   */
  void setRest(PriorityQueue pq);

  /**
   * Recursively check if the two priority queues are equal.
   *
   * @param o - the other priority queue object.
   * @return - whether equal.
   */
  boolean equalsRecursive(PriorityQueue o);
}
