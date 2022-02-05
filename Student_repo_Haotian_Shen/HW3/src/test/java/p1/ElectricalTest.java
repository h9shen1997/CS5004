package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ElectricalTest {

  @Test
  public void createWithZeroEmployeeNotComplex() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, false, PropertySize.SMALL, "a", 0, false);
    assertEquals(1, e.getEmployee(), 0);
  }

  @Test
  public void createWithTwoEmployeeNotComplex() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, false, PropertySize.SMALL, "a", 2, false);
    assertEquals(2, e.getEmployee(), 0);
  }

  @Test
  public void createWithOneEmployeeSmallSizeOrMediumSizeComplex()
      throws ElectricalServiceIllegalException {
    Electrical eSmall = new Electrical(5, false, PropertySize.SMALL, "a", 1, true);
    assertEquals(2, eSmall.getEmployee(), 0);
    Electrical eMedium = new Electrical(5, false, PropertySize.MEDIUM, "a", 1, true);
    assertEquals(2, eMedium.getEmployee(), 0);
  }

  @Test
  public void createWithTwoEmployeeLargeSizeComplex() throws ElectricalServiceIllegalException {
    Electrical eLarge = new Electrical(5, false, PropertySize.LARGE, "a", 2, true);
    assertEquals(3, eLarge.getEmployee(), 0);
  }

  @Test
  public void createWithLessThanFiveEmployee() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, false, PropertySize.LARGE, "a", 4, true);
  }

  @Test(expected = ElectricalServiceIllegalException.class)
  public void createWithMoreThanFourEmployee() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, false, PropertySize.LARGE, "a", 5, true);
  }

  @Test
  public void calculatePriceLargeSizeThreeEmployeeComplex()
      throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, false, PropertySize.LARGE, "a", 3, true);
    assertEquals(650.0, e.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeThreeEmployeeComplex10thService()
      throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(9, false, PropertySize.LARGE, "a", 3, true);
    assertEquals(650.0, e.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeThreeEmployeeComplexMonthlyDiscount()
      throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    assertEquals(650.0, e.calculatePrice(), 0.01);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    Electrical copy = e;
    assertTrue(e.equals(copy) && copy.equals(e) && e.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent()
      throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    Electrical copy = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    assertTrue(e.equals(copy) && copy.equals(e) && e.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContent()
      throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, false, PropertySize.LARGE, "a", 3, true);
    Electrical copy = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    assertFalse(e.equals(copy) || copy.equals(e));
  }

  @Test
  public void testEqualsDifferentClass() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    Plumbing p = new Plumbing(5, true, PropertySize.LARGE, "a", 3, true);
    assertFalse(p.equals(e) || e.equals(p));
  }

  @Test
  public void testToString() throws ElectricalServiceIllegalException {
    Electrical e = new Electrical(5, true, PropertySize.LARGE, "a", 3, true);
    String test = "Electrical{serviceNum=5, monthly=true, size=LARGE, address='a', employee=3, isComplex=true}";
    assertEquals(test, e.toString());
  }
}