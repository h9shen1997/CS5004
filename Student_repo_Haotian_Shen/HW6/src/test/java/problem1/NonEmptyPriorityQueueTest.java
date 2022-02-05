package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NonEmptyPriorityQueueTest {

  PriorityQueue pq;

  @Test
  public void isEmptyWhenNotEmpty() {
    pq = new NonEmptyPriorityQueue(1, "cat");
    assertFalse(pq.isEmpty());
  }

  @Test
  public void addToNonEmptyPriorityQueue() {
    pq = new NonEmptyPriorityQueue(1, "cat");
    pq = pq.add(2, "dog");
    PriorityQueue rest = pq.getRest();
    assertEquals("cat", rest.getValue());
  }

  @Test
  public void peekSamePriorityDifferentValue() throws PriorityQueueEmptyException {
    pq = new NonEmptyPriorityQueue(2, "dog");
    pq = pq.add(2, "cat");
    assertEquals("dog", pq.peek());
  }

  @Test
  public void peekDifferentPriority() throws PriorityQueueEmptyException {
    pq = new NonEmptyPriorityQueue(2, "dog");
    pq = pq.add(1, "cat");
    assertEquals("dog", pq.peek());
  }

  @Test
  public void pop() throws PriorityQueueEmptyException {
    pq = new EmptyPriorityQueue();
    pq = pq.add(1, "cat");
    pq = pq.add(2, "ant");
    pq = pq.add(1, "dog");
    pq = pq.add(2, "elephant");
    pq = pq.add(2, "pig");
    pq = pq.add(2, "pig");
    pq = pq.add(1, "bird");
    pq = pq.add(4, "cat");
    pq = pq.add(4, "cat");
    pq = pq.add(3, "flamingo");
    assertEquals("cat", pq.peek());
    pq = pq.pop();
    assertEquals("cat", pq.peek());
    pq = pq.pop();
    assertEquals("flamingo", pq.peek());
    pq = pq.pop();
    assertEquals("pig", pq.peek());
    pq = pq.pop();
    assertEquals("pig", pq.peek());
    pq = pq.pop();
    assertEquals("elephant", pq.peek());
    pq = pq.pop();
    assertEquals("ant", pq.peek());
    pq = pq.pop();
    assertEquals("dog", pq.peek());
    pq = pq.pop();
    assertEquals("cat", pq.peek());
    pq = pq.pop();
    assertEquals("bird", pq.peek());
  }

  @Test
  public void testEqualsSameAddress() {
    pq = new EmptyPriorityQueue();
    pq = pq.add(1, "cat");
    pq = pq.add(2, "ant");
    pq = pq.add(1, "dog");
    pq = pq.add(2, "elephant");
    pq = pq.add(2, "pig");
    pq = pq.add(2, "pig");
    pq = pq.add(1, "bird");
    pq = pq.add(4, "cat");
    pq = pq.add(4, "cat");
    pq = pq.add(3, "flamingo");
    PriorityQueue pqCopy = pq;
    assertTrue(pq.equals(pqCopy) && pqCopy.equals(pq) && pq.hashCode() == pqCopy.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    pq = new EmptyPriorityQueue();
    pq = pq.add(1, "cat");
    pq = pq.add(2, "ant");
    pq = pq.add(1, "dog");
    pq = pq.add(2, "elephant");
    pq = pq.add(2, "pig");
    pq = pq.add(2, "pig");
    pq = pq.add(1, "bird");
    pq = pq.add(4, "cat");
    pq = pq.add(4, "cat");
    pq = pq.add(3, "flamingo");
    PriorityQueue pqCopy = new EmptyPriorityQueue();
    pqCopy = pqCopy.add(1, "cat");
    pqCopy = pqCopy.add(2, "ant");
    pqCopy = pqCopy.add(1, "dog");
    pqCopy = pqCopy.add(2, "elephant");
    pqCopy = pqCopy.add(2, "pig");
    pqCopy = pqCopy.add(2, "pig");
    pqCopy = pqCopy.add(1, "bird");
    pqCopy = pqCopy.add(4, "cat");
    pqCopy = pqCopy.add(4, "cat");
    pqCopy = pqCopy.add(3, "flamingo");
    assertTrue(pq.equals(pqCopy) && pqCopy.equals(pq) && pq.hashCode() == pqCopy.hashCode());
  }
}