import java.util.Objects;

/**
 * Commercial class inherited from Property and has its own number of offices and whether it is
 * suitable for retail.
 */
public class Commercial extends Property {

  private final Integer numOfOffices;
  private final Boolean suitableForRetail;

  /**
   * Constructor for commercial with the specified address, size, number of offices, and whether
   * suitable for retail.
   *
   * @param address      - String, property address.
   * @param size         - Integer, size of the commercial property.
   * @param numOfOffices - Integer, number of offices.
   * @param forRetail    - Boolean, suitable for retail.
   * @throws NonNegativeException If number of offices is less than zero.
   */
  public Commercial(String address, Integer size, Integer numOfOffices, Boolean forRetail)
      throws NonNegativeException {
    super(address, size);
    if (numOfOffices < 0) {
      throw new NonNegativeException("number of the offices must be non-negative integer");
    }
    this.numOfOffices = numOfOffices;
    this.suitableForRetail = forRetail;
  }

  /**
   * Getter for the number of offices.
   *
   * @return - Integer, number of offices.
   */
  public Integer getNumOfOffices() {
    return numOfOffices;
  }

  /**
   * Getter for whether the commercial property is suitable for retail.
   *
   * @return - Boolean, whether suitable for retail.
   */
  public Boolean getSuitableForRetail() {
    return suitableForRetail;
  }

  /**
   * Compare whether two objects are commercial and have the same contents.
   *
   * @param o - Object, the other object.
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Commercial)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Commercial that = (Commercial) o;
    return Objects.equals(getNumOfOffices(), that.getNumOfOffices())
        && Objects.equals(getSuitableForRetail(), that.getSuitableForRetail());
  }

  /**
   * Generate hashcode of the commercial object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOfOffices(), getSuitableForRetail());
  }

  /**
   * String expression for the commercial object.
   *
   * @return - String, string expression.
   */
  @Override
  public String toString() {
    return "Commercial{" +
        "numOfOffices=" + numOfOffices +
        ", ForRetail=" + suitableForRetail +
        ", address='" + address + '\'' +
        ", size=" + size +
        '}';
  }
}
