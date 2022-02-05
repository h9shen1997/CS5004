/**
 * Sale class inherited from Contract.
 */
public class Sale extends Contract {

  /**
   * Constructor for Sale with the specified asking price and whether it is negotiable.
   *
   * @param askingPrice  - Double, the asking price.
   * @param isNegotiable - Boolean, whether it is negotiable.
   * @throws NonNegativeException If the asking price is less than zero.
   */
  public Sale(Double askingPrice, Boolean isNegotiable) throws NonNegativeException {
    super(askingPrice, isNegotiable);
  }

  /**
   * Compare whether two objects are sale and have the same contents.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o) && o instanceof Sale;
  }

  /**
   * Generate the hashcode of the sale object.
   *
   * @return int, the hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String expression of the sale object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Sale{} " + super.toString();
  }
}
