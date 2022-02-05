package P3;

import java.util.Objects;

public class CourseStatistics {

  private final int numOfStudents;
  private final int numOfALIGNStudents;
  private final float averageGrade;
  private final float averageALIGNGrade;

  public CourseStatistics(int numOfStudents, int numOfALIGNStudents, float averageGrade,
      float averageALIGNGrade) {
    this.numOfStudents = numOfStudents;
    this.numOfALIGNStudents = numOfALIGNStudents;
    this.averageGrade = averageGrade;
    this.averageALIGNGrade = averageALIGNGrade;
  }

  public int getNumOfStudents() {
    return numOfStudents;
  }

  public int getNumOfALIGNStudents() {
    return numOfALIGNStudents;
  }

  public float getAverageGrade() {
    return averageGrade;
  }

  public float getAverageALIGNGrade() {
    return averageALIGNGrade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseStatistics that = (CourseStatistics) o;
    return numOfStudents == that.numOfStudents && numOfALIGNStudents == that.numOfALIGNStudents
        && Float.compare(that.averageGrade, averageGrade) == 0
        && Float.compare(that.averageALIGNGrade, averageALIGNGrade) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numOfStudents, numOfALIGNStudents, averageGrade, averageALIGNGrade);
  }

  @Override
  public String toString() {
    return "CourseStatistics{" +
        "numOfStudents=" + numOfStudents +
        ", numOfALIGNStudents=" + numOfALIGNStudents +
        ", averageGrade=" + averageGrade +
        ", averageALIGNGrade=" + averageALIGNGrade +
        '}';
  }
}
