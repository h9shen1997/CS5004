import java.util.Objects;

/**
 * Rental class inherited from Contract and has its own term of the contract. The asking price of a
 * rental contract is the monthly price.
 */
public class Rental extends Contract {

  private final Integer term;

  /**
   * Constructor for rental with the specified asking price, whether is negotiable, and the term of
   * the contract.
   *
   * @param askingPrice  - Double, the asking price.
   * @param isNegotiable - Boolean, whether negotiable.
   * @param term         - Integer, the term of the contract in month.
   * @throws NonNegativeException If the term of the contract is less than zero.
   */
  public Rental(Double askingPrice, Boolean isNegotiable, Integer term)
      throws NonNegativeException {
    super(askingPrice, isNegotiable);
    if (term <= 0) {
      throw new NonNegativeException("length of the contract must be larger than 0");
    }
    this.term = term;
  }

  /**
   * Getter for term of contract.
   *
   * @return - Integer, term of contract in months.
   */
  public Integer getTerm() {
    return term;
  }

  /**
   * Get the total value of the contract by multiplying the asking price with the term of contract.
   *
   * @return - Double, the total value of the contract.
   */
  @Override
  public Double getValue() {
    return super.getValue() * term;
  }

  /**
   * Compare whether two objects are rental and have the same content.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(term, rental.term);
  }

  /**
   * Generate hashcode of the rental object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), term);
  }

  /**
   * String expression of the rental object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Rental{" +
        "term=" + term +
        "} " + super.toString();
  }
}
