package p1;

/**
 * ExteriorService inherited from NonSpecialistService.
 */
public abstract class ExteriorService extends NonSpecialistService {

  /**
   * Constructor for ExteriorService.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly service.
   * @param size       - PropertySize, property size.
   * @param address    - String, the home address.
   */
  public ExteriorService(Integer serviceNum, boolean monthly, PropertySize size,
      String address) {
    super(serviceNum, monthly, size, address);
  }

  /**
   * Compare two ExteriorService ojects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Generate hashcode for object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String representation of object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "ExteriorService{" +
        "hourSmall=" + hourSmall +
        ", hourMedium=" + hourMedium +
        ", hourLarge=" + hourLarge +
        ", baseRate=" + BASE_RATE +
        ", serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }


}
