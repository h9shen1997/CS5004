package p1;

import java.util.Arrays;
import java.util.Objects;

/**
 * CourseCatalog is a collection of courses implemented using array data structure. It stores the
 * current number of element in the course catalog and the current capacity of this catalog. The
 * course catalog will resize if the current element equals capacity or drops to one quarter of the
 * capacity.
 */
public class CourseCatalog implements CourseCatalogFunctionality {

  private static final int RESIZE_FACTOR = 2;
  private static final int QUARTER_CAPACITY = 4;
  private static final int INIT_CAPACITY = 10;
  private int elementNum;
  private int curCapacity;
  private Course[] courseCollection;

  /**
   * Constructor to create an empty course catalog with initial capacity of 10.
   */
  public CourseCatalog() {
    this.elementNum = 0;
    this.curCapacity = INIT_CAPACITY;
    courseCollection = new Course[this.curCapacity];
  }

  /**
   * Setter for element number. This is only used internally by the class. This is not usable
   * outside the class as the element number is naturally increased or decreased through append and
   * remove.
   *
   * @param elementNum - int, the element number.
   */
  private void setElementNum(int elementNum) {
    this.elementNum = elementNum;
  }

  /**
   * Getter for current capacity. This is only used internally by the class. This is not usable
   * outside the class as the current capacity is decided by the number of element in it.
   *
   * @return - int, current capacity.
   */
  private int getCurCapacity() {
    return this.curCapacity;
  }

  /**
   * Setter for current capacity. This is only used internally by the class. This is not usable
   * outside the class as the current * capacity is decided by the number of element in it.
   *
   * @param curCapacity - int, current capacity.
   */
  private void setCurCapacity(int curCapacity) {
    this.curCapacity = curCapacity;
  }

  /**
   * Getter for course catalog array. This is only used internally by the class.
   *
   * @return - Course[], an array of Course.
   */
  private Course[] getCourseCollection() {
    return courseCollection;
  }

  /**
   * Setter for course catalog array. This is only used internally by the class.
   *
   * @param courseCollection - Course[], an array of Course.
   */
  private void setCourseCollection(Course[] courseCollection) {
    this.courseCollection = courseCollection;
  }

  /**
   * Append the course to the end of the current course catalog array.
   *
   * @param course - Course, the new course to be added.
   */
  @Override
  public void append(Course course) {
    int n = count();
    setCurCapacity(n == getCurCapacity() ? this.curCapacity * RESIZE_FACTOR : this.curCapacity);
    copyCourseCollection(getCurCapacity());
    this.courseCollection[n] = course;
    setElementNum(n + 1);
  }

  /**
   * Remove the specified course from the course catalog array.
   *
   * @param course - Course, the course to be removed.
   * @throws CourseNotFoundException if the course does not exist in the course catalog array.
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException {
    boolean found = false;
    int n = count();
    for (int i = 0; i < n; i++) {

      // If found, shift all element behind this one index forward. If we are at the last element,
      // simply delete it. After this operation, break the for loop because I have found it.
      if (getCourseCollection()[i].equals(course)) {
        found = true;
        for (int j = i; j < n; j++) {
          if (j == n - 1) {
            getCourseCollection()[j] = null;
          } else {
            getCourseCollection()[j] = getCourseCollection()[j + 1];
          }
        }
        break;
      }
    }
    if (!found) {
      throw new CourseNotFoundException("The course does not exist in the course catalog");
    }

    // If the current number of element drops below one quarter of the current capacity, shrink the
    // capacity to half to save memory.
    setCurCapacity(n - 1 <= getCurCapacity() / QUARTER_CAPACITY ? getCurCapacity() / RESIZE_FACTOR
        : getCurCapacity());
    setElementNum(n - 1);
    copyCourseCollection(getCurCapacity());
  }

  /**
   * Helper method to copy the current course catalog into a new array with the provided new
   * capacity.
   *
   * @param newCapacity - int, new capacity of the array.
   */
  private void copyCourseCollection(int newCapacity) {
    Course[] copyCourseCollection = new Course[newCapacity];
    int n = count();
    for (int i = 0; i < n; i++) {
      copyCourseCollection[i] = getCourseCollection()[i];
    }
    setCourseCollection(copyCourseCollection);
  }

  /**
   * Check if the course catalog array contains the provided course.
   *
   * @param course - Course, course to be checked.
   * @return - boolean, whether the course is found.
   */
  @Override
  public boolean contains(Course course) {
    int n = count();
    for (int i = 0; i < n; i++) {
      if (getCourseCollection()[i].equals(course)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Return the index of the provided Course element.
   *
   * @param course - Course, the Course element to be checked.
   * @return - int, the index of the course, or -1 if not found.
   */
  @Override
  public int indexOf(Course course) {
    int n = count();
    for (int i = 0; i < n; i++) {
      if (getCourseCollection()[i].equals(course)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Return the number of course in the course catalog array.
   *
   * @return - int, the number of course.
   */
  @Override
  public int count() {
    return this.elementNum;
  }

  /**
   * Return the Course element at the specified index.
   *
   * @param i - int, the index.
   * @return - Course, the Course element at the specified index.
   * @throws InvalidIndexException if the index is less than zero or greater than one less than the
   *                               number of element.
   */
  @Override
  public Course get(int i) throws InvalidIndexException {
    int n = count();
    if (i < 0 || i >= n) {
      throw new InvalidIndexException(
          "The index provided is not valid because it needs to be in the range of 0 and " + (
              n - 1));
    }
    return getCourseCollection()[i];
  }

  /**
   * Determine if the course catalog is empty.
   *
   * @return - boolean, whether the array is empty.
   */
  @Override
  public boolean isEmpty() {
    return this.elementNum == 0;
  }

  /**
   * Return the string representation of the Course object.
   *
   * @return - String, the string representation of the course object.
   */
  @Override
  public String toString() {
    return "CourseCatalog{" +
        "elementNum=" + elementNum +
        ", curCapacity=" + curCapacity +
        ", courseCollection=" + Arrays.toString(courseCollection) +
        '}';
  }

  /**
   * Compare two Course objects.
   *
   * @param o - Object, the object to be compared.
   * @return - boolean, whether two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CourseCatalog)) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    return count() == that.count() && Arrays.equals(getCourseCollection(),
        that.getCourseCollection());
  }

  /**
   * Generate the hashcode of the CourseCatalog object.
   *
   * @return - int, the hashcode.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(count());
    result = 31 * result + Arrays.hashCode(getCourseCollection());
    return result;
  }
}
