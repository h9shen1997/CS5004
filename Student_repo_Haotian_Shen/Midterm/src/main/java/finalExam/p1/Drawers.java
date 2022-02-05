package finalExam.p1;

public class Drawers extends AntiqueFurniture {

  public Drawers(String name, Integer age, Condition condition, Period period,
      Double askingPrice) throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice);
  }
}
