package p1;

/**
 * NonspecialistService is a parent class for exterior and interior service to calculate base rate
 * easily.
 */
public abstract class NonSpecialistService extends Service implements ServiceHour {

  protected static final Integer BASE_RATE = 80;

  /**
   * Constructor for NonSpecialistService.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether the service is monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, the home address.
   */
  public NonSpecialistService(Integer serviceNum, boolean monthly, PropertySize size,
      String address) {
    super(serviceNum, monthly, size, address);
  }

  /**
   * Calculate service charge based on size of the property and the base rate.
   *
   * @return - double, the service charge.
   */
  protected double calculatePrice() {
    double rate = 0.0;
    switch (getSize()) {
      case SMALL:
        rate += hourSmall * BASE_RATE;
        break;
      case MEDIUM:
        rate += hourMedium * BASE_RATE;
        break;
      case LARGE:
        rate += hourLarge * BASE_RATE;
    }
    return rate;
  }

  /**
   * Compare two NonSpecialistService objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Generate hashcode for NonSpecialistService object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String representation of NonSpecialistService.
   *
   * @return - String, the string representation.
   */
  @Override
  public String toString() {
    return "NonSpecialistService{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }
}
