import java.util.Objects;

/**
 * Residential class inherited from Property and has its own number of bedrooms and number of
 * bathrooms.
 */
public class Residential extends Property {

  private final Integer numOfBedrooms;
  private final Double numOfBathrooms;

  /**
   * Constructor for residential with the specified address, size, number of bathrooms and
   * bedrooms.
   *
   * @param address        - String, residential address.
   * @param size           - Integer, size of the residential.
   * @param numOfBedrooms  - Integer, number of bedRoom.
   * @param numOfBathrooms - Double, number of bathroom.
   * @throws NonNegativeException If either number of bedrooms or number of bathrooms is less than
   *                              zero.
   */
  public Residential(String address, Integer size, Integer numOfBedrooms,
      Double numOfBathrooms) throws NonNegativeException {
    super(address, size);
    if (numOfBedrooms >= 0 && numOfBathrooms >= 0) {
      this.numOfBedrooms = numOfBedrooms;
      this.numOfBathrooms = numOfBathrooms;
    } else {
      throw new NonNegativeException(
          "Number of rooms and number of bathrooms must be larger than 0");
    }
  }

  /**
   * Getter for number of bedrooms.
   *
   * @return - Integer, number of bedrooms.
   */
  public Integer getNumOfBedrooms() {
    return numOfBedrooms;
  }

  /**
   * Getter for number of bathrooms.
   *
   * @return - Double, number of bathrooms.
   */
  public Double getNumOfBathrooms() {
    return numOfBathrooms;
  }

  /**
   * Compare whether two objects are residential and has same contents.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Residential)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Residential that = (Residential) o;
    return Objects.equals(getNumOfBedrooms(), that.getNumOfBedrooms())
        && Objects.equals(getNumOfBathrooms(), that.getNumOfBathrooms());
  }

  /**
   * Generate hashcode for residential object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOfBedrooms(), getNumOfBathrooms());
  }

  /**
   * String expression for residential object.
   *
   * @return - String, string expression.
   */
  @Override
  public String toString() {
    return "Residential{" +
        "address='" + address + '\'' +
        ", size=" + size +
        ", numOfRooms=" + numOfBedrooms +
        ", numOfBathrooms=" + numOfBathrooms +
        '}';
  }
}
