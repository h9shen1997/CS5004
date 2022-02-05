package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmptyBagOfWordsTest {

  BagOfWords bag;

  @Test
  public void emptyBagOfWords() {
    bag = new EmptyBagOfWords();
    assertEquals(0, bag.size(), 0);
  }

  @Test
  public void isEmpty() {
    bag = new EmptyBagOfWords();
    assertTrue(bag.isEmpty());
  }

  @Test
  public void size() {
    bag = new EmptyBagOfWords();
    assertEquals(0, bag.size(), 0);
  }

  @Test
  public void add() {
    bag = new EmptyBagOfWords();
    bag = bag.add("one");
    assertTrue(bag instanceof NonEmptyBagOfWords);
  }

  @Test
  public void contains() {
    bag = new EmptyBagOfWords();
    assertFalse(bag.contains("one"));
  }

  @Test
  public void testEqualsSameAddress() {
    bag = new EmptyBagOfWords();
    BagOfWords bagCopy = bag;
    assertTrue(bag.equals(bagCopy) && bagCopy.equals(bag) && bag.hashCode() == bagCopy.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    bag = new EmptyBagOfWords();
    BagOfWords bagCopy = new EmptyBagOfWords();
    assertTrue(bag.equals(bagCopy) && bagCopy.equals(bag) && bag.hashCode() == bagCopy.hashCode());
  }
}