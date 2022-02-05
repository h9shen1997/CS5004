package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmptyPriorityQueueTest {

  PriorityQueue pq = new EmptyPriorityQueue();

  @Test(expected = PriorityQueueEmptyException.class)
  public void createEmpty() throws PriorityQueueEmptyException {
    pq = pq.createEmpty();
    String value = pq.peek();
  }

  @Test
  public void isEmptyWhenEmpty() {
    pq = pq.createEmpty();
    assertTrue(pq.isEmpty());
  }

  @Test
  public void addToEmptyPriorityQueue() {
    pq = pq.createEmpty();
    pq = pq.add(1, "cat");
    assertTrue(pq instanceof NonEmptyPriorityQueue);
  }

  @Test
  public void peekWithoutDuplicate() throws PriorityQueueEmptyException {
    pq = pq.createEmpty();
    pq = pq.add(1, "cat");
    pq = pq.add(2, "dog");
    pq = pq.add(1, "pig");
    pq = pq.add(2, "duck");
    assertEquals("duck", pq.peek());
  }

  @Test(expected = PriorityQueueEmptyException.class)
  public void peekWithDuplicate() throws PriorityQueueEmptyException {
    pq = pq.createEmpty();
    String value = pq.peek();
  }

  @Test(expected = PriorityQueueEmptyException.class)
  public void popWithDuplicate() throws PriorityQueueEmptyException {
    pq = pq.createEmpty();
    pq = pq.pop();
  }

  @Test
  public void getValueEmptyPQ() {
    pq = pq.createEmpty();
    assertNull(pq.getValue());
  }

  @Test
  public void getPriorityEmptyPQ() {
    pq = pq.createEmpty();
    assertNull(pq.getPriority());
  }

  @Test
  public void getRestEmptyPQ() {
    pq = pq.createEmpty();
    assertNull(pq.getRest());
  }

  @Test
  public void testEqualsSameAddress() {
    pq = pq.createEmpty();
    PriorityQueue pqCopy = new EmptyPriorityQueue();
    pqCopy = pq;
    assertTrue(pq.equals(pqCopy) && pqCopy.equals(pq) && pq.hashCode() == pqCopy.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    pq = pq.createEmpty();
    PriorityQueue pqCopy = new EmptyPriorityQueue();
    pqCopy = pqCopy.createEmpty();
    assertTrue(pq.equals(pqCopy) && pqCopy.equals(pq) && pq.hashCode() == pqCopy.hashCode());
  }
}