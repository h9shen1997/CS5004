package P2;

import CommonClasses.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student> {

  private static final String CS5001 = "CS5001";
  private static final String CS5002 = "CS5002";
  private static final String CS5004 = "CS5004";
  private static final String CS5008 = "CS5008";

  List<Student> students;

  public StudentIterator(List<Student> students) {
    this.students = students;
  }

  @Override
  public boolean hasNext() {
    return this.students.size() > 0;
  }

  @Override
  public Student next() {
    Student student = null;
    if (hasNext()) {
      student = this.students.get(0);
      this.students.remove(0);
    }
    return student;
  }

  /**
   * Helper method to check if the student have taken all four ALIGN courses.
   *
   * @param student The student to be checked.
   * @return whether the student has taken all four ALIGN courses or not.
   */
  private boolean hasTakenAllFourALIGNCourse(Student student) {
    return student.getTakenCourses().stream().filter(x -> x.getCourseCode().equals(CS5001))
        .filter((y -> y.getCourseCode().equals(CS5002)))
        .filter(z -> z.getCourseCode().equals(CS5004))
        .anyMatch(w -> w.getCourseCode().equals(CS5008));
  }

  /**
   * Iterate through the list of students and obtain students who have taken all four ALIGN courses.
   *
   * @return A list of students who have taken all four ALIGN courses.
   */
  public List<Student> findStudentsTakenAllFourALIGNCourses() {
    List<Student> filteredStudents = new ArrayList<>();
    while (hasNext()) {
      Student nextStudent = next();
      if (hasTakenAllFourALIGNCourse(nextStudent)) {
        filteredStudents.add(nextStudent);
      }
    }
    return filteredStudents;
  }
}
