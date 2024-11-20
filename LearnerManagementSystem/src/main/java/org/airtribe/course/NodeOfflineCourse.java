package org.airtribe.course;

import java.util.List;
import org.airtribe.cohort.Cohort;


public class NodeOfflineCourse extends Course {

  private String courseLocation;

  private String courseType;


  public NodeOfflineCourse(String courseId, String courseName, String courseDescription, String courseLocation, String courseType) {
    super(courseId, courseName, courseDescription);
    this.courseLocation = courseLocation;
    this.courseType = courseType;
  }

  public NodeOfflineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String courseLocation, String courseType) {
    super(courseId, courseName, courseDescription, cohortList);
    this.courseLocation = courseLocation;
    this.courseType = courseType;
  }

  public NodeOfflineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String courseLocation) {
    super(courseId, courseName, courseDescription, cohortList);
    this.courseLocation = courseLocation;
    this.courseType = "NODE";
  }

  @Override
  public void displayCourseDetails() {
    System.out.println("-------------------------------");
    System.out.println("Course ID: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Location: " + courseLocation);
    System.out.println("Course Type: " + courseType);
    System.out.println("Cohorts: ");
    for (Cohort cohort : cohortList) {
      cohort.displayCohortDetails();
    }
    System.out.println("-------------------------------");

  }
}
