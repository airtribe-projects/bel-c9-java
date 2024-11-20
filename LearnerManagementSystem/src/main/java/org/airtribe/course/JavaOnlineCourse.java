package org.airtribe.course;

import java.util.List;
import org.airtribe.cohort.Cohort;


public class JavaOnlineCourse extends Course {
  private String zoomLink;

  private String courseType;

  public JavaOnlineCourse(String courseId, String courseName, String courseDescription, String zoomLink, String courseType) {
    super(courseId, courseName, courseDescription);
    this.zoomLink = zoomLink;
    this.courseType = courseType;
  }

  public JavaOnlineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String zoomLink, String courseType) {
    super(courseId, courseName, courseDescription, cohortList);
    this.zoomLink = zoomLink;
    this.courseType = courseType;
  }

  public JavaOnlineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String zoomLink) {
    super(courseId, courseName, courseDescription, cohortList);
    this.zoomLink = zoomLink;
    this.courseType = "JAVA";
  }

  @Override
  public void displayCourseDetails() {
    System.out.println("-------------------------------");
    System.out.println("Course ID: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Zoom Link: " + zoomLink);
    System.out.println("Course Type: " + courseType);
    System.out.println("Cohorts: ");
    for (Cohort cohort : cohortList) {
      cohort.displayCohortDetails();
    }
    System.out.println("-------------------------------");
  }
}
