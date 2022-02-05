package p1;

import java.util.Objects;

/**
 * InteriorService stores information pets number and has implemented pets service fee
 * functionality.
 */
public abstract class InteriorService extends NonSpecialistService implements PetServiceFee {

  protected Integer petsNum;

  /**
   * Constructor for InteriorService.
   *
   * @param serviceNum - Integer, service number.
   * @param monthly    - boolean, whether monthly.
   * @param size       - PropertySize, the property size.
   * @param address    - String, the home address.
   * @param petsNum    - Integer, pets number.
   */
  public InteriorService(Integer serviceNum, boolean monthly, PropertySize size,
      String address, Integer petsNum) {
    super(serviceNum, monthly, size, address);
    this.petsNum = petsNum;
  }

  /**
   * Getter for pets number.
   *
   * @return - Integer, pets number.
   */
  protected Integer getPetsNum() {
    return petsNum;
  }

  /**
   * Setter for pets number.
   *
   * @param petsNum - Integer, pets number.
   */
  protected void setPetsNum(Integer petsNum) {
    this.petsNum = petsNum;
  }

  /**
   * Calculate pets fee percentage surcharge.
   *
   * @return - Double, the pets fee surcharge.
   */
  public Double calculatePetFee() {
    if (getPetsNum() == ONE_PET || getPetsNum() == TWO_PET) {
      return LESS_THAN_THREE_FEE;
    } else if (getPetsNum() >= THREE_PET) {
      return GREATER_THAN_TWO_FEE;
    }
    return 0.0;
  }

  /**
   * Calculate the service charge after pets fee surcharge.
   *
   * @return - double, the service charge.
   */
  @Override
  protected double calculatePrice() {
    double rate = super.calculatePrice();
    double petFeePercent = calculatePetFee();
    rate *= (1 + petFeePercent);
    return rate;
  }

  /**
   * Compare two InteriorService objects.
   *
   * @param o = Object, the other Service object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InteriorService)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    InteriorService that = (InteriorService) o;
    return getPetsNum().equals(that.getPetsNum());
  }

  /**
   * Generate hashcode for the object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPetsNum());
  }

  /**
   * String representation of the object.
   *
   * @return - String, string representation.
   */
  @Override
  public String toString() {
    return "InteriorService{" +
        "petsNum=" + petsNum +
        ", serviceNum=" + serviceNum +
        ", monthly=" + monthly +
        ", size=" + size +
        ", address='" + address + '\'' +
        '}';
  }
}
