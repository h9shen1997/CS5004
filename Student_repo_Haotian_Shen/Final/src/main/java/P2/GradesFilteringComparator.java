package P2;

import CommonClasses.Student;
import java.util.Comparator;

public class GradesFilteringComparator implements Comparator<Student> {

  private static final float GPA_CUTOFF = 3.3f;

  /**
   * Compare student o1 with student o2 based on the number of courses they have taken where they
   * have got a grade of 3.3 or higher.
   *
   * @param s1 the first student to be compared.
   * @param s2 the second student to be compared.
   * @return a negative integer, zero, or a positive integer as the first student's number of
   * courses is less than, equal to, or greater than the second student's number of courses based on
   * the cutoff GPA of 3.3.
   */
  @Override
  public int compare(Student s1, Student s2) {
    return Integer.compare(s1.getNumOfCoursesOfSpecifiedGPAOrHigher(GPA_CUTOFF),
        s2.getNumOfCoursesOfSpecifiedGPAOrHigher(GPA_CUTOFF));
  }
}
