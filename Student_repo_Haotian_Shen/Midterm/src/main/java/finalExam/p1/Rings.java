package finalExam.p1;

public class Rings extends AntiqueJewelry {

  public Rings(String name, Integer age, Condition condition, Period period,
      Double askingPrice, Double metricCarats)
      throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice, metricCarats);
  }
}
