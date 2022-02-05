package p2;

public class Civilian extends Pieces {

  private static final Double MAXIMUM_WEALTH = 128.0;
  protected Double wealth;

  public Civilian(Name name, Integer age, Double wealth) throws InvalidAgeException {
    super(name, age);
    this.wealth = wealth;
  }

  private Boolean validateWealth(Double wealth) throws InvalidWealthException {
    if (wealth >= 0 && wealth <= MAXIMUM_WEALTH) {
      return true;
    } else {
      throw new InvalidWealthException("The wealth is invalid");
    }
  }

  public Double increaseWealth(Double wealthToBeAdded) throws InvalidWealthException {
    if (validateWealth(wealthToBeAdded)) {
      this.wealth += wealthToBeAdded;
    } else {
      throw new InvalidWealthException("The wealth is invalid");
    }
    return this.wealth;
  }
}