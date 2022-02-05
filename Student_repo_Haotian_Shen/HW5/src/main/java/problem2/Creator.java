package problem2;

import java.util.Objects;

/**
 * Creator represents an individual creator.
 */
public abstract class Creator {

  protected final Name name;

  /**
   * Constructor that creates a Creator object with the given name.
   *
   * @param name
   */
  public Creator(Name name) {
    this.name = name;
  }

  /**
   * Getter for name.
   *
   * @return - Name, name.
   */
  protected Name getName() {
    return name;
  }

  /**
   * Check whether the creator is an author.
   *
   * @return - boolean, whether is an author.
   */
  protected abstract boolean isAuthor();

  /**
   * Compare whether two Creator objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Creator)) {
      return false;
    }
    Creator creator = (Creator) o;
    return getName().equals(creator.getName());
  }

  /**
   * Generate hashcode for Creator object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  /**
   * String expression for Creator object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Creator{" +
        "name=" + name +
        '}';
  }
}
