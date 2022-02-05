package finalExam.p1;

public abstract class Antique {

  protected static final double BASE_MULTIPLIER = 1.02;
  protected static final double MINT_MULTIPLIER = 1.05;
  protected static final double OLDER_MULTIPLIER = 2.25;
  protected static final int AGE_THRESHOLD = 125;
  protected String name;
  protected Integer age;
  protected Condition condition;
  protected Period period;
  protected Double askingPrice;


  public Antique(String name, Integer age, Condition condition, Period period,
      Double askingPrice) throws IllegalAgeException, IllegalAskingPriceException {
    if (age < 0) {
      throw new IllegalAgeException("The age of an antique cannot be less than 0");
    }
    if (askingPrice < 0) {
      throw new IllegalAskingPriceException("The asking price of an antique cannot be less than 0");
    }
    this.name = name;
    this.age = age;
    this.condition = condition;
    this.period = period;
    this.askingPrice = askingPrice;
  }

  protected String getName() {
    return name;
  }

  protected Integer getAge() {
    return age;
  }

  protected Condition getCondition() {
    return condition;
  }

  protected Period getPeriod() {
    return period;
  }

  protected Double getAskingPrice() {
    return askingPrice;
  }

  protected Double calculateStartingBid() {
    Double startingBid = getAskingPrice();
    startingBid *= BASE_MULTIPLIER;
    if (getCondition().equals(Condition.MINT_CONDITION)) {
      startingBid *= MINT_MULTIPLIER;
    }
    if (getAge() > AGE_THRESHOLD) {
      startingBid *= OLDER_MULTIPLIER;
    }
    return startingBid;
  }
}
