package finalExam.p1;

public class Earrings extends AntiqueJewelry {

  public Earrings(String name, Integer age, Condition condition, Period period,
      Double askingPrice, Double metricCarats)
      throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice, metricCarats);
  }
}
