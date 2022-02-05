package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PaintingTest {

  @Test
  public void calculatePriceSmallSizeNoPetsNoDiscount() {
    Painting painting = new Painting(5, false, PropertySize.SMALL, "abc", 0);
    assertEquals(1280.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeNoPetsMonthlyDiscount() {
    Painting painting = new Painting(5, true, PropertySize.SMALL, "abc", 0);
    assertEquals(1152.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeNoPets10thDiscount() {
    Painting painting = new Painting(9, false, PropertySize.SMALL, "abc", 0);
    assertEquals(640.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeNoPetsBothMonthlyDiscountAnd10thDiscount() {
    Painting painting = new Painting(9, true, PropertySize.SMALL, "abc", 0);
    assertEquals(640.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeNoPetsNoDiscount() {
    Painting painting = new Painting(5, false, PropertySize.MEDIUM, "abc", 0);
    assertEquals(1280.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeNoPetsNoDiscount() {
    Painting painting = new Painting(5, false, PropertySize.LARGE, "abc", 0);
    assertEquals(1920.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeOnePetNoDiscount() {
    Painting painting = new Painting(5, false, PropertySize.MEDIUM, "abc", 1);
    assertEquals(1344.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPetsNoDiscount() {
    Painting painting = new Painting(5, false, PropertySize.MEDIUM, "abc", 2);
    assertEquals(1344.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeThreePetsNoDiscount() {
    Painting painting = new Painting(5, false, PropertySize.MEDIUM, "abc", 3);
    assertEquals(1369.6, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPetsMonthlyDiscount() {
    Painting painting = new Painting(5, true, PropertySize.MEDIUM, "abc", 2);
    assertEquals(1209.6, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeThreePetsMonthlyDiscount() {
    Painting painting = new Painting(5, true, PropertySize.MEDIUM, "abc", 3);
    assertEquals(1232.64, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPets10thDiscount() {
    Painting painting = new Painting(19, false, PropertySize.MEDIUM, "abc", 2);
    assertEquals(672.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPetsBothMonthlyDiscountAnd10thDiscount() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 2);
    assertEquals(672.0, painting.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeThreePetsBothMonthlyDiscountAnd10thDiscount() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    assertEquals(684.8, painting.calculatePrice(), 0.01);
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    Painting copy = painting;
    assertTrue(
        copy.equals(painting) && painting.equals(copy) && painting.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    Painting copy = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    assertTrue(
        copy.equals(painting) && painting.equals(copy) && painting.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContent() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    Painting copy = new Painting(5, true, PropertySize.LARGE, "abc", 3);
    assertFalse(copy.equals(painting) || painting.equals(copy));
  }

  @Test
  public void testEqualsDifferentClass() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    assertFalse(painting.equals(cleaning) || cleaning.equals(painting));
  }

  @Test
  public void testToString() {
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    String test = "Painting{petsNum=3, serviceNum=19, monthly=true, size=MEDIUM, address='abc'}";
    assertEquals(test, painting.toString());
  }
}