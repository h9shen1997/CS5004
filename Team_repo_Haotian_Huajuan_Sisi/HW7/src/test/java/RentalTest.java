import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RentalTest {

  Contract c;

  @Test(expected = NonNegativeException.class)
  public void createRentalWithTermEqualToZero() throws NonNegativeException {
    c = new Rental(1200.0, false, 0);
  }

  @Test(expected = NonNegativeException.class)
  public void createRentalWithTermLessThanZero() throws NonNegativeException {
    c = new Rental(1200.0, false, -1);
  }

  @Test
  public void getTerm() throws NonNegativeException {
    c = new Rental(1200.0, false, 6);
    assertEquals(6, ((Rental) c).getTerm(), 0);
  }

  @Test
  public void getValue() throws NonNegativeException {
    c = new Rental(1200.0, false, 6);
    assertEquals(7200.0, c.getValue(), 0);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws NonNegativeException {
    c = new Rental(1200.0, false, 6);
    Contract test = c;
    assertTrue(c.equals(test) && test.equals(c) && c.hashCode() == test.hashCode());
  }

  @Test
  public void testEqualsSameContent() throws NonNegativeException {
    c = new Rental(1200.0, false, 6);
    Contract test = new Rental(1200.0, false, 6);
    assertTrue(c.equals(test) && test.equals(c) && c.hashCode() == test.hashCode());
  }

  @Test
  public void testEqualsDifferentContent() throws NonNegativeException {
    c = new Rental(1200.0, false, 6);
    Contract test = new Rental(1300.0, true, 6);
    assertFalse(c.equals(test) || test.equals(c));
  }
}