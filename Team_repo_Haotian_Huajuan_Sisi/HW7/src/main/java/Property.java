import java.util.Objects;

/**
 * Property class represent a property with an address and the size of the property.
 */
public abstract class Property {

  protected final String address;
  protected final Integer size;

  /**
   * Constructor for property with the specified address and size.
   *
   * @param address - String, property address.
   * @param size    - Integer, size of the property.
   * @throws NonNegativeException If the property size is less than zero.
   */
  public Property(String address, Integer size) throws NonNegativeException {
    if (size < 0) {
      throw new NonNegativeException("size of the property must be non-negative integer");
    }
    this.address = address;
    this.size = size;
  }

  /**
   * Getter for address.
   *
   * @return - String, property address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Getter for size of the property.
   *
   * @return - Integer, size of the property.
   */
  public Integer getSize() {
    return size;
  }

  /**
   * Compare whether two objects are both property and equal in contents.
   *
   * @param o - Object, the other object.
   * @return boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Property property = (Property) o;
    return Objects.equals(address, property.address) && Objects.equals(size,
        property.size);
  }

  /**
   * Generate the hashcode of the property object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(address, size);
  }

  /**
   * String expression for the property class.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Property{" +
        "address='" + address + '\'' +
        ", size=" + size +
        '}';
  }
}
