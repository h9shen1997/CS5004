package finalExam.p1;

/**
 * AntiqueKitchenware class represents an antique kitchenware. The antique kitchenware becomes more
 * valuable if the kitchenware can form a set.
 */
public class AntiqueKitchenware extends Antique {

  protected static final double FORM_SET_MULTIPLIER = 2.1;
  protected boolean canFormASet;

  public AntiqueKitchenware(String name, Integer age, Condition condition, Period period,
      Double askingPrice, boolean canFormASet)
      throws IllegalAgeException, IllegalAskingPriceException {
    super(name, age, condition, period, askingPrice);
    this.canFormASet = canFormASet;
  }

  /**
   * Calculate the starting bid of an antique kitchenware. The kitchenware will become more valuable
   * if it can form a set. If so, multiply the base value by 2.1.
   *
   * @return Double, the starting bid of an antique kitchenware.
   */
  @Override
  protected Double calculateStartingBid() {
    Double startingBid = super.calculateStartingBid();
    if (canFormASet()) {
      startingBid *= FORM_SET_MULTIPLIER;
    }
    return startingBid;
  }

  /**
   * Getter for whether the kitchenware can form a set.
   *
   * @return boolean, whether the kitchenware can form a set.
   */
  protected boolean canFormASet() {
    return canFormASet;
  }
}
