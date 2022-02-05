package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CleaningTest {

  @Test
  public void calculatePriceSmallSizeNoPetsNoDiscount() {
    Cleaning cleaning = new Cleaning(5, false, PropertySize.SMALL, "abc", 0);
    assertEquals(80.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeNoPetsMonthlyDiscount() {
    Cleaning cleaning = new Cleaning(5, true, PropertySize.SMALL, "abc", 0);
    assertEquals(72.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeNoPets10thDiscount() {
    Cleaning cleaning = new Cleaning(9, false, PropertySize.SMALL, "abc", 0);
    assertEquals(40.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceSmallSizeNoPetsBothMonthlyDiscountAnd10thDiscount() {
    Cleaning cleaning = new Cleaning(9, true, PropertySize.SMALL, "abc", 0);
    assertEquals(40.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeNoPetsNoDiscount() {
    Cleaning cleaning = new Cleaning(5, false, PropertySize.MEDIUM, "abc", 0);
    assertEquals(160.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceLargeSizeNoPetsNoDiscount() {
    Cleaning cleaning = new Cleaning(5, false, PropertySize.LARGE, "abc", 0);
    assertEquals(320.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeOnePetNoDiscount() {
    Cleaning cleaning = new Cleaning(5, false, PropertySize.MEDIUM, "abc", 1);
    assertEquals(168.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPetsNoDiscount() {
    Cleaning cleaning = new Cleaning(5, false, PropertySize.MEDIUM, "abc", 2);
    assertEquals(168.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeThreePetsNoDiscount() {
    Cleaning cleaning = new Cleaning(5, false, PropertySize.MEDIUM, "abc", 3);
    assertEquals(171.2, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPetsMonthlyDiscount() {
    Cleaning cleaning = new Cleaning(5, true, PropertySize.MEDIUM, "abc", 2);
    assertEquals(151.2, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeThreePetsMonthlyDiscount() {
    Cleaning cleaning = new Cleaning(5, true, PropertySize.MEDIUM, "abc", 3);
    assertEquals(154.08, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPets10thDiscount() {
    Cleaning cleaning = new Cleaning(19, false, PropertySize.MEDIUM, "abc", 2);
    assertEquals(84.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeTwoPetsBothMonthlyDiscountAnd10thDiscount() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 2);
    assertEquals(84.0, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void calculatePriceMediumSizeThreePetsBothMonthlyDiscountAnd10thDiscount() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    assertEquals(85.6, cleaning.calculatePrice(), 0.01);
  }

  @Test
  public void testEqualsSameMemoryAddress() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    Cleaning copy = cleaning;
    assertTrue(
        copy.equals(cleaning) && cleaning.equals(copy) && cleaning.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressSameContent() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    Cleaning copy = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    assertTrue(
        copy.equals(cleaning) && cleaning.equals(copy) && cleaning.hashCode() == copy.hashCode());
  }

  @Test
  public void testEqualsDifferentMemoryAddressDifferentContent() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    Cleaning copy = new Cleaning(5, true, PropertySize.LARGE, "abc", 3);
    assertFalse(copy.equals(cleaning) || cleaning.equals(copy));
  }

  @Test
  public void testEqualsDifferentClass() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    Painting painting = new Painting(19, true, PropertySize.MEDIUM, "abc", 3);
    assertFalse(cleaning.equals(painting) || painting.equals(cleaning));
  }

  @Test
  public void testToString() {
    Cleaning cleaning = new Cleaning(19, true, PropertySize.MEDIUM, "abc", 3);
    String test = "Cleaning{petsNum=3, serviceNum=19, monthly=true, size=MEDIUM, address='abc'}";
    assertEquals(test, cleaning.toString());
  }
}