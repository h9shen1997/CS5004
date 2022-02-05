package finalExam.p1;

public class Desks extends AntiqueFurnitureDecreaseWithListingDays {

  private static final int SIX_MONTH_THRESHOLD = 180;
  private static final double DECREASE_FACTOR = 1.15;

  public Desks(String name, Integer age, Condition condition, Period period,
      Double askingPrice) throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice);
  }
}
