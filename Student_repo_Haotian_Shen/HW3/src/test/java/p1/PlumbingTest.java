package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlumbingTest {

  @Test
  public void createWithZeroEmployeeNotComplex() {
    Plumbing p = new Plumbing(5, false, PropertySize.SMALL, "a", 0, false);
    assertEquals(1, p.getEmployee(), 0);
  }

  @Test
  public void createWithTwoEmployeeNotComplex() {
    Plumbing p = new Plumbing(5, false, PropertySize.SMALL, "a", 2, false);
    assertEquals(2, p.getEmployee(), 0);
  }

  @Test
  public void createWithOneEmployeeSmallSizeOrMediumSizeComplex() {
    Plumbing pSmall = new Plumbing(5, false, PropertySize.SMALL, "a", 1, true);
    assertEquals(2, pSmall.getEmployee(), 0);
    Plumbing pMedium = new Plumbing(5, false, PropertySize.MEDIUM, "a", 1, true);
    assertEquals(2, pMedium.getEmployee(), 0);
  }

  @Test
  public void createWithTwoEmployeeLargeSizeComplex() {
    Plumbing pLarge = new Plumbing(5, false, PropertySize.LARGE, "a", 2, true);
    assertEquals(3, pLarge.getEmployee(), 0);
  }

  @Test
  public void calculatePriceLargeSizeThreeEmployeeComplex() {
    Plumbing p = new Plumbing(5, false, PropertySize.LARGE, "a", 3, true);
    assertEquals(620.0, p.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeThreeEmployeeComplex10thService() {
    Plumbing p = new Plumbing(9, false, PropertySize.LARGE, "a", 3, true);
    assertEquals(620.0, p.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeThreeEmployeeComplexMonthlyDiscount() {
    Plumbing p = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    assertEquals(620.0, p.calculatePrice(), 0.01);
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Plumbing p = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    Plumbing copy = p;
    assertTrue(p.equals(copy) && copy.equals(p) && p.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    Plumbing p = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    Plumbing copy = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    assertTrue(p.equals(copy) && copy.equals(p) && p.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContent() {
    Plumbing p = new Plumbing(5, false, PropertySize.LARGE, "a", 3, true);
    Plumbing copy = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    assertFalse(p.equals(copy) || copy.equals(p));
  }

  @Test
  public void testEqualsDifferentClass() throws ElectricalServiceIllegalException {
    Plumbing p = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    Electrical e = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    assertFalse(p.equals(e) || e.equals(p));
  }

  @Test
  public void testToString() {
    Plumbing p = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    String test = "Plumbing{serviceNum=5, monthly=true, size=LARGE, address='a', employee=3, isComplex=true}";
    assertEquals(test, p.toString());
  }
}