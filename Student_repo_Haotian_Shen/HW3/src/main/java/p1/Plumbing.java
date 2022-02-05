package p1;

/**
 * Plumbing service inherited from SpecialistService. It has a permitting fee of 20.
 */
public class Plumbing extends SpecialistService {

  private static final Integer PERMITTING_FEE = 20;

  /**
   * Constructor for Plumbing object.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, home address.
   * @param employee   - Integer, employee number.
   * @param isComplex  - boolean, whether the service is complex.
   */
  public Plumbing(Integer serviceNum, boolean monthly, PropertySize size, String address,
      Integer employee, boolean isComplex) {
    super(serviceNum, monthly, size, address, employee, isComplex);
  }

  /**
   * Calculate final service charge based on discount and permitting fee.
   *
   * @return - double, final service charge.
   */
  @Override
  public double calculatePrice() {
    double rate = super.calculatePrice();
    rate += PERMITTING_FEE;
    return rate;
  }

  /**
   * String representation of Plumbing object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "Plumbing{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        ", employee=" + employee +
        ", isComplex=" + isComplex +
        '}';
  }

  /**
   * Compare two Plumbing objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Plumbing)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode of Plumbing object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
