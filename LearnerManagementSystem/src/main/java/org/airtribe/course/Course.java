package org.airtribe.course;

import java.util.ArrayList;
import java.util.List;
import org.airtribe.cohort.Cohort;


public abstract class Course {

  protected String courseId;

  protected String courseName;

  protected String courseDescription;

  protected List<Cohort> cohortList; // composition

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseDescription() {
    return courseDescription;
  }

  public void setCourseDescription(String courseDescription) {
    this.courseDescription = courseDescription;
  }

  public List<Cohort> getCohortList() {
    return cohortList;
  }

  public void setCohortList(List<Cohort> cohortList) {
    this.cohortList = cohortList;
  }

  public Course(String courseId, String courseName, String courseDescription) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.cohortList = new ArrayList<>();
  }

  public Course(String courseId, String courseName, String courseDescription, List<Cohort> cohortList) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.cohortList = cohortList;
  }

  public abstract void displayCourseDetails();
}
