package finalExam.p1;

public abstract class AntiqueFurnitureDecreaseWithListingDays extends AntiqueFurniture {

  protected static final int SIX_MONTH_THRESHOLD = 180;
  protected static final double DECREASE_FACTOR = 1.15;

  public AntiqueFurnitureDecreaseWithListingDays(String name, Integer age, Condition condition,
      Period period,
      Double askingPrice) throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice);
  }

  @Override
  protected Double calculateStartingBid() {
    Double startingBid = super.calculateStartingBid();
    if (getNumOfDayForAuction() > SIX_MONTH_THRESHOLD) {
      startingBid /= DECREASE_FACTOR;
    }
    return startingBid;
  }
}
