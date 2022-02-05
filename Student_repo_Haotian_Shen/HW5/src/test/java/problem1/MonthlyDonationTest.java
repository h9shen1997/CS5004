package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;

public class MonthlyDonationTest {

  NonProfit np;

  @Test
  public void getCancelDateTimeAfterCreationWhenCancelDateNotSet() {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertNull(((MonthlyDonation) monthlyDonation).getCancelDateTime());
  }

  @Test
  public void setAfterCancelDateAfterCreation() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((MonthlyDonation) monthlyDonation).setCancelDateTime(
        LocalDateTime.of(2015, Month.MAY, 15, 5, 5, 30));
    LocalDateTime identifier = monthlyDonation.getCreateDateTime();
    Donation d = np.getDonations().get(2015).get(identifier);
    assertEquals(((MonthlyDonation) d).getCancelDateTime(),
        ((MonthlyDonation) monthlyDonation).getCancelDateTime());
  }


  @Test(expected = IllegalArgumentException.class)
  public void setPriorCancelDateAfterCreation() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((MonthlyDonation) monthlyDonation).setCancelDateTime(
        LocalDateTime.of(2014, Month.DECEMBER, 15, 5, 5, 30));
  }

  @Test
  public void removeCancelDate() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((MonthlyDonation) monthlyDonation).setCancelDateTime(null);
    assertNull(((MonthlyDonation) monthlyDonation).getCancelDateTime());
  }

  @Test
  public void getDonationAmountForYearWhenCancelDateNotSet() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertEquals(120.0, monthlyDonation.getDonationAmountForYear(2015), 0.0);
  }


  @Test
  public void getDonationAmountForYearWhenCancelDateYearGreaterThanCreateYear()
      throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((MonthlyDonation) monthlyDonation).setCancelDateTime(
        LocalDateTime.of(2016, Month.DECEMBER, 15, 5, 5, 30));
    assertEquals(120.0, monthlyDonation.getDonationAmountForYear(2015), 0.0);
  }

  @Test
  public void getDonationAmountForYearWhenCancelDateYearSameYearAsCreateYear()
      throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation monthlyDonation = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((MonthlyDonation) monthlyDonation).setCancelDateTime(
        LocalDateTime.of(2015, Month.MAY, 15, 5, 5, 30));
    assertEquals(50.0, monthlyDonation.getDonationAmountForYear(2015), 0.0);
  }

  @Test
  public void testEqualsSameAddress() {
    np = new NonProfit("Charity");
    Donation monthlyDonation1 = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation monthlyDonation2 = monthlyDonation1;
    assertTrue(
        monthlyDonation1.equals(monthlyDonation2) && monthlyDonation2.equals(monthlyDonation1));
  }

  @Test
  public void testEqualsSameContent() {
    np = new NonProfit("Charity");
    Donation monthlyDonation1 = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation monthlyDonation2 = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertTrue(
        monthlyDonation1.equals(monthlyDonation2) && monthlyDonation2.equals(monthlyDonation1));
  }
}