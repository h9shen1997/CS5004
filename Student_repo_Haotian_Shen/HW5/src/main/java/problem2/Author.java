package problem2;

/**
 * Author class inherited from Creator class. It represents a author with name.
 */
public class Author extends Creator {

  /**
   * Constructor for author with the name.
   *
   * @param name - Name, name.
   */
  public Author(Name name) {
    super(name);
  }

  @Override
  protected boolean isAuthor() {
    return true;
  }

  /**
   * Compare whether two Author objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Author)) {
      return false;
    }
    return super.equals(o);
  }

  /**
   * Generate hashcode for the Author object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * String expression for the Author object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Author{} " + super.toString();
  }
}
