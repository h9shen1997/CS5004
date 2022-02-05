package p1;

/**
 * Electrical service inherited from SpecialistService. The max employee is 4 and the permitting fee
 * is 50.
 */
public class Electrical extends SpecialistService {

  private static final Integer MAX_EMPLOYEE = 4;
  private static final Integer PERMITTING_FEE = 50;

  /**
   * Constructor for Electrical service. If the employee is more than 4, the service cannot be
   * done.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, home address.
   * @param employee   - Integer, employee number.
   * @param isComplex  - boolean, whether the service is complex.
   * @throws ElectricalServiceIllegalException if the employee is more than 4.
   */
  public Electrical(Integer serviceNum, boolean monthly, PropertySize size,
      String address, Integer employee, boolean isComplex)
      throws ElectricalServiceIllegalException {
    super(serviceNum, monthly, size, address, employee, isComplex);
    if (employee > MAX_EMPLOYEE) {
      throw new ElectricalServiceIllegalException(
          "The maximum employee required for electrical service is 4");
    }
  }

  /**
   * Calculate the final service charge based on discount and permitting fee.
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
   * Compare two Electrical objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Electrical)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode of the Electrical object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String representation of the Electrical object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "Electrical{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        ", employee=" + employee +
        ", isComplex=" + isComplex +
        '}';
  }
}
