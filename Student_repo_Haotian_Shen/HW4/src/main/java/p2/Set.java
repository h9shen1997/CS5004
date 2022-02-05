package p2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Set implemented using an array of Integer. The set stores information of the number of elements
 * in the set and the current capacity of the set. All elements in the set are unique. The set is
 * immutable, so any method that modify the set will return a new set.
 */
public class Set implements SetFunctionality {

  private static final int EMPTY_SET_INIT_CAPACITY = 10;
  private static final int QUARTER_CAPACITY = 4;
  private static final int RESIZE_FACTOR = 2;
  private final int elementNum;
  private final int curCapacity;
  private final Integer[] setCollection;

  /**
   * Constructor that creates an empty set with an initial capacity of 10.
   */
  public Set() {
    this.elementNum = 0;
    this.curCapacity = EMPTY_SET_INIT_CAPACITY;
    this.setCollection = new Integer[this.curCapacity];
  }

  /**
   * Constructor that creates a new set with the new capacity and copy all the original element.
   *
   * @param elementNum    - int, number of element in the new set.
   * @param curCapacity   - int, capacity of the new set.
   * @param setCollection - Integer[], the new Integer array with element in it.
   */
  public Set(int elementNum, int curCapacity, Integer[] setCollection) {
    this.elementNum = elementNum;
    this.curCapacity = curCapacity;
    this.setCollection = Arrays.copyOf(setCollection, curCapacity);
  }

  /**
   * Getter for the current capacity. This is only used by the class and not accessible outside the
   * class.
   *
   * @return
   */
  private int getCurCapacity() {
    return this.curCapacity;
  }

  /**
   * Getter for the set collection array. This is only used by the class and not accessible outside
   * the class.
   *
   * @return - Integer[], the current set collection array.
   */
  private Integer[] getSetCollection() {
    return this.setCollection;
  }

  /**
   * Create a new empty set with an initial capacity of 10.
   *
   * @return - Set, a new empty set.
   */
  @Override
  public Set emptySet() {
    return new Set();
  }

  /**
   * Determine if the curren set is empty.
   *
   * @return - Boolean, whether the set is empty.
   */
  @Override
  public Boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Add the given integer to the set if there is no same element in the set already.
   *
   * @param n - Integer, the integer to be added.
   * @return - Set, a new Set with the element added.
   */
  @Override
  public Set add(Integer n) {
    if (!contains(n)) {
      int newCapacity =
          size() == getCurCapacity() ? getCurCapacity() * RESIZE_FACTOR : getCurCapacity();
      Integer[] newSetCollection = Arrays.copyOf(getSetCollection(), newCapacity);
      newSetCollection[size()] = n;
      return new Set(size() + 1, newCapacity, newSetCollection);
    }
    return this;
  }

  /**
   * Determine if the set contains the integer.
   *
   * @param n - Integer, the integer to be checked.
   * @return - Boolean, whether the set contains the given integer.
   */
  @Override
  public Boolean contains(Integer n) {
    for (int i = 0; i < size(); i++) {
      if (getSetCollection()[i].equals(n)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Remove the specified element from the set. If the set does not contain the element, just return
   * the set as it is.
   *
   * @param n - Integer, the integer to be removed.
   * @return - Set, a new set without the specified element.
   */
  @Override
  public Set remove(Integer n) {
    int size = size();
    if (contains(n)) {
      int newCapacity =
          size - 1 <= getCurCapacity() / QUARTER_CAPACITY ? getCurCapacity() / RESIZE_FACTOR
              : getCurCapacity();
      Integer[] newSetCollection = new Integer[newCapacity];
      int indexOfNewCollection = 0;
      for (int i = 0; i < size; i++) {
        if (!getSetCollection()[i].equals(n)) {
          newSetCollection[indexOfNewCollection++] = getSetCollection()[i];
        }
      }
      return new Set(size() - 1, newCapacity, newSetCollection);
    }
    return this;
  }

  /**
   * Return the size of the set.
   *
   * @return - Integer, the size of the set.
   */
  @Override
  public Integer size() {
    return this.elementNum;
  }

  /**
   * Compare whether two sets are equal.
   *
   * @param o - Object, the object to be compared.
   * @return = boolean, whether the two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set set = (Set) o;
    Integer[] arrA = set.getSetCollection();
    Integer[] arrB = getSetCollection();
    Arrays.sort(arrA, 0, size());
    Arrays.sort(arrB, 0, set.size());
    return elementNum == set.elementNum && Arrays.equals(arrA, arrB);
  }

  /**
   * Return the hashcode of the object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(size());
    Integer[] arr = getSetCollection();
    Arrays.sort(arr, 0, size());
    result = 31 * result + Arrays.hashCode(arr);
    return result;
  }

  /**
   * Return the string representation of the Set object.
   *
   * @return - String, the string representation of the object.
   */
  @Override
  public String toString() {
    return "Set{" +
        "elementNum=" + elementNum +
        ", curCapacity=" + curCapacity +
        ", setCollection=" + Arrays.toString(setCollection) +
        '}';
  }
}
