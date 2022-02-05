package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NonEmptyBagOfWordsTest {

  BagOfWords bag;

  @Test
  public void emptyBagOfWords() {
    bag = new EmptyBagOfWords();
    assertTrue(bag.isEmpty());
  }

  @Test
  public void isEmpty() {
    bag = new NonEmptyBagOfWords("one");
    assertFalse(bag.isEmpty());
  }

  @Test
  public void size() {
    bag = new NonEmptyBagOfWords("one");
    assertEquals(1, bag.size(), 0);
  }

  @Test
  public void addWithoutDuplicate() {
    bag = new NonEmptyBagOfWords("one");
    bag = bag.add("two");
    bag = bag.add("three");
    bag = bag.add("four");
    assertEquals(4, bag.size(), 0);
  }

  @Test
  public void addWithDuplicate() {
    bag = new NonEmptyBagOfWords("one");
    bag = bag.add("one");
    bag = bag.add("one");
    bag = bag.add("two");
    bag = bag.add("three");
    bag = bag.add("four");
    assertEquals(6, bag.size(), 0);
  }

  @Test
  public void contains() {
    bag = new NonEmptyBagOfWords("one");
    bag = bag.add("two");
    bag = bag.add("three");
    bag = bag.add("four");
    assertTrue(bag.contains("one"));
    assertTrue(bag.contains("two"));
    assertFalse(bag.contains("five"));
  }

  @Test
  public void testEqualsSameAddress() {
    bag = new NonEmptyBagOfWords("one");
    bag = bag.add("two");
    bag = bag.add("three");
    bag = bag.add("four");
    BagOfWords bagCopy = bag;
    assertTrue(bag.equals(bagCopy) && bagCopy.equals(bag) && bag.hashCode() == bagCopy.hashCode());
  }

  @Test
  public void testEqualsSameContentWithoutDuplicate() {
    bag = new EmptyBagOfWords();
    bag = bag.add("one");
    bag = bag.add("two");
    bag = bag.add("three");
    bag = bag.add("four");
    BagOfWords bagCopy = new EmptyBagOfWords();
    bagCopy = bagCopy.add("one");
    bagCopy = bagCopy.add("two");
    bagCopy = bagCopy.add("three");
    bagCopy = bagCopy.add("four");
    assertTrue(bag.equals(bagCopy) && bagCopy.equals(bag) && bag.hashCode() == bagCopy.hashCode());
  }

  @Test
  public void testEqualsSameContentWithDuplicate() {
    bag = new EmptyBagOfWords();
    bag = bag.add("one");
    bag = bag.add("one");
    bag = bag.add("one");
    bag = bag.add("one");
    BagOfWords bagCopy = new EmptyBagOfWords();
    bagCopy = bagCopy.add("one");
    bagCopy = bagCopy.add("one");
    bagCopy = bagCopy.add("one");
    bagCopy = bagCopy.add("one");
    assertTrue(bag.equals(bagCopy) && bagCopy.equals(bag) && bag.hashCode() == bagCopy.hashCode());
  }
}