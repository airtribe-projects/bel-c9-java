package org.airtribe.course;

import java.util.List;
import org.airtribe.cohort.Cohort;


public class NodeOnlineCourse extends Course {
  private String zoomUrl;

  private String courseType;


  public NodeOnlineCourse(String courseId, String courseName, String courseDescription, String zoomUrl, String courseType) {
    super(courseId, courseName, courseDescription);
    this.zoomUrl = zoomUrl;
    this.courseType = courseType;
  }

  public NodeOnlineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String zoomUrl, String courseType) {
    super(courseId, courseName, courseDescription, cohortList);
    this.zoomUrl = zoomUrl;
    this.courseType = courseType;
  }

  public NodeOnlineCourse(String courseId, String courseName, String courseDescription, List<Cohort> cohortList, String zoomUrl) {
    super(courseId, courseName, courseDescription, cohortList);
    this.zoomUrl = zoomUrl;
    this.courseType = "NODE";
  }

  @Override
  public void displayCourseDetails() {
    System.out.println("-------------------------------");
    System.out.println("Course ID: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Zoom URL: " + zoomUrl);
    System.out.println("Course Type: " + courseType);
    System.out.println("Cohorts: ");
    for (Cohort cohort : cohortList) {
      cohort.displayCohortDetails();
    }
    System.out.println("-------------------------------");
  }
}
