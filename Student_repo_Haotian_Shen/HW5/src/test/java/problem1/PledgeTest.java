package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;

public class PledgeTest {

  NonProfit np;

  @Test(expected = IllegalArgumentException.class)
  public void createPledgeWithProcessedDateTimeBeforeCreationDateTime() {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2014, Month.JANUARY, 15, 5, 5, 30));
  }

  @Test
  public void getProcessedDateTimeWithConstructorThatDoesNotHaveProcessedDateTime() {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertNull(((Pledge) pledge).getProcessedDateTime());
  }

  @Test
  public void getProcessedDateTimeWithConstructorThatHasProcessedDateTime() {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2016, Month.JANUARY, 15, 5, 5, 30));
    LocalDateTime processedDate = LocalDateTime.of(2016, Month.JANUARY, 15, 5, 5, 30);
    assertEquals(processedDate, ((Pledge) pledge).getProcessedDateTime());
  }

  @Test
  public void removeProcessedDateTime() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((Pledge) pledge).setProcessedDateTime(null);
    Donation d = np.getDonations().get(2015).get(pledge.getCreateDateTime());
    assertNull(((Pledge) d).getProcessedDateTime());
  }

  @Test
  public void setProcessedDateTimeWhenCurrentProcessedDateTimeIsNull()
      throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    ((Pledge) pledge).setProcessedDateTime(LocalDateTime.of(2016, Month.JANUARY, 15, 5, 5, 30));
    Donation d = np.getDonations().get(2015).get(pledge.getCreateDateTime());
    assertEquals(((Pledge) pledge).getProcessedDateTime(), ((Pledge) d).getProcessedDateTime());
  }

  @Test
  public void setProcessedDateTimeWithAfterCreationDate() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2015, Month.DECEMBER, 15, 5, 5, 30));
    ((Pledge) pledge).setProcessedDateTime(LocalDateTime.of(2016, Month.JANUARY, 15, 5, 5, 30));
    Donation d = np.getDonations().get(2015).get(pledge.getCreateDateTime());
    assertEquals(((Pledge) pledge).getProcessedDateTime(), ((Pledge) d).getProcessedDateTime());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setProcessedDateTimeWithBeforeCreationDate() throws IllegalArgumentException {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2016, Month.DECEMBER, 15, 5, 5, 30));
    ((Pledge) pledge).setProcessedDateTime(LocalDateTime.of(2014, Month.JANUARY, 15, 5, 5, 30));
  }

  @Test
  public void getDonationAmountForYearWhenProcessedDateNotSet() {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertEquals(0.0, pledge.getDonationAmountForYear(2015), 0.0);
  }

  @Test
  public void getDonationAmountForYearWhenProcessedDateSetButAfterCurrentYear() {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2016, Month.DECEMBER, 15, 5, 5, 30));
    assertEquals(0.0, pledge.getDonationAmountForYear(2015), 0.0);
  }

  @Test
  public void getDonationAmountForYearWhenProcessedDateSameYear() {
    np = new NonProfit("Charity");
    Donation pledge = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2015, Month.DECEMBER, 15, 5, 5, 30));
    assertEquals(125.0, pledge.getDonationAmountForYear(2015), 0.0);
  }

  @Test
  public void testEqualsSameAddress() {
    np = new NonProfit("Charity");
    Donation pledge1 = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2015, Month.DECEMBER, 15, 5, 5, 30));
    Donation pledge2 = pledge1;
    assertTrue(pledge2.equals(pledge1) && pledge1.equals(pledge2)
        && pledge1.hashCode() == pledge2.hashCode());
  }

  @Test
  public void testEqualsSameContent() {
    np = new NonProfit("Charity");
    Donation pledge1 = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2015, Month.DECEMBER, 15, 5, 5, 30));
    Donation pledge2 = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30),
        LocalDateTime.of(2015, Month.DECEMBER, 15, 5, 5, 30));
    assertTrue(pledge2.equals(pledge1) && pledge1.equals(pledge2)
        && pledge1.hashCode() == pledge2.hashCode());
    Donation pledge3 = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation pledge4 = new Pledge(np, 125.0, LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertTrue(pledge3.equals(pledge4) && pledge4.equals(pledge3)
        && pledge3.hashCode() == pledge4.hashCode());
  }
}