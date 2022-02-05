package problem3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerAccountTest {

  private final String expectedFirstName = "Haotian";
  private final String expectedLastName = "Shen";
  private CustomerAccount account;

  @Before
  public void setUp() throws Exception {
    final Amount amount = new Amount(50, 38);
    account = new CustomerAccount("Haotian", "Shen", amount);
    if (account == null) {
      throw new NullPointerException("The CustomerAccount object has not been initialized yet.");
    }
  }

  @Test
  public void getFirstName() {
    assertEquals("The first name of the account owner must be Haotian", expectedFirstName,
        account.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("The last name of the account owner must be Shen", expectedLastName,
        account.getLastName());
  }

  @Test
  public void getAmount() {
    Amount amount = account.getAmount();
    Integer dollarAmount = amount.getDollarAmount();
    Integer centsAmount = amount.getCentsAmount();
    final Integer expectedDollarAmount = 50;
    final Integer expectedCentsAmount = 38;
    assertEquals("The dollar amount of the account should be 50", expectedDollarAmount,
        dollarAmount);
    assertEquals("The cents amount of the account should be 38", expectedCentsAmount, centsAmount);
  }

  @Test
  public void deposit() {
    final Integer depositDollarAmount = 27;
    final Integer depositCentsAmount = 84;
    final Integer expectedDollarAmount = 78;
    final Integer expectedCentsAmount = 22;
    final Amount deposit = new Amount(depositDollarAmount, depositCentsAmount);
    CustomerAccount accountAfterDeposit = account.deposit(deposit);
    Integer dollarAmountAfterDeposit = accountAfterDeposit.getAmount().getDollarAmount();
    Integer centsAmountAfterDeposit = accountAfterDeposit.getAmount().getCentsAmount();
    assertEquals("The dollar amount after deposit must be 78", expectedDollarAmount,
        dollarAmountAfterDeposit);
    assertEquals("The cents amount after deposit must be 22", expectedCentsAmount,
        centsAmountAfterDeposit);
  }

  @Test
  public void withdraw() {
    final Integer withdrawDollarAmount = 22;
    final Integer withdrawCentsAmount = 46;
    final Integer expectedDollarAmount = 27;
    final Integer expectedCentsAmount = 92;
    final Amount withdraw = new Amount(withdrawDollarAmount, withdrawCentsAmount);
    CustomerAccount accountAfterWithdraw = account.withdraw(withdraw);
    Integer dollarAmountAfterWithdraw = accountAfterWithdraw.getAmount().getDollarAmount();
    Integer centsAmountAfterWithdraw = accountAfterWithdraw.getAmount().getCentsAmount();
    assertEquals("The dollar amount after withdraw must be 27", expectedDollarAmount,
        dollarAmountAfterWithdraw);
    assertEquals("The cents amount after withdraw must be 92", expectedCentsAmount,
        centsAmountAfterWithdraw);
  }

  @Test(expected = IllegalArgumentException.class)
  public void withdrawMoreDollarsSameCents() {
    final Amount withdraw = new Amount(23, 57);
    CustomerAccount accountBeforeWithdraw = new CustomerAccount("Haotian", "Shen",
        new Amount(22, 57));
    CustomerAccount accountAfterWithdraw = accountBeforeWithdraw.withdraw(withdraw);
  }

  @Test(expected = IllegalArgumentException.class)
  public void withdrawSameDollarsMoreCents() {
    final Amount withdraw = new Amount(22, 58);
    CustomerAccount accountBeforeWithdraw = new CustomerAccount("Haotian", "Shen",
        new Amount(22, 57));
    CustomerAccount accountAfterWithdraw = accountBeforeWithdraw.withdraw(withdraw);
  }
}