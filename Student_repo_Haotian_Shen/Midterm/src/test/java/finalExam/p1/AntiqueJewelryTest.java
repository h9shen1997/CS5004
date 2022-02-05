package finalExam.p1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AntiqueJewelryTest {

  AntiqueJewelry j;

  @Test(expected = IllegalAgeException.class)
  public void testIllegalAge() throws IllegalAskingPriceException, IllegalAgeException {
    j = new Necklaces("necklace", -5, Condition.MINT_CONDITION, Period.RETRO, 1000.0, 5.0);
  }

  @Test(expected = IllegalAskingPriceException.class)
  public void testIllegalAskingPrice() throws IllegalAskingPriceException, IllegalAgeException {
    j = new Necklaces("necklace", 50, Condition.MINT_CONDITION, Period.RETRO, -1000.0, 5.0);
  }

  @Test
  public void getMetricCarats() throws IllegalAskingPriceException, IllegalAgeException {
    j = new Necklaces("necklace", 100, Condition.USED, Period.EDWARDIAN, 100000.0, 5.0);
    assertEquals(5.0, j.getMetricCarats(), 0);
  }

  @Test
  public void getStartingBidFromVictorianPeriod()
      throws IllegalAskingPriceException, IllegalAgeException {
    j = new Earrings("earrings", 100, Condition.USED, Period.VICTORIAN, 1000.0, 5.0);
    assertEquals(1275.0, j.calculateStartingBid(), 0.0);
  }

  @Test
  public void getStartingBidFromArtDecoAndMoreThan8Carats()
      throws IllegalAskingPriceException, IllegalAgeException {
    j = new Rings("rings", 100, Condition.LIGHTLY_USED, Period.ART_DECO, 1000.0, 9.0);
    assertEquals(101020.0, j.calculateStartingBid(), 0.0);
  }

  @Test
  public void getStartingBidFromArtDecoButLessThan8Carats()
      throws IllegalAskingPriceException, IllegalAgeException {
    j = new Rings("rings", 100, Condition.LIGHTLY_USED, Period.ART_DECO, 1000.0, 5.0);
    assertEquals(1020.0, j.calculateStartingBid(), 0.0);
  }

  @Test
  public void getStartingBidFromEdwardianAndMoreThan8Carats()
      throws IllegalAskingPriceException, IllegalAgeException {
    j = new Rings("rings", 100, Condition.LIGHTLY_USED, Period.EDWARDIAN, 1000.0, 10.0);
    assertEquals(1020.0, j.calculateStartingBid(), 0.0);
  }

  @Test
  public void getStartingBidInMintCondition()
      throws IllegalAskingPriceException, IllegalAgeException {
    j = new Necklaces("necklace", 100, Condition.MINT_CONDITION, Period.ART_NOUVEAU, 1000.0, 5.0);
    assertEquals(1071.0, j.calculateStartingBid(), 0.0);
  }

  @Test
  public void getStartingBidMoreThan125Years()
      throws IllegalAskingPriceException, IllegalAgeException {
    j = new Earrings("earrings", 150, Condition.DAMAGED, Period.RETRO, 1000.0, 5.0);
    assertEquals(2295.0, j.calculateStartingBid(), 0.0);
  }
}