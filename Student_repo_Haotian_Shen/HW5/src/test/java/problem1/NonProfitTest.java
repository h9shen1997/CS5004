package problem1;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class NonProfitTest {

  NonProfit np;

  @Test
  public void testGetName() {
    np = new NonProfit("Charity");
    Donation singleDonation = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation monthlyDonation = new MonthlyDonation(np, 100.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation pledgesDonation = new Pledge(np, 100.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertEquals("Charity", np.getName());
  }

  @Test
  public void testGetDonations() {
    Map<Integer, Map<LocalDateTime, Donation>> testCollection = new HashMap<>();
    np = new NonProfit("Charity");
    Donation singleDonation = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation monthlyDonation = new MonthlyDonation(np, 100.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation pledgesDonation = new Pledge(np, 100.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    testCollection.put(2015, new HashMap<>());
    Map<LocalDateTime, Donation> identifierToDonation = testCollection.get(2015);
    identifierToDonation.put(singleDonation.getCreateDateTime(), singleDonation);
    identifierToDonation.put(monthlyDonation.getCreateDateTime(), monthlyDonation);
    identifierToDonation.put(pledgesDonation.getCreateDateTime(), pledgesDonation);
    assertEquals(testCollection, np.getDonations());
  }

  @Test
  public void testGetTotalDonationsForYear() {
    np = new NonProfit("Charity");
    Donation singleDonation1 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    Donation monthlyDonation1 = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.JANUARY, 16, 5, 5, 30));
    Donation pledgesDonation1 = new Pledge(np, 100.0,
        LocalDateTime.of(2015, Month.JANUARY, 17, 5, 5, 30));
    Donation singleDonation2 = new SingleDonation(np, 50.0,
        LocalDateTime.of(2016, Month.JANUARY, 18, 5, 5, 30));
    Donation monthlyDonation2 = new MonthlyDonation(np, 10.0,
        LocalDateTime.of(2015, Month.MAY, 19, 5, 5, 30));
    Donation pledgesDonation2 = new Pledge(np, 100.0,
        LocalDateTime.of(2015, Month.JANUARY, 20, 5, 5, 30),
        LocalDateTime.of(2015, Month.JANUARY, 21, 5, 15, 30));
    assertEquals(350.0, np.getTotalDonationsForYear(2015), 0.0);
  }
}