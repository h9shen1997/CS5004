package P3;

import CommonClasses.Course;
import CommonClasses.Student;
import P2.StudentIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CourseRecommender {

  private static final String CS5001 = "CS5001";
  private static final String CS5002 = "CS5002";
  private static final String CS5004 = "CS5004";
  private static final String CS5008 = "CS5008";
  private static final int RECOMMEND_CUTOFF = 3;
  List<Student> students;
  List<Student> ALIGNStudent;
  Map<String, CourseStatistics> map;

  public CourseRecommender(List<Student> students, List<Student> ALIGNStudent,
      Map<String, CourseStatistics> map) {
    this.students = students;
    this.ALIGNStudent = ALIGNStudent;
    this.map = map;
  }

  public CourseRecommender(List<Student> students) {
    this.students = students;
    this.ALIGNStudent = filterOutALIGNStudents(students);
    this.map = computeCollegeCoursesStatistics(students);
  }

  private List<Student> filterOutALIGNStudents(List<Student> allStudents) {
    List<Student> ALIGNStudents = new ArrayList<>();
    StudentIterator iterator = new StudentIterator(allStudents);
    while (iterator.hasNext()) {
      Student student = iterator.next();
      if (hasTakenAnyALIGNCourse(student)) {
        ALIGNStudents.add(student);
      }
    }
    return ALIGNStudents;
  }

  private boolean hasTakenAnyALIGNCourse(Student student) {
    for (Course course : student.getTakenCourses()) {
      String courseCode = course.getCourseCode();
      if (courseCode.equals(CS5001) || courseCode.equals(CS5002) || courseCode.equals(CS5004)
          || courseCode.equals(CS5008)) {
        return true;
      }
    }
    return false;
  }

  private Map<String, CourseStatistics> computeCollegeCoursesStatistics(List<Student> students) {
    Map<String, Integer> allStudentCourseCounter = new HashMap<>();
    Map<String, Integer> allStudentCourseGradeSum = new HashMap<>();
    Map<String, Integer> ALIGNStudentCourseCounter = new HashMap<>();
    Map<String, Integer> ALIGNStudentCourseGradeSum = new HashMap<>();
    Map<String, CourseStatistics> result = new HashMap<>();
    for (Student student : students) {
      for (Course course : student.getTakenCourses()) {

        String courseCode = course.getCourseCode();
        allStudentCourseCounter.put(courseCode,
            allStudentCourseCounter.getOrDefault(courseCode, 0) + 1);
        allStudentCourseGradeSum.put(courseCode,
            allStudentCourseGradeSum.getOrDefault(courseCode, 0) + course.getGrade());

        if (hasTakenAnyALIGNCourse(student)) {
          ALIGNStudentCourseCounter.put(courseCode,
              ALIGNStudentCourseCounter.getOrDefault(courseCode, 0) + 1);
          ALIGNStudentCourseGradeSum.put(courseCode,
              ALIGNStudentCourseGradeSum.getOrDefault(courseCode, 0) + course.getGrade());
        }
      }
    }
    for (String courseCode : allStudentCourseCounter.keySet()) {
      float averageGrade = (float) allStudentCourseGradeSum.getOrDefault(courseCode, 0)
          / allStudentCourseCounter.get(courseCode);
      float averageALIGNGrade = ALIGNStudentCourseCounter.containsKey(courseCode) ?
          (float) ALIGNStudentCourseGradeSum.getOrDefault(courseCode, 0)
              / ALIGNStudentCourseCounter.get(courseCode) : 0;
      CourseStatistics statistics = new CourseStatistics(allStudentCourseCounter.get(courseCode),
          ALIGNStudentCourseCounter.get(courseCode), averageGrade, averageALIGNGrade);
      result.put(courseCode, statistics);
    }
    return result;
  }

  /**
   * Recommend three courses based on the following criteria: 1. The courses that all the students
   * take the most and hasn't been taken by this student yet. 2. The course with the highest average
   * grade and hasn't been taken by this student yet. 3. The courses that all the students take the
   * least and hasn't been taken by this student yet to ensure he can secure a spot.
   *
   * @param student - The student taking the recommendation.
   * @return - Three courses to recommend to the student.
   * @throws RecommendedCourseNotEnoughException If there aren't 3 courses to recommend.
   */
  public List<String> recommendCourses(Student student) throws RecommendedCourseNotEnoughException {
    List<String> recommendedCourses = new ArrayList<>();
    Map<String, CourseStatistics> statistics = computeCollegeCoursesStatistics(this.students);

    PriorityQueue<Object[]> frequencyMINPQ = new PriorityQueue<>(
        Comparator.comparingInt(a -> (Integer) a[1]));
    PriorityQueue<Object[]> averageGradePQ = new PriorityQueue<>(
        (a, b) -> Float.compare((Float) b[1], (Float) a[1]));
    PriorityQueue<Object[]> frequencyMAXPQ = new PriorityQueue<>(
        (a, b) -> Integer.compare((Integer) b[1], (Integer) a[1]));

    for (String courseCode : statistics.keySet()) {
      frequencyMAXPQ.offer(new Object[]{courseCode, statistics.get(courseCode).getNumOfStudents()});
      averageGradePQ.offer(new Object[]{courseCode, statistics.get(courseCode).getAverageGrade()});
      frequencyMINPQ.offer(new Object[]{courseCode, statistics.get(courseCode).getNumOfStudents()});
    }

    // first recommendation
    recommendCourseBasedOnFrequency(student, recommendedCourses, frequencyMAXPQ);

    // second recommendation
    recommendCourseBasedOnAverageGrade(student, recommendedCourses, averageGradePQ);

    // third recommendation
    recommendCourseBasedOnFrequency(student, recommendedCourses, frequencyMINPQ);

    if (recommendedCourses.size() < RECOMMEND_CUTOFF) {
      throw new RecommendedCourseNotEnoughException(
          "There are less than 3 courses to recommend to the student!");
    }
    return recommendedCourses;
  }

  /**
   * Recommend courses based on the number of students taking that course.
   *
   * @param student            - The student that takes the recommendation.
   * @param recommendedCourses - A list of recommended course code.
   * @param frequencyPQ        - A priority queue that takes either a max heap or a min heap, where
   *                           it is sorted based on the number of students taking that courses
   *                           either in descending or ascending order.
   */
  private void recommendCourseBasedOnFrequency(Student student, List<String> recommendedCourses,
      PriorityQueue<Object[]> frequencyPQ) {
    while (frequencyPQ.size() > 0) {
      Object[] pop = frequencyPQ.poll();
      String courseCode = (String) pop[0];
      if (student.getTakenCourses().stream().noneMatch(x -> x.getCourseCode().equals(courseCode))) {
        recommendedCourses.add(courseCode);
      }
    }
  }

  /**
   * Recommend courses based on the highest average grade of the course.
   *
   * @param student            - The student that takes the recommendation.
   * @param recommendedCourses - A list of recommended course code.
   * @param averageGradePQ     - A priority queue that takes either a max heap
   */
  private void recommendCourseBasedOnAverageGrade(Student student, List<String> recommendedCourses,
      PriorityQueue<Object[]> averageGradePQ) {
    while (averageGradePQ.size() > 0) {
      Object[] pop = averageGradePQ.poll();
      String courseCode = (String) pop[0];
      if (student.getTakenCourses().stream().anyMatch(x -> x.getCourseCode().equals(courseCode))) {
        recommendedCourses.add(courseCode);
      }
    }
  }
}
