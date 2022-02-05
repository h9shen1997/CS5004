package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SetTest {

  Set s;

  @Test
  public void emptySet() {
    s = new Set();
    Set emptySet = s.emptySet();
    assertEquals(0, emptySet.size(), 0);
  }

  @Test
  public void isEmpty() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    assertFalse(s.isEmpty());
    s = new Set();
    assertTrue(s.isEmpty());
  }

  @Test
  public void addUnseen() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    assertEquals(5, s.size(), 0);
    s = s.add(6);
    s = s.add(7);
    s = s.add(8);
    s = s.add(9);
    s = s.add(10);
    assertEquals(10, s.size(), 0);
  }

  @Test
  public void addSeen() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    assertEquals(5, s.size(), 0);
    s = s.add(5);
    assertEquals(5, s.size(), 0);
  }

  @Test
  public void addReturnNewSetCopy() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    Set t = s.add(6);
    assertEquals(5, s.size(), 0);
    assertEquals(6, t.size(), 0);
  }

  @Test
  public void contains() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    s = s.add(7);
    s = s.add(8);
    s = s.add(9);
    s = s.add(10);
    assertTrue(s.contains(5));
    assertFalse(s.contains(11));
  }

  @Test
  public void removeSeen() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    s = s.add(7);
    s = s.add(8);
    s = s.add(9);
    s = s.add(10);
    assertEquals(10, s.size(), 0);
    s = s.remove(5);
    assertEquals(9, s.size(), 0);
    assertFalse(s.contains(5));
  }

  @Test
  public void removeUnseen() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    assertEquals(6, s.size(), 0);
    s = s.remove(7);
    assertEquals(6, s.size(), 0);
  }

  @Test
  public void removeReturnNewCopy() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    Set t = s.remove(5);
    assertEquals(6, s.size(), 0);
    assertTrue(s.contains(5));
    assertEquals(5, t.size(), 0);
    assertFalse(t.contains(5));
  }

  @Test
  public void size() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    s = s.add(7);
    s = s.add(8);
    s = s.add(9);
    s = s.add(10);
    assertEquals(10, s.size(), 0);
    s = s.remove(5);
    assertEquals(9, s.size(), 0);
  }

  @Test
  public void testEqualsSameAddress() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    Set t = s;
    assertTrue(t.equals(s) && s.equals(t) && t.hashCode() == s.hashCode());
  }

  @Test
  public void testEqualsDifferentInsertionOrderSameContent() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    Set t = new Set();
    t = t.add(2);
    t = t.add(1);
    t = t.add(6);
    t = t.add(5);
    t = t.add(3);
    t = t.add(4);
    assertTrue(s.equals(t) && t.equals(s) && s.hashCode() == t.hashCode());
  }

  @Test
  public void testEqualsDifferentClass() {
    s = new Set();
    int[] intArray = new int[10];
    assertFalse(s.equals(intArray) || intArray.equals(s));
  }

  @Test
  public void testEqualsSameInsertionOrderSameContent() {
    s = new Set();
    s = s.add(1);
    s = s.add(2);
    s = s.add(3);
    s = s.add(4);
    s = s.add(5);
    s = s.add(6);
    Set t = new Set();
    t = t.add(1);
    t = t.add(2);
    t = t.add(3);
    t = t.add(4);
    t = t.add(5);
    t = t.add(6);
    assertTrue(s.equals(t) && t.equals(s) && s.hashCode() == t.hashCode());
  }
}