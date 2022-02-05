package p1;

/**
 * Painting inherited from interior service, but it also has different hour of completion.
 */
public class Painting extends InteriorService {

  private static final Integer HOUR_SMALL = 16;
  private static final Integer HOUR_MEDIUM = 16;
  private static final Integer HOUR_LARGE = 24;

  /**
   * Constructor for Painting object.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, home address.
   * @param petsNum    - Integer, pets number.
   */
  public Painting(Integer serviceNum, boolean monthly, PropertySize size, String address,
      Integer petsNum) {
    super(serviceNum, monthly, size, address, petsNum);
  }

  /**
   * Calculate final service charge based on painting operation hour and pets number and discount
   * price.
   *
   * @return - double, final service charge.
   */
  @Override
  public double calculatePrice() {
    double rate = 0.0;
    switch (getSize()) {
      case SMALL:
        rate += HOUR_SMALL * BASE_RATE;
        break;
      case MEDIUM:
        rate += HOUR_MEDIUM * BASE_RATE;
        break;
      case LARGE:
        rate += HOUR_LARGE * BASE_RATE;
        break;
    }
    double petFeePercent = calculatePetFee();
    double discountPercent = calculateDiscount();
    rate *= (1 + petFeePercent);
    rate *= (1 + discountPercent);
    return rate;
  }

  /**
   * Compare two Painting objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Painting)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode for Painting object.
   *
   * @return = int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String representation for Painting object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "Painting{" +
        "petsNum=" + petsNum +
        ", serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }
}
