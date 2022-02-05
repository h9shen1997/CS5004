package CommonClasses;

import java.util.List;
import java.util.Objects;

/*
Class Student contains information about a student - students name and their studentID, academic program a student is
enrolled into, as well as the list of courses the student has taken.
 */
public class Student implements Comparable<Student> {

  private final Name name;
  private final String studentID;
  private final String academicProgram;
  private final List<Course> takenCourses;

  public Student(Name name, String studentID, String academicProgram, List<Course> takenCourses) {
    this.name = name;
    this.studentID = studentID;
    this.academicProgram = academicProgram;
    this.takenCourses = takenCourses;
  }

  public Name getName() {
    return name;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getAcademicProgram() {
    return academicProgram;
  }

  public List<Course> getTakenCourses() {
    return takenCourses;
  }

  public Float getGPA() {
    Integer gradeSum = 0;
    for (Course course : this.takenCourses) {
      gradeSum += course.getGrade();
    }
    return (float) gradeSum / this.takenCourses.size();
  }

  /**
   * Get the number of courses the student has taken where they have got a grade of 3.3 or higher.
   *
   * @param GPA - The cutoff gpa.
   * @return The number of courses that satisfy the criteria.
   */
  public int getNumOfCoursesOfSpecifiedGPAOrHigher(Float GPA) {
    int numOfCourses = 0;
    for (Course course : this.takenCourses) {
      if (course.getGrade() >= GPA) {
        numOfCourses++;
      }
    }
    return numOfCourses;
  }

  /**
   * Compare the calling student with the provided student based on their GPA. The two student will
   * be compared in an increasing order based on their GPA.
   *
   * @param o the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   * or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it from being compared to
   *                              this object.
   */
  @Override
  public int compareTo(Student o) {
    return Float.compare(this.getGPA(), o.getGPA());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(getName(), student.getName()) &&
        Objects.equals(getStudentID(), student.getStudentID()) &&
        Objects.equals(getAcademicProgram(), student.getAcademicProgram()) &&
        Objects.equals(getTakenCourses(), student.getTakenCourses());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getStudentID(), getAcademicProgram(), getTakenCourses());
  }

  @Override
  public String toString() {
    return "Student{" +
        "name=" + name +
        ", studentID='" + studentID + '\'' +
        ", academicProgram='" + academicProgram + '\'' +
        ", takenCourses=" + takenCourses +
        '}';
  }
}
