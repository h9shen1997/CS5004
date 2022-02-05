package problem2;

import java.util.Objects;

/**
 * Name class with a first name and a last name.
 */
public class Name {

  private final String firstName;
  private final String lastName;

  /**
   * Constructor for name.
   *
   * @param firstName - String, first name.
   * @param lastName  - String, last name.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Getter for first name.
   *
   * @return - String, first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for last name.
   *
   * @return - String, last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Compare whether two Name are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Name)) {
      return false;
    }
    Name name = (Name) o;
    return getFirstName().equals(name.getFirstName()) && getLastName().equals(name.getLastName());
  }

  /**
   * Generate hashcode for the name.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }

  /**
   * String expression for the name.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
