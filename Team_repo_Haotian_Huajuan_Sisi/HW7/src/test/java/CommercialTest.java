import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommercialTest {

  Property p;

  @Test(expected = NonNegativeException.class)
  public void createCommercialWithLessThanZeroOffices() throws NonNegativeException {
    p = new Commercial("abc", 120, -1, false);
  }

  @Test
  public void getNumOfOffices() throws NonNegativeException {
    p = new Commercial("abc", 120, 2, false);
    assertEquals(2, ((Commercial) p).getNumOfOffices(), 0);
  }

  @Test
  public void getSuitableForRetail() throws NonNegativeException {
    p = new Commercial("abc", 120, 2, false);
    assertFalse(((Commercial) p).getSuitableForRetail());
  }

  @Test
  public void testEqualsSameMemoryAddress() throws NonNegativeException {
    p = new Commercial("abc", 120, 2, false);
    Property test = p;
    assertTrue(p.equals(test) && test.equals(p) && test.hashCode() == p.hashCode());
  }

  @Test
  public void testEqualsSameContent() throws NonNegativeException {
    p = new Commercial("abc", 120, 2, false);
    Property test = new Commercial("abc", 120, 2, false);
    assertTrue(p.equals(test) && test.equals(p) && test.hashCode() == p.hashCode());
  }

  @Test
  public void testEqualsDifferentContent() throws NonNegativeException {
    p = new Commercial("abc", 120, 2, false);
    Property test = new Commercial("abc", 140, 2, false);
    assertFalse(p.equals(test) || test.equals(p));
  }

  @Test
  public void testEqualsDifferentClass() throws NonNegativeException {
    p = new Commercial("abc", 120, 2, false);
    Property test = new Residential("abc", 140, 2, 2.5);
    assertFalse(p.equals(test) || test.equals(p));
  }
}