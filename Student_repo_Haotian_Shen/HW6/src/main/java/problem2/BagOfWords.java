package problem2;

/**
 * BagOfWords interface defines the functionality of a recursive bag of words that may contain
 * duplicates. The implementation is using a structure similar to linked list.
 */
public interface BagOfWords {

  /**
   * Create an empty bag of words that contains no element.
   *
   * @return - BagOfWords, the new empty bag of words.
   */
  BagOfWords emptyBagOfWords();

  /**
   * Determine whether the bag is empty.
   *
   * @return - Boolean, whether the bag is empty.
   */
  Boolean isEmpty();

  /**
   * Return the number of words in the bag.
   *
   * @return - Integer, the number of words.
   */
  Integer size();

  /**
   * Add the specified word to the bag.
   *
   * @param s - String, specified new word.
   * @return - BagOfWords, the bag of words with the specified string added.
   */
  BagOfWords add(String s);

  /**
   * Check whether the bag contains the specified word.
   *
   * @param s - String, the specified word.
   * @return - Boolean, whether contains.
   */
  Boolean contains(String s);

  /**
   * Get the word at the current element.
   *
   * @return - String, the word.
   */
  String getWords();

  /**
   * Get the rest of the element in the bag of words.
   *
   * @return - BagOfWords, the rest of the element in the bag of words.
   */
  BagOfWords getRest();

  /**
   * Increase the count of current word by one. This will be used in add method to update the
   * already existing word in case the newly added word is a duplicate.
   */
  void increaseCountByOne();

  /**
   * Get the count of specified word.
   *
   * @param s - String, the specified word.
   * @return - Integer, the count.
   */
  Integer getCount(String s);
}
