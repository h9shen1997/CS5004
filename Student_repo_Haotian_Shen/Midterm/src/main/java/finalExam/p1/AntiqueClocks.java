package finalExam.p1;

/**
 * AntiqueClocks class represents a general class of antique clock. The clock will become less
 * valuable if the clock is damaged or used.
 */
public abstract class AntiqueClocks extends Antique {

  protected static final double BROKEN_DECREASE_MULTIPLIER = 0.7;

  public AntiqueClocks(String name, Integer age, Condition condition, Period period,
      Double askingPrice) throws IllegalAgeException, IllegalAskingPriceException {
    super(name, age, condition, period, askingPrice);
  }

  /**
   * Calculate the starting bid of an antique clock. The clock will become less valuable if used or
   * damaged before. If so, the clock starting bid will be multiplied by 0.7 from its base value.
   *
   * @return - Double, the starting bid of an antique clock.
   */
  @Override
  protected Double calculateStartingBid() {
    Double startingBid = super.calculateStartingBid();
    if (isUsedOrDamaged()) {
      startingBid *= BROKEN_DECREASE_MULTIPLIER;
    }
    return startingBid;
  }

  /**
   * Helper method to check whether the clock is used or damaged.
   *
   * @return boolean, whether used or damaged.
   */
  protected boolean isUsedOrDamaged() {
    return getCondition().equals(Condition.USED) || getCondition().equals(Condition.DAMAGED);
  }
}
