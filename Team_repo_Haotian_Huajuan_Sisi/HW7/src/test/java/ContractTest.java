import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContractTest {

  Contract c;

  @Test(expected = NonNegativeException.class)
  public void createAskingPriceNegative() throws NonNegativeException {
    c = new Sale(-100.0, false);
  }

  @Test
  public void getAskingPrice() throws NonNegativeException {
    c = new Sale(1500.0, true);
    assertEquals(1500.0, c.getAskingPrice(), 0);
  }

  @Test
  public void getIsNegotiable() throws NonNegativeException {
    c = new Sale(1500.0, false);
    assertFalse(c.getIsNegotiable());
  }

  @Test
  public void getValue() throws NonNegativeException {
    c = new Sale(1500.0, true);
    assertEquals(1500.0, c.getValue(), 0);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws NonNegativeException {
    c = new Sale(1500.0, true);
    Contract test = c;
    assertTrue(c.equals(test) && test.equals(c) && c.hashCode() == test.hashCode());
  }

  @Test
  public void testEqualsSameContent() throws NonNegativeException {
    c = new Sale(1500.0, true);
    Contract test = new Sale(1500.0, true);
    assertTrue(c.equals(test) && test.equals(c) && c.hashCode() == test.hashCode());
  }

  @Test
  public void testEqualsDifferentClass() throws NonNegativeException {
    c = new Sale(1500.0, true);
    Contract test = new Rental(1500.0, true, 8);
    assertFalse(c.equals(test) || test.equals(c));
  }
}