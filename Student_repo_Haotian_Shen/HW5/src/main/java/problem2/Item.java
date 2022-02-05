package problem2;

import java.util.Objects;

/**
 * Item class represents either a book or a music with its title and the year of release.
 */
public abstract class Item {

  protected String title;
  protected Integer yearReleased;

  /**
   * Constructor that creates an Item object with the given title and year of release.
   *
   * @param title        - String, title of the item.
   * @param yearReleased - Integer, year of release.
   */
  public Item(String title, Integer yearReleased) {
    this.title = title;
    this.yearReleased = yearReleased;
  }

  /**
   * Getter for the title.
   *
   * @return - String, the title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Getter for the year of release.
   *
   * @return - Integer, the year of release.
   */
  public Integer getYearReleased() {
    return yearReleased;
  }

  /**
   * Compare whether two Item objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    Item item = (Item) o;
    return getTitle().equals(item.getTitle()) && getYearReleased().equals(item.getYearReleased());
  }

  protected abstract boolean isMusic();

  /**
   * Generate hashcodd for Item object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getTitle(), getYearReleased());
  }

  /**
   * String expression for the Item object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Item{" +
        "title='" + title + '\'' +
        ", yearReleased=" + yearReleased +
        '}';
  }
}
