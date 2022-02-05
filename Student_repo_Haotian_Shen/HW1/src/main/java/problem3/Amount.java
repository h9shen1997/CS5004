package problem3;

/**
 * Amount is an immutable class that represents the amount of dollar and cents in a cryptocurrency
 * account
 */
final public class Amount {

  private final Integer dollarAmount;
  private final Integer centsAmount;

  /**
   * Constructor that creates a new Amount object with the specified dollarAmount and centsAmount.
   *
   * @param dollarAmount - dollar amount.
   * @param centsAmount  - cents amount.
   */
  public Amount(Integer dollarAmount, Integer centsAmount) {
    this.dollarAmount = dollarAmount;
    this.centsAmount = centsAmount;
  }

  /**
   * Returns the dollar amount.
   *
   * @return the dollar amount.
   */
  public Integer getDollarAmount() {
    return dollarAmount;
  }

  /**
   * Returns the cents amount.
   *
   * @return the cents amount.
   */
  public Integer getCentsAmount() {
    return centsAmount;
  }
}
