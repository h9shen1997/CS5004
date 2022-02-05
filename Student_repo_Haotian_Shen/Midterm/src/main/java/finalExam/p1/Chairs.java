package finalExam.p1;

public class Chairs extends AntiqueFurnitureDecreaseWithListingDays {

  public Chairs(String name, Integer age, Condition condition, Period period,
      Double askingPrice) throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice);
  }
}
