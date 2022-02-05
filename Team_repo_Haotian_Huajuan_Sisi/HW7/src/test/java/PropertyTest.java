import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PropertyTest {

  Property p;

  @Test(expected = NonNegativeException.class)
  public void createWithSizeLessThanZero() throws NonNegativeException {
    p = new Residential("abc", -100, 2, 2.5);
  }

  @Test
  public void getAddress() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.5);
    assertEquals("abc", p.getAddress());
  }

  @Test
  public void getSize() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.5);
    assertEquals(100, p.getSize(), 0);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.5);
    Property test = p;
    assertTrue(p.equals(test) && test.equals(p) && test.hashCode() == p.hashCode());
  }

  @Test
  public void testEqualsSameContent() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.5);
    Property test = new Residential("abc", 100, 2, 2.5);
    assertTrue(p.equals(test) && test.equals(p) && test.hashCode() == p.hashCode());
  }

  @Test
  public void testEqualsDifferentContent() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.5);
    Property test = new Residential("cde", 110, 2, 2.5);
    assertFalse(p.equals(test) || test.equals(p));
  }
}