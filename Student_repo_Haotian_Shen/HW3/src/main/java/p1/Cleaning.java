package p1;

/**
 * Cleaning service inherited from interior serviec and calculate the service charge.
 */
public class Cleaning extends InteriorService {

  /**
   * Constructor for Cleaning object.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, the home address.
   * @param petsNum    - Integer, pets number.
   */
  public Cleaning(Integer serviceNum, boolean monthly, PropertySize size, String address,
      Integer petsNum) {
    super(serviceNum, monthly, size, address, petsNum);
  }

  /**
   * Calculate the service charge after 10th discount or monthly discount.
   *
   * @return - double, final service charge.
   */
  @Override
  public double calculatePrice() {
    double rate = super.calculatePrice();
    double discountPercent = calculateDiscount();
    rate *= (1 + discountPercent);
    return rate;
  }

  /**
   * Compare two Cleaning objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cleaning)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode for Cleaning object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String representation of Cleaning object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "Cleaning{" +
        "petsNum=" + petsNum +
        ", serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }
}
