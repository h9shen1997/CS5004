package p1;

import java.util.Objects;

/**
 * SpecialistService has a base rate of 200 and requirements for minimum employee to perform the
 * service. It also indicates whether the service is complex.
 */
public abstract class SpecialistService extends Service {

  protected static final Integer BASE_RATE = 200;
  protected static final Integer GENERAL_MIN_EMPLOYEE = 1;
  protected static final Integer COMPLEX_MIN_EMPLOYEE_SMALL_MEDIUM = 2;
  protected static final Integer COMPLEX_MIN_EMPLOYEE_LARGE = 3;
  protected Integer employee;
  protected boolean isComplex;

  /**
   * Constructor for SpecialistService.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly service.
   * @param size       - PropertySize, property size.
   * @param address    = String, home address.
   * @param employee   - Integer, employee number.
   * @param isComplex  - boolean, whether the service is complex.
   */
  public SpecialistService(Integer serviceNum, boolean monthly, PropertySize size,
      String address, Integer employee, boolean isComplex) {
    super(serviceNum, monthly, size, address);
    this.isComplex = isComplex;
    if (!isComplex()) {
      setEmployee(employee >= GENERAL_MIN_EMPLOYEE ? employee : GENERAL_MIN_EMPLOYEE);
    } else {
      if (isSmallOrMedium()) {
        setEmployee(employee >= COMPLEX_MIN_EMPLOYEE_SMALL_MEDIUM ? employee
            : COMPLEX_MIN_EMPLOYEE_SMALL_MEDIUM);
      } else {
        setEmployee(employee >= COMPLEX_MIN_EMPLOYEE_LARGE ? employee : COMPLEX_MIN_EMPLOYEE_LARGE);
      }
    }
  }

  /**
   * Helper method to determine whether the property is small or medium.
   *
   * @return - boolean, whether the property size is small or medium.
   */
  private boolean isSmallOrMedium() {
    return getSize() == PropertySize.SMALL || getSize() == PropertySize.MEDIUM;
  }

  /**
   * Calculate price based on employee number and base rate per person.
   *
   * @return - double, the service charge.
   */
  protected double calculatePrice() {
    return getEmployee() * BASE_RATE;
  }

  /**
   * Getter for employee number.
   *
   * @return - Integer, employee number.
   */
  protected Integer getEmployee() {
    return employee;
  }

  /**
   * Setter for employee number.
   *
   * @param employee - Integer, employee number.
   */
  protected void setEmployee(Integer employee) {
    this.employee = employee;
  }

  /**
   * Getter for whether the service is complex.
   *
   * @return - boolean, whether the service is complex.
   */
  protected boolean isComplex() {
    return isComplex;
  }

  /**
   * Setter for whether the service is complex.
   *
   * @param complex - boolean, whether the service is complex.
   */
  protected void setComplex(boolean complex) {
    isComplex = complex;
  }

  /**
   * Compare whether the two SpecialistService objects are equal.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether the SpecialistService are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SpecialistService)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SpecialistService that = (SpecialistService) o;
    return isComplex() == that.isComplex() && getEmployee().equals(that.getEmployee());
  }

  /**
   * Generate hashcode of the object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getEmployee(), isComplex());
  }

  /**
   * Generate string representation of the object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "SpecialistService{" +
        "serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        ", employee=" + employee +
        ", isComplex=" + isComplex +
        '}';
  }
}
