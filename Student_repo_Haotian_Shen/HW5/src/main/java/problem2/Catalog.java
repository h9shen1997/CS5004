package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Catalog class is a collection of item in the library.
 */
public class Catalog {

  List<Item> collection;

  /**
   * Constructor for catalog that does not have item.
   */
  public Catalog() {
    this.collection = new ArrayList<>();
  }

  /**
   * Constructor for catalog that have a list of items.
   *
   * @param collection
   */
  public Catalog(List<Item> collection) {
    this.collection = collection;
  }

  /**
   * Add the item to the catalog.
   *
   * @param item - Item, the item.
   */
  public void addItem(Item item) {
    this.collection.add(item);
  }

  /**
   * Remove the item from the catalog.
   *
   * @param item - Item, item.
   */
  public void removeItem(Item item) {
    for (int i = 0; i < this.collection.size(); i++) {
      if (item.equals(this.collection.get(i))) {
        this.collection.remove(i);
        return;
      }
    }
  }

  /**
   * Getter for the collection.
   *
   * @return - List<Item>, a list of items.
   */
  public List<Item> getCollection() {
    return collection;
  }

  /**
   * Search the collection based on keyword match for the title of the item using KMP matching
   * algorithm to achieve O(n) time complexity for each search. The matching is case-insensitive.
   *
   * @param keyword - String, the keyword pattern.
   * @return - List<Item>, list of item that has a match in their title.
   */
  public List<Item> search(String keyword) {
    List<Item> filteredResult = new ArrayList<>();
    for (int i = 0; i < this.collection.size(); i++) {
      Item item = this.collection.get(i);
      if ((KMPMatch(keyword.toLowerCase(), item.getTitle().toLowerCase()))) {
        filteredResult.add(item);
      }
    }
    return filteredResult;
  }

  /**
   * KMP matching algorithm to search for a pattern in the item title. The time complexity of this
   * algorithm is O(n) compared to naive matching algorithm.
   *
   * @param pattern - String, the pattern to find.
   * @param title   - String, the item title.
   * @return - boolean, whether the pattern is found in the title.
   */
  private boolean KMPMatch(String pattern, String title) {
    int patternLen = pattern.length();
    int titleLen = title.length();
    int[] lps = new int[patternLen];
    int j = 0;
    computeLPSArray(pattern, patternLen, lps);
    int i = 0;
    boolean found = false;
    while (i < titleLen) {
      if (pattern.charAt(j) == title.charAt(i)) {
        i++;
        j++;
      }
      if (j == patternLen) {
        return true;
      } else if (i < titleLen && pattern.charAt(j) != title.charAt(i)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return false;
  }

  /**
   * Helper function for KMP matching algorithm to compute the longest prefix that is also a suffix
   * of the pattern string.
   *
   * @param pattern    - String, the pattern.
   * @param patternLen - int, the pattern string's length.
   * @param lps        - int[], the length of the longest suffix that is also a suffix for at each
   *                   index.
   */
  private void computeLPSArray(String pattern, int patternLen, int[] lps) {
    int len = 0;
    int i = 1;
    lps[0] = 0;
    while (i < patternLen) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = len;
          i++;
        }
      }
    }
  }

  /**
   * Search the collection based on the author of the item. Since only the book can have a title,
   * the returned list will only contain book item.
   *
   * @param author - Author, the author.
   * @return - List<Item>, list of item that has the same author as the creator.
   */
  public List<Item> search(Author author) {
    List<Item> filteredResult = new ArrayList<>();
    for (int i = 0; i < this.collection.size(); i++) {
      Item item = this.collection.get(i);
      if (!item.isMusic() && ((Book) item).getAuthor().equals(author)) {
        filteredResult.add(item);
      }
    }
    return filteredResult;
  }

  /**
   * Search the collection based on the artist of the item. Since only music can have recording
   * artist, all the item in the returned result will be music item only. If the passed in recording
   * artist is the single artist or a member of the band, add the item to the returned list.
   *
   * @param artist - RecordingArtist, the artist.
   * @return - List<Item>, list of item that has the recording artist as the creator.
   */
  public List<Item> search(RecordingArtist artist) {
    List<Item> filteredResult = new ArrayList<>();
    for (int i = 0; i < this.collection.size(); i++) {
      Item item = this.collection.get(i);
      if (item.isMusic()) {
        if (((Music) item).isBand() && ((Music) item).getBand().getMembers().contains(artist)) {
          filteredResult.add(item);
        } else if (!((Music) item).isBand() && ((Music) item).getRecordingArtist().equals(artist)) {
          filteredResult.add(item);
        }
      }
    }
    return filteredResult;
  }

  /**
   * Compare whether two Catalog objects are equal.
   *
   * @param o - Object, the other object.
   * @return - boolean, whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Catalog)) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return getCollection().equals(catalog.getCollection());
  }

  /**
   * Generate hashcode for the Catalog object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCollection());
  }

  /**
   * String expression for the Catalog object.
   *
   * @return - String, the string expression.
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "collection=" + collection +
        '}';
  }
}
