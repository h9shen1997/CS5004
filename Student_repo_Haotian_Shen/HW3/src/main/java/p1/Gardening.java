package p1;

/**
 * Gardening inherited from exterior service and has a waste removal fee of 20.
 */
public class Gardening extends ExteriorService {

  private static final Integer WASTE_REMOVAL_FEE = 20;

  /**
   * Constructor for Gardening object.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, the home address.
   */
  public Gardening(Integer serviceNum, boolean monthly, PropertySize size,
      String address) {
    super(serviceNum, monthly, size, address);
  }

  /**
   * Calculate final service charge based on the waste removal fee and discount percent.
   *
   * @return - double, the final service charge.
   */
  @Override
  public double calculatePrice() {
    double rate = super.calculatePrice();
    rate += WASTE_REMOVAL_FEE;
    double discountPercent = calculateDiscount();
    rate *= (1 + discountPercent);
    return rate;
  }

  /**
   * Compare two Gardening objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Gardening)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode for Gardening.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String representation for Gardening object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "Gardening{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }
}
