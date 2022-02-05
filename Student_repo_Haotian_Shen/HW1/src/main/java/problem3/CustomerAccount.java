package problem3;

/**
 * CustomerAccount is an immutable class that has a first name and a last name of the customer. It
 * also has an Amount object to represent the amount of money currently in the cryptocurrency
 * account.
 */
final public class CustomerAccount {

  private static final int CENTS_TO_DOLLARS_CONVERSION = 100;
  private final String firstName;
  private final String lastName;
  private final Amount amount;

  /**
   * Constructor that creates a CustomerAccount object with the specified first name, last name and
   * amount of money in the account.
   *
   * @param firstName - first name of the account's owner.
   * @param lastName  - last name of the account's owner.
   * @param amount    - amount of money in the account.
   */
  public CustomerAccount(String firstName, String lastName, Amount amount) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.amount = amount;
  }

  /**
   * Returns the first name of the account's owner.
   *
   * @return the first name of the account's owner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the account's owner.
   *
   * @return the last name of the account's owner.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the amount of money in the account.
   *
   * @return the amount of money in the account.
   */
  public Amount getAmount() {
    return amount;
  }

  /**
   * Deposits the amount in the current account and returns a new account without modifying the
   * current account. This method ensures that the account is immutable.
   *
   * @param amount - the amount of money to be deposited in the account.
   * @return the new customer account with the amount after deposit.
   */
  public CustomerAccount deposit(Amount amount) {
    Integer dollarAmountAfterDeposit = amount.getDollarAmount() + this.amount.getDollarAmount();
    Integer centsAmountAfterDeposit = amount.getCentsAmount() + this.amount.getCentsAmount();
    Integer centsCarry = centsAmountAfterDeposit / CENTS_TO_DOLLARS_CONVERSION;
    dollarAmountAfterDeposit += centsCarry;
    centsAmountAfterDeposit %= CENTS_TO_DOLLARS_CONVERSION;
    Amount amountAfterDeposit = new Amount(dollarAmountAfterDeposit, centsAmountAfterDeposit);
    return new CustomerAccount(this.firstName, this.lastName, amountAfterDeposit);
  }

  /**
   * Withdraws the amount in the current account and returns a new account without modifying the
   * current account. If the withdrawing amount is greater than the current account balance, a
   * IllegalArgumentException will be thrown. This method ensures that the account is immutable.
   *
   * @param amount - the amount to be withdrawn.
   * @return the new customer account with the amount after withdraw.
   * @throws IllegalArgumentException if the withdrawing amount is greater than the current account
   *                                  balance.
   */
  public CustomerAccount withdraw(Amount amount) throws IllegalArgumentException {
    if (amount.getDollarAmount() > this.amount.getDollarAmount()) {
      throw new IllegalArgumentException(
          "You cannot withdraw more than your account balance. Currently there are only "
              + this.amount.getDollarAmount() + " dollars and " + this.amount.getCentsAmount()
              + " cents in your account");
    } else if (amount.getDollarAmount() == this.amount.getDollarAmount()) {
      if (amount.getCentsAmount() > this.amount.getCentsAmount()) {
        throw new IllegalArgumentException(
            "You cannot withdraw more than your account balance. Currently there are only "
                + this.amount.getDollarAmount() + " dollars and " + this.amount.getCentsAmount()
                + " cents in your account");
      }
    }
    Integer centsAmountAfterWithdraw = this.amount.getCentsAmount() - amount.getCentsAmount();
    Integer centsCarry = centsAmountAfterWithdraw >= 0 ? 0 : -1;
    centsAmountAfterWithdraw = centsAmountAfterWithdraw >= 0 ? centsAmountAfterWithdraw
        : this.amount.getCentsAmount() + (CENTS_TO_DOLLARS_CONVERSION - amount.getCentsAmount());
    Integer dollarAmountAfterWithdraw =
        this.amount.getDollarAmount() - amount.getDollarAmount() + centsCarry;
    Amount amountAfterWithdraw = new Amount(dollarAmountAfterWithdraw, centsAmountAfterWithdraw);
    return new CustomerAccount(this.firstName, this.lastName, amountAfterWithdraw);
  }
}
