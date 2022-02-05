import java.util.Objects;

/**
 * Contract is an abstract class with an asking price and whether the price is negotiable.
 */
public abstract class Contract {

  protected final Double askingPrice;
  protected final Boolean isNegotiable;

  /**
   * Constructor for contract with the specified asking price and negotiable.
   *
   * @param askingPrice  - Double, asking price.
   * @param isNegotiable - Boolean, whether is negotiable.
   * @throws NonNegativeException If the asking price is less than zero.
   */
  public Contract(Double askingPrice, Boolean isNegotiable) throws NonNegativeException {
    if (askingPrice < 0) {
      throw new NonNegativeException("price of the contract must be larger than 0");
    }
    this.askingPrice = askingPrice;
    this.isNegotiable = isNegotiable;
  }

  /**
   * Getter for asking price of the contract.
   *
   * @return - Double, asking price of the contract.
   */
  public Double getAskingPrice() {
    return askingPrice;
  }

  /**
   * Getter for whether the asking price is negotiable.
   *
   * @return - Boolean, whether negotiable.
   */
  public Boolean getIsNegotiable() {
    return isNegotiable;
  }

  /**
   * Get the total value of the contract based on the asking price of the contract.
   *
   * @return - Double, the total value of the contract.
   */
  protected Double getValue() {
    return this.askingPrice;
  }

  /**
   * Compare whether two objects are contract and have the same content.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Contract)) {
      return false;
    }
    Contract contract = (Contract) o;
    return Objects.equals(getAskingPrice(), contract.getAskingPrice())
        && Objects.equals(isNegotiable, contract.isNegotiable);
  }

  /**
   * Generate the hashcode of the contract object.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAskingPrice(), isNegotiable);
  }

  /**
   * String expression of the contract object.
   *
   * @return - String, string expression.
   */
  @Override
  public String toString() {
    return "Contract{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }
}
