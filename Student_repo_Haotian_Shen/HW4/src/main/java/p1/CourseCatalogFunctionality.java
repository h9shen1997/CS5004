package p1;

/**
 * Interface for the functionality of the CourseCatalog.
 */
public interface CourseCatalogFunctionality {

  void append(Course course);

  void remove(Course course) throws CourseNotFoundException;

  boolean contains(Course course);

  int indexOf(Course course);

  int count();

  Course get(int i) throws InvalidIndexException;

  boolean isEmpty();
}
