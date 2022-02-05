package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WindowCleaningTest {

  @Test(expected = WindowFloorExceedingMaxException.class)
  public void createWindowCleaningWithMoreThan3Floor() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.SMALL, "a", 4);
  }

  @Test
  public void createWindowCleaningWithLessThan3Floor() throws WindowFloorExceedingMaxException {
    WindowCleaning wc1 = new WindowCleaning(5, false, PropertySize.SMALL, "a", 1);
    WindowCleaning wc2 = new WindowCleaning(5, false, PropertySize.SMALL, "a", 2);
    WindowCleaning wc3 = new WindowCleaning(5, false, PropertySize.SMALL, "a", 3);
  }

  @Test
  public void testGetFloor() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.SMALL, "a", 2);
    assertEquals(2, wc.getFloor(), 0);
  }

  @Test
  public void calculatePriceSmallSizeGreaterThan1FloorNoDiscount()
      throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.SMALL, "a", 2);
    assertEquals(84.0, wc.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeLessThan2FloorNoDiscount()
      throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.SMALL, "a", 1);
    assertEquals(80.0, wc.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeMonthlyDiscount() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, true, PropertySize.SMALL, "a", 2);
    assertEquals(75.6, wc.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSize10thDiscount() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(9, false, PropertySize.SMALL, "a", 2);
    assertEquals(42.0, wc.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeBothMonthlyDiscountAnd10thDiscount()
      throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(9, true, PropertySize.SMALL, "a", 2);
    assertEquals(42.0, wc.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeNoDiscount() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.MEDIUM, "a", 2);
    assertEquals(168.0, wc.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeNoDiscount() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.LARGE, "a", 2);
    assertEquals(336.0, wc.calculatePrice(), 0.01);
  }

  @Test
  public void testEqualsSameMemoryAddress() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.LARGE, "a", 2);
    WindowCleaning copy = wc;
    assertTrue(wc.equals(copy) && copy.equals(wc) && wc.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent()
      throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(5, false, PropertySize.LARGE, "a", 2);
    WindowCleaning copy = new WindowCleaning(5, false, PropertySize.LARGE, "a", 2);
    assertTrue(wc.equals(copy) && copy.equals(wc) && wc.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContent()
      throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(9, true, PropertySize.LARGE, "a", 2);
    WindowCleaning copy = new WindowCleaning(5, false, PropertySize.LARGE, "a", 2);
    assertFalse(wc.equals(copy) || copy.equals(wc));
  }

  @Test
  public void testEqualsDifferentClass() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(9, true, PropertySize.LARGE, "a", 2);
    Gardening gardening = new Gardening(9, true, PropertySize.LARGE, "a");
    assertFalse(wc.equals(gardening) || gardening.equals(wc));
  }

  @Test
  public void testToString() throws WindowFloorExceedingMaxException {
    WindowCleaning wc = new WindowCleaning(9, true, PropertySize.LARGE, "a", 2);
    String test = "WindowCleaning{serviceNum=9, monthly=true, size=LARGE, address='a', floor=2}";
    assertEquals(test, wc.toString());
  }
}