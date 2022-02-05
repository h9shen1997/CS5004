package problem2;

import java.util.Objects;

/**
 * NonEmptyBagOfWords represents a linkedlist-like structure that is recursive. Each element is a
 * string of word and contains a reference to the rest of the element in the bag. It also stores a
 * variable to indicate the number of current word in the bag.
 */
public class NonEmptyBagOfWords implements BagOfWords {

  private final String words;
  private final BagOfWords rest;
  private Integer wordsCount;

  /**
   * Constructor to create a non-empty bag of words with the specified word. The word count for this
   * word will be 1 and the rest of the element is an empty bag of words.
   *
   * @param words - the specified word.
   */
  public NonEmptyBagOfWords(String words) {
    this.words = words;
    this.wordsCount = 1;
    this.rest = new EmptyBagOfWords();
  }

  /**
   * Helper constructor that creates a non-empty bag of words with the specified word and a
   * reference to the rest of the element. If the rest of the element already contains word, then we
   * need to increment the count of this specified in the rest of the element by one for each
   * occurrence. Then, we get the updated count of this word from the rest of the element and set
   * the word count to this element.
   *
   * @param words - String, specified word.
   * @param rest  - BagOfWords, the rest of the element.
   */
  private NonEmptyBagOfWords(String words, BagOfWords rest) {
    this.words = words;
    this.rest = rest;
    if (rest.contains(words)) {
      increaseCountForWords(words, rest);
      this.wordsCount = rest.getCount(words);
    } else {
      this.wordsCount = 1;
    }
  }

  /**
   * Get the current word.
   *
   * @return - String, the current word.
   */
  @Override
  public String getWords() {
    return words;
  }

  /**
   * Get the rest of the element in the bag.
   *
   * @return - BagOfWords, the rest of the element.
   */
  @Override
  public BagOfWords getRest() {
    return rest;
  }

  /**
   * Get the count of the current word.
   *
   * @return - Integer, the current count.
   */
  public Integer getWordsCount() {
    return wordsCount;
  }

  /**
   * Increase the count of the current word by one.
   */
  @Override
  public void increaseCountByOne() {
    this.wordsCount++;
  }

  /**
   * Increase the count for the specified word in the rest of the element by one for each
   * occurrence.
   *
   * @param words - String, specified word.
   * @param rest  - BagOfWords, the rest of the element.
   */
  private void increaseCountForWords(String words, BagOfWords rest) {
    // The rest of the element is null, no duplicate word exist for the rest of the element, simply return.
    if (rest == null) {
      return;
    }

    // If the rest of the element is not an empty bag of words and the word equals to the specified
    // word, we increment the count of that element by one.
    if (!rest.isEmpty() && rest.getWords().equals(words)) {
      rest.increaseCountByOne();
    }

    // Recursively call this method with the rest of the element.
    increaseCountForWords(words, rest.getRest());
  }

  /**
   * Get the count of the specified string.
   *
   * @param s - String, the specified word.
   * @return - Integer, the count.
   */
  @Override
  public Integer getCount(String s) {
    //If the element is not a empty bag of words, and it equals the specified word, simply get its count.
    if (!isEmpty() && getWords().equals(s)) {
      return this.wordsCount;
    }

    // If the rest of the current element is not null, recursively call the getCount on the rest
    // of the element.
    if (getRest() != null) {
      return getRest().getCount(s);
    }

    // If not found, return 0.
    return 0;
  }

  /**
   * Creates an empty bag of words.
   *
   * @return - BagOfWords, an empty bag of words.
   */
  @Override
  public BagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * Determine if the bag is empty.
   *
   * @return - always false because this is a non-empty bag of words.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Determine the size of the bag of words recursively.
   *
   * @return - Integer, the size.
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  /**
   * Add the specified word the bag of words. We recursively update the count of the specified word
   * in the rest of the element if there is any duplicate. Then, the calling object of this method
   * will become the rest of the element for this newly added word.
   *
   * @param s - String, specified new word.
   * @return - a new bag of words with the word added.
   */
  @Override
  public BagOfWords add(String s) {
    increaseCountForWords(s, this);
    return new NonEmptyBagOfWords(s, this);
  }

  /**
   * Check if the bag of words contains the specified word.
   *
   * @param s - String, the specified word.
   * @return - Boolean, whether contains.
   */
  @Override
  public Boolean contains(String s) {
    // If it is empty, means we are at the empty bag of words and still not found it, simply return
    // false. Otherwise, return true if the word is equals to the specified word recursively.
    if (isEmpty()) {
      return false;
    } else if (s.equals(getWords())) {
      return true;
    }
    return this.rest.contains(s);
  }

  /**
   * Compare two non-empty bag of words object.
   *
   * @param o - the other non-empty bag of words object.
   * @return - whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonEmptyBagOfWords)) {
      return false;
    }
    BagOfWords bag = (BagOfWords) o;

    // Check the sizes of the two object, only compare if the size is equal, otherwise return false.
    int thisSize = size();
    int thatSize = bag.size();
    if (thisSize == thatSize) {
      return equalsRecursive(bag);
    }
    return false;
  }

  /**
   * Recursively check if the element in the specified bag is contained in the bag. If the specified
   * bag is empty, that means we are at the empty bag of words and every word in the specified bag
   * has already been checked. This also accounts for the situation when both bags are empty.
   * Otherwise, if the bag does not contain the element in the specified bag, return false. If the
   * bag contains the word in the specified bag, check whether the count of occurrence for that word
   * is the same. Otherwise, return false. Then, recursively check for the rest of the elements.
   *
   * @param bag - BagOfWords, the bag to be recursively checked.
   * @return - whether equal when the size is the same.
   */
  private boolean equalsRecursive(BagOfWords bag) {
    if (bag.isEmpty()) {
      return true;
    } else if (!contains(bag.getWords())) {
      return false;
    } else if (contains(bag.getWords())) {
      if (!getCount(bag.getWords()).equals(bag.getCount(bag.getWords()))) {
        return false;
      }
    }
    return equalsRecursive(bag.getRest());
  }

  /**
   * Generate the hashcode of the non-empty bag of words recursively.
   *
   * @return - int, hashcode.
   */
  @Override
  public int hashCode() {
    if (!isEmpty()) {
      return Objects.hash(getWords(), getWordsCount()) + getRest().hashCode();
    }
    return Objects.hash(size(), getWords(), getRest());
  }

  /**
   * String expression for the non-empty bag of words.
   *
   * @return string expression.
   */
  @Override
  public String toString() {
    return "NonEmptyBagOfWords{" +
        "words='" + words + '\'' +
        ", rest=" + rest +
        ", wordsCount=" + wordsCount +
        '}';
  }
}
