package p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CourseCatalogTest {

  CourseCatalog cc;

  @Test
  public void append() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    assertEquals(7, cc.count(), 0);
  }

  @Test
  public void removeWhenCourseExist() throws CourseNotFoundException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    cc.remove(new Course("math", "m", 1));
    cc.remove(new Course("physics", "p", 2));
    assertEquals(5, cc.count(), 0);
    assertFalse(
        cc.contains(new Course("physics", "p", 2)) || cc.contains(new Course("math", "m", 1)));
  }

  @Test(expected = CourseNotFoundException.class)
  public void removeWhenCourseNotExist() throws CourseNotFoundException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    cc.remove(new Course("transparent", "t", 8));
  }

  @Test
  public void contains() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    assertTrue(cc.contains(new Course("physics", "p", 2)) && !cc.contains(
        new Course("transparent", "t", 8)));
  }

  @Test
  public void indexOfValidIndex() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    assertEquals(0, cc.indexOf(new Course("math", "m", 1)), 0);
    assertEquals(4, cc.indexOf(new Course("algebra", "a", 5)), 0);
    assertEquals(-1, cc.indexOf(new Course("transparent", "t", 8)), 0);
  }

  @Test
  public void count() throws CourseNotFoundException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    assertEquals(7, cc.count(), 0);
  }

  @Test
  public void getValidIndex() throws InvalidIndexException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    assertEquals(new Course("math", "m", 1), cc.get(0));
    assertEquals(new Course("physics", "p", 2), cc.get(1));
  }

  @Test(expected = InvalidIndexException.class)
  public void getInvalidIndexLessThanZero() throws InvalidIndexException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    cc.get(-1);
  }

  @Test(expected = InvalidIndexException.class)
  public void getInvalidIndexMoreThanCount() throws InvalidIndexException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    cc.get(7);
  }

  @Test
  public void isEmpty() throws CourseNotFoundException {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    assertFalse(cc.isEmpty());
    cc.remove(new Course("math", "m", 1));
    cc.remove(new Course("physics", "p", 2));
    assertTrue(cc.isEmpty());
  }

  @Test
  public void testEqualsWhenSameAddress() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    CourseCatalog ccCopy = cc;
    assertTrue(cc.equals(ccCopy) && ccCopy.equals(cc) && cc.hashCode() == ccCopy.hashCode());
  }

  @Test
  public void testEqualsDifferentAddressSameContent() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("economics", "e", 4));
    cc.append(new Course("algebra", "a", 5));
    cc.append(new Course("magics", "m", 6));
    cc.append(new Course("pe", "p", 7));
    CourseCatalog ccCopy = new CourseCatalog();
    ccCopy.append(new Course("math", "m", 1));
    ccCopy.append(new Course("physics", "p", 2));
    ccCopy.append(new Course("chemistry", "c", 3));
    ccCopy.append(new Course("economics", "e", 4));
    ccCopy.append(new Course("algebra", "a", 5));
    ccCopy.append(new Course("magics", "m", 6));
    ccCopy.append(new Course("pe", "p", 7));
    assertTrue(cc.equals(ccCopy) && ccCopy.equals(cc) && cc.hashCode() == ccCopy.hashCode());
  }

  @Test
  public void testEqualsDifferentCourseOrder() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    CourseCatalog ccCopy = new CourseCatalog();
    ccCopy.append(new Course("math", "m", 1));
    ccCopy.append(new Course("chemistry", "c", 3));
    ccCopy.append(new Course("physics", "p", 2));
    assertFalse(cc.equals(ccCopy) || ccCopy.equals(cc));
  }

  @Test
  public void testEqualsDifferentCount() {
    cc = new CourseCatalog();
    cc.append(new Course("math", "m", 1));
    cc.append(new Course("physics", "p", 2));
    cc.append(new Course("chemistry", "c", 3));
    cc.append(new Course("magics", "m", 4));
    CourseCatalog ccCopy = new CourseCatalog();
    ccCopy.append(new Course("math", "m", 1));
    ccCopy.append(new Course("physics", "p", 2));
    ccCopy.append(new Course("chemistry", "c", 3));
    assertFalse(cc.equals(ccCopy) || ccCopy.equals(cc));
  }

  @Test
  public void testEqualsDifferentClass() {
    cc = new CourseCatalog();
    cc.append(new Course("magics", "m", 6));
    Course c = new Course("magics", "m", 6);
    assertFalse(cc.equals(c) || c.equals(cc));
  }
}