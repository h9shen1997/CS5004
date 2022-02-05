package finalExam.p1;

public abstract class AntiqueJewelry extends Antique {

  protected static final double VICTORIAN_MULTIPLIER = 1.25;
  protected static final double ART_DECO_8_CARATS_SURCHARGE = 100000;
  protected static final double CARAT_THRESHOLD = 8.0;
  protected Double metricCarats;

  public AntiqueJewelry(String name, Integer age, Condition condition, Period period,
      Double askingPrice, Double metricCarats)
      throws IllegalAskingPriceException, IllegalAgeException {
    super(name, age, condition, period, askingPrice);
    this.metricCarats = metricCarats;
  }

  protected Double getMetricCarats() {
    return metricCarats;
  }

  @Override
  protected Double calculateStartingBid() {
    Double startingBid = super.calculateStartingBid();
    if (getPeriod().equals(Period.VICTORIAN)) {
      startingBid *= VICTORIAN_MULTIPLIER;
    }
    if (artDecoMoreThan8Carats()) {
      startingBid += ART_DECO_8_CARATS_SURCHARGE;
    }
    return startingBid;
  }

  private boolean artDecoMoreThan8Carats() {
    return getPeriod().equals(Period.ART_DECO) && getMetricCarats() > CARAT_THRESHOLD;
  }
}
