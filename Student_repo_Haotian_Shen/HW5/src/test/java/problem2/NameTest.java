package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameTest {

  Name name = new Name("a", "b");

  @Test
  public void getFirstName() {
    assertEquals("a", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("b", name.getLastName());
  }

  @Test
  public void testEqualsSameAddress() {
    Name nameCopy = name;
    assertTrue(
        nameCopy.equals(name) && name.equals(nameCopy) && name.hashCode() == nameCopy.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    Name nameCopy = new Name("a", "b");
    assertTrue(
        name.equals(nameCopy) && nameCopy.equals(name) && name.hashCode() == nameCopy.hashCode());
  }
}