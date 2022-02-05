import java.util.Objects;

/**
 * Listing is a generic class that has a generic property and a generic contract, so it can express
 * any type of listing.
 *
 * @param <T1> a generic property.
 * @param <T2> a generic contract.
 */
public class Listing<T1 extends Property, T2 extends Contract> {

  private final T1 property;
  private final T2 contract;

  /**
   * Constructor for listing with a generic property and a generic contract.
   *
   * @param property - a generic property.
   * @param contract - a generic contract.
   */
  public Listing(T1 property, T2 contract) {
    this.property = property;
    this.contract = contract;
  }

  /**
   * Get the listing's property.
   *
   * @return property as T1.
   */
  public T1 getProperty() {
    return property;
  }

  /**
   * Get the listing's contract.
   *
   * @return contract as T2.
   */
  public T2 getContract() {
    return contract;
  }


  /**
   * Compare two objects whether they are the same.
   *
   * @param o the object to be compared with.
   * @return true if two object is the same else return false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Listing)) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(getProperty(), listing.getProperty()) && Objects.equals(
        getContract(), listing.getContract());
  }

  /**
   * Representation of the object based on the object current state.
   *
   * @return hashcode as integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(getProperty(), getContract());
  }

  /**
   * String expression of listing information.
   *
   * @return listing's information as string
   */
  @Override
  public String toString() {
    return "Listing{" +
        "property=" + property +
        ", contract=" + contract +
        '}';
  }
}
