package p1;

import java.util.Objects;

/**
 * WindowCleaning stores the max floor and the current floor information and the service fee
 * multiplier.
 */
public class WindowCleaning extends ExteriorService {

  private static final Integer MAX_FLOOR = 3;
  private static final Double SERVICE_MULTIPLIER = 0.05;
  private final Integer floor;

  /**
   * Constructor for WindowCleaning object. It will throw an exception if the window floor is
   * greater than 3, because the service cannot be done.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, property size.
   * @param address    - String, home address.
   * @param floor      - Integer, window floor.
   * @throws WindowFloorExceedingMaxException if the window floor is greater than 3.
   */
  public WindowCleaning(Integer serviceNum, boolean monthly, PropertySize size,
      String address, Integer floor) throws WindowFloorExceedingMaxException {
    super(serviceNum, monthly, size, address);
    if (floor > MAX_FLOOR) {
      throw new WindowFloorExceedingMaxException(
          "The window floor is greater than 3, so this service cannot be done");
    } else {
      this.floor = floor;
    }
  }

  /**
   * Getter for floor. The floor will not change once initialized within the window cleaning
   * service.
   *
   * @return - Integer, the floor of this service.
   */
  public Integer getFloor() {
    return floor;
  }

  /**
   * Calculate final service charge based on the window service multiplier and discount.
   *
   * @return - double, final service charge.
   */
  @Override
  public double calculatePrice() {
    double rate = super.calculatePrice();
    if (floor > 1) {
      rate *= (1 + SERVICE_MULTIPLIER);
    }
    double discountPercent = calculateDiscount();
    rate *= (1 + discountPercent);
    return rate;
  }

  /**
   * Compare two window cleaning objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WindowCleaning)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return floor.equals(that.floor);
  }

  /**
   * Generate hashcode for WindowCleaning object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), floor);
  }

  /**
   * String representation of WindowCleaning object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "WindowCleaning{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        ", floor=" + floor +
        '}';
  }
}
