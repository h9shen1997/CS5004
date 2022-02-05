import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResidentialTest {

  Property p;

  @Test(expected = NonNegativeException.class)
  public void createResidentialWithNegativeBedRoom() throws NonNegativeException {
    p = new Residential("abc", 100, -1, 2.0);
  }

  @Test(expected = NonNegativeException.class)
  public void createResidentialWithNegativeBathRoom() throws NonNegativeException {
    p = new Residential("abc", 100, 1, -1.5);
  }


  @Test
  public void getNumOfBedrooms() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.0);
    assertEquals(2, ((Residential) p).getNumOfBedrooms(), 0);
  }

  @Test
  public void getNumOfBathrooms() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.0);
    assertEquals(2.0, ((Residential) p).getNumOfBathrooms(), 0);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.0);
    Property test = p;
    assertTrue(p.equals(test) && test.equals(p) && test.hashCode() == p.hashCode());
  }

  @Test
  public void testEqualsSameContent() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.0);
    Property test = new Residential("abc", 100, 2, 2.0);
    assertTrue(p.equals(test) && test.equals(p) && test.hashCode() == p.hashCode());
  }

  @Test
  public void testEqualsDifferentContent() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.0);
    Property test = new Residential("cdsd", 122, 2, 2.0);
    assertFalse(p.equals(test) || test.equals(p));
  }

  @Test
  public void testEqualsDifferentClass() throws NonNegativeException {
    p = new Residential("abc", 100, 2, 2.0);
    Property test = new Commercial("cdsd", 122, 2, true);
    assertFalse(p.equals(test) || test.equals(p));
  }
}