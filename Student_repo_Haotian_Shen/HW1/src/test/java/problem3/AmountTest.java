package problem3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AmountTest {

  private Amount amount;

  @Before
  public void setUp() throws NullPointerException {
    amount = new Amount(45, 58);
    if (amount == null) {
      throw new NullPointerException("The Amount object has not been initialized yet.");
    }
  }

  @Test
  public void getDollarAmount() {
    Integer expectedDollarAmount = 45;
    assertEquals("The dollar amount must be 45", expectedDollarAmount, amount.getDollarAmount());
  }

  @Test
  public void getCentsAmount() {
    Integer expectedCentsAmount = 58;
    assertEquals("The dollar amount must be 58", expectedCentsAmount, amount.getCentsAmount());
  }
}