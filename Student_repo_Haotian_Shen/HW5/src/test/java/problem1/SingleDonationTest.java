package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;

public class SingleDonationTest {

  NonProfit np;

  @Test
  public void testGetDonationAmountForYear() {
    np = new NonProfit("Charity");
    Donation singleDonation1 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation singleDonation2 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2016, Month.JANUARY, 15, 5, 5, 30));
    Donation singleDonation3 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2017, Month.JANUARY, 15, 5, 5, 30));
    assertEquals(50.0, singleDonation1.getDonationAmountForYear(2015), 0.0);
    assertEquals(50.0, singleDonation2.getDonationAmountForYear(2016), 0.0);
    assertEquals(50.0, singleDonation3.getDonationAmountForYear(2017), 0.0);
  }

  @Test
  public void testEqualsSameAddress() {
    np = new NonProfit("Charity");
    Donation singleDonation1 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation singleDonation2 = singleDonation1;
    assertTrue(singleDonation2.equals(singleDonation1) && singleDonation1.equals(singleDonation2)
        && singleDonation1.hashCode() == singleDonation2.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    np = new NonProfit("Charity");
    Donation singleDonation1 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation singleDonation2 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertTrue(singleDonation2.equals(singleDonation1) && singleDonation1.equals(singleDonation2)
        && singleDonation1.hashCode() == singleDonation2.hashCode());
  }
}