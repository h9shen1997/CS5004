package p1;

import java.util.Objects;

/**
 * Service abstract class that defines the general property of a service, which includes service
 * number, whether the service is monthly, the size of the property, and the address of the home.
 */
public abstract class Service {

  protected static final Integer PAST_SERVICE_THRESHOLD = 9;
  protected static final Integer TENTH_SERVICE = 10;
  private static final Double TENTH_DISCOUNT_MULTIPLIER = -0.5;
  private static final Double MONTHLY_DISCOUNT_MULTIPLIER = -0.1;
  private static final Double NO_DISCOUNT = 0.0;
  protected Integer serviceNum;
  protected boolean monthly;
  protected PropertySize size;
  protected String address;

  /**
   * Constructor that creates a service.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly service.
   * @param size       - PropertySize, the size of property.
   * @param address    - String, home address.
   */
  public Service(Integer serviceNum, boolean monthly, PropertySize size, String address) {
    this.serviceNum = serviceNum;
    this.monthly = monthly;
    this.size = size;
    this.address = address;
  }

  /**
   * Calculate of the price of the service.
   *
   * @return - double, the price of the service.
   */
  protected abstract double calculatePrice();

  /**
   * Calculate discount of the service. 10th service has higher priority than the monthly service.
   *
   * @return - double, the percentage of discount.
   */
  protected double calculateDiscount() {
    if (serviceNum % TENTH_SERVICE == PAST_SERVICE_THRESHOLD) {
      return TENTH_DISCOUNT_MULTIPLIER;
    } else if (monthly) {
      return MONTHLY_DISCOUNT_MULTIPLIER;
    }
    return NO_DISCOUNT;
  }

  /**
   * Getter for service number.
   *
   * @return - Integer, the service number.
   */
  protected Integer getServiceNum() {
    return serviceNum;
  }

  /**
   * Setter for service number.
   *
   * @param serviceNum - Integer, the service number.
   */
  protected void setServiceNum(Integer serviceNum) {
    this.serviceNum = serviceNum;
  }

  /**
   * Getter for whether monthly.
   *
   * @return - boolean, whether monthly service.
   */
  protected boolean isMonthly() {
    return monthly;
  }

  /**
   * Setter for whether monthly.
   *
   * @param monthly - boolean, whether monthly service.
   */
  protected void setMonthly(boolean monthly) {
    this.monthly = monthly;
  }

  /**
   * Getter for property size.
   *
   * @return - PropertySize, the size of property.
   */
  protected PropertySize getSize() {
    return size;
  }

  /**
   * Setter for property size.
   *
   * @param size - PropertySize, the size of property.
   */
  protected void setSize(PropertySize size) {
    this.size = size;
  }

  /**
   * Getter for home address.
   *
   * @return - String, the home address.
   */
  protected String getAddress() {
    return address;
  }

  /**
   * Setter for home address.
   *
   * @param address - String, the home address.
   */
  protected void setAddress(String address) {
    this.address = address;
  }

  /**
   * Compare whether two general Service objects are equal.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Service)) {
      return false;
    }
    Service service = (Service) o;
    return isMonthly() == service.isMonthly() && getServiceNum().equals(service.getServiceNum())
        && getSize() == service.getSize() && getAddress().equals(service.getAddress());
  }

  /**
   * Generate hashcode for Service object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getServiceNum(), isMonthly(), getSize(), getAddress());
  }

  /**
   * Convert the Service object to a String.
   *
   * @return - String, the string representation.
   */
  @Override
  public String toString() {
    return "Service{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }
}
