package problem2;

import java.util.Objects;

/**
 * Book class inherited from Item class. It represents a book with an author.
 */
public class Book extends Item {

  private final Author author;

  /**
   * Constructor that creates a Book object with the given author, title, and year of release.
   *
   * @param author       - Author, author
   * @param title        - String, title.
   * @param yearReleased - Integer, year of release.
   */
  public Book(Author author, String title, Integer yearReleased) {
    super(title, yearReleased);
    this.author = author;
  }

  /**
   * Getter for author.
   *
   * @return - Author, the author.
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * Compare whether two Book objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Book book = (Book) o;
    return getAuthor().equals(book.getAuthor());
  }

  @Override
  protected boolean isMusic() {
    return false;
  }

  /**
   * Generate hashcode for the Book object.
   *
   * @return = int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getAuthor());
  }

  /**
   * String expression for the Book object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Book{" +
        "author=" + author +
        "} " + super.toString();
  }
}
