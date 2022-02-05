package finalExam.p1;

public abstract class AntiqueFurniture extends Antique {

  protected Integer numOfDayForAuction;

  public AntiqueFurniture(String name, Integer age, Condition condition, Period period,
      Double askingPrice) throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice);
    this.numOfDayForAuction = 0;
  }

  protected Integer getNumOfDayForAuction() {
    return numOfDayForAuction;
  }
}
