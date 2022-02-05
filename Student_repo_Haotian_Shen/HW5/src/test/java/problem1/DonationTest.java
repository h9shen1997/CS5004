package problem1;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;

public class DonationTest {

  NonProfit np;

  @Test
  public void getNp() {
    np = new NonProfit("Charity");
    Donation singleDonation = new SingleDonation(np, 50.0,
        LocalDateTime.of(2015, Month.JANUARY, 15, 5, 5, 30));
    assertEquals("Charity", singleDonation.getNp().getName());
  }
}