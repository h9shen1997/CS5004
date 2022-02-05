package problem2;

import java.util.Objects;

/**
 * EmptyBagOfWords represents a empty bag of word that does not contain anything.
 */
public class EmptyBagOfWords implements BagOfWords {

  /**
   * Constructor for EmptyBagOfWords.
   */
  public EmptyBagOfWords() {
  }

  /**
   * Creates an empty bag of words.
   *
   * @return - BagOfWords, a new empty bag of words.
   */
  @Override
  public BagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * Determine whether the bag of word is empty.
   *
   * @return - always true because this is an empty bag of word.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Determine the size of the bag of word.
   *
   * @return - always 0 because there is no word in the bag.
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Add the specified word into the bag and return a non-empty bag of words.
   *
   * @param s - String, specified new word.
   * @return - a non-empty bag of words with the word added.
   */
  @Override
  public BagOfWords add(String s) {
    return new NonEmptyBagOfWords(s);
  }

  /**
   * Determine if the bag contains the specified word.
   *
   * @param s - String, the specified word.
   * @return - always false because the bag is empty.
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  /**
   * Get the current word.
   *
   * @return - always null.
   */
  @Override
  public String getWords() {
    return null;
  }

  /**
   * Get the rest of the word in the bag.
   *
   * @return - always null.
   */
  @Override
  public BagOfWords getRest() {
    return null;
  }

  /**
   * Increase the count of current word by one. This does not do anything here because the bag is
   * empty, so it simply satisfies the requirement of the interface.
   */
  @Override
  public void increaseCountByOne() {
  }

  /**
   * Get the count of the current word.
   *
   * @param s - String, the specified word.
   * @return - always 0 because the bag is empty.
   */
  @Override
  public Integer getCount(String s) {
    return 0;
  }

  /**
   * Generate the hashcode of an empty bag of word.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(size(), getWords(), getRest());
  }

  /**
   * Compare whether two empty bags of words are equal.
   *
   * @param o - the other bag of words.
   * @return - whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof EmptyBagOfWords)) {
      return false;
    }
    BagOfWords that = (BagOfWords) o;
    return Objects.equals(getWords(), that.getWords()) && Objects.equals(getRest(), that.getRest());
  }

  /**
   * String expression of an empty bag of words.
   *
   * @return - string expression.
   */
  @Override
  public String toString() {
    return "EmptyBagOfWords{}";
  }
}
