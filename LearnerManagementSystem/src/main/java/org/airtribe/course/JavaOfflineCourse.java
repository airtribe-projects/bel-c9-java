package org.airtribe.course;

import java.util.List;
import org.airtribe.cohort.Cohort;


public class JavaOfflineCourse extends Course {

  private String location;

  private String courseType;

  public JavaOfflineCourse(String courseId, String courseName, String courseDescription, String location, String courseType) {
    super(courseId, courseName, courseDescription);
    this.location = location;
    this.courseType = courseType;
  }

  public JavaOfflineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String location, String courseType) {
    super(courseId, courseName, courseDescription, cohortList);
    this.location = location;
    this.courseType = courseType;
  }

  public JavaOfflineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String location) {
    super(courseId, courseName, courseDescription, cohortList);
    this.location = location;
    this.courseType = "JAVA";
  }

  @Override
  public void displayCourseDetails() {
    System.out.println("-------------------------------");
    System.out.println("Course ID: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Location: " + location);
    System.out.println("Course Type: " + courseType);
    System.out.println("Cohorts: ");
    for (Cohort cohort : cohortList) {
      cohort.displayCohortDetails();
    }
    System.out.println("-------------------------------");

  }
}
