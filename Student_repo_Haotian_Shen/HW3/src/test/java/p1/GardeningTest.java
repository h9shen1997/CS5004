package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GardeningTest {

  @Test
  public void calculatePriceSmallSizeNoDiscount() {
    Gardening gardening = new Gardening(5, false, PropertySize.SMALL, "a");
    assertEquals(100.0, gardening.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeMonthlyDiscount() {
    Gardening gardening = new Gardening(5, true, PropertySize.SMALL, "a");
    assertEquals(90.0, gardening.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSize10thDiscount() {
    Gardening gardening = new Gardening(9, false, PropertySize.SMALL, "a");
    assertEquals(50.0, gardening.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeBothMonthlyDiscountAnd10thDiscount() {
    Gardening gardening = new Gardening(9, true, PropertySize.SMALL, "a");
    assertEquals(50.0, gardening.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeNoDiscount() {
    Gardening gardening = new Gardening(5, false, PropertySize.MEDIUM, "a");
    assertEquals(180.0, gardening.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeNoDiscount() {
    Gardening gardening = new Gardening(5, false, PropertySize.LARGE, "a");
    assertEquals(340.0, gardening.calculatePrice(), 0.01);
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Gardening gardening = new Gardening(5, false, PropertySize.LARGE, "a");
    Gardening copy = gardening;
    assertTrue(gardening.equals(copy) && copy.equals(gardening)
        && gardening.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    Gardening gardening = new Gardening(5, false, PropertySize.LARGE, "a");
    Gardening copy = new Gardening(5, false, PropertySize.LARGE, "a");
    assertTrue(gardening.equals(copy) && copy.equals(gardening)
        && gardening.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContent() {
    Gardening gardening = new Gardening(9, true, PropertySize.LARGE, "a");
    Gardening copy = new Gardening(5, false, PropertySize.LARGE, "a");
    assertFalse(gardening.equals(copy) || copy.equals(gardening));
  }

  @Test
  public void testEqualsDifferentClass() throws WindowFloorExceedingMaxException {
    Gardening gardening = new Gardening(9, true, PropertySize.LARGE, "a");
    WindowCleaning wc = new WindowCleaning(9, true, PropertySize.LARGE, "a", 2);
    assertFalse(wc.equals(gardening) || gardening.equals(wc));
  }

  @Test
  public void testToString() {
    Gardening gardening = new Gardening(9, true, PropertySize.LARGE, "a");
    String test = "Gardening{serviceNum=9, monthly=true, size=LARGE, address='a'}";
    assertEquals(test, gardening.toString());
  }
}