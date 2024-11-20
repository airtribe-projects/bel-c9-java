package org.airtribe.cohort;

import java.util.List;
import org.airtribe.instructor.Instructor;
import org.airtribe.learner.Learner;


public class Cohort {

  public Cohort(String cohortId, String startDate, String endDate, String cohortName, String cohortDescription,
      List<Learner> learnerList, List<Instructor> instructorList) {
    this.cohortId = cohortId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.cohortName = cohortName;
    this.cohortDescription = cohortDescription;
    this.learnerList = learnerList;
    this.instructorList = instructorList;
  }

  private String cohortId;

  private String startDate;

  private String endDate;

  private String cohortName;

  private String cohortDescription;

  private List<Learner> learnerList;

  private List<Instructor> instructorList;

  public List<Learner> getLearnerList() {
    return learnerList;
  }

  public void setLearnerList(List<Learner> learnerList) {
    this.learnerList = learnerList;
  }

  public List<Instructor> getInstructorList() {
    return instructorList;
  }

  public void setInstructorList(List<Instructor> instructorList) {
    this.instructorList = instructorList;
  }

  public String getCohortId() {
    return cohortId;
  }

  public void setCohortId(String cohortId) {
    this.cohortId = cohortId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }

  public String getCohortDescription() {
    return cohortDescription;
  }

  public void setCohortDescription(String cohortDescription) {
    this.cohortDescription = cohortDescription;
  }

  public void displayCohortDetails() {
    System.out.println("-------------------------------");
    System.out.println("Cohort ID: " + cohortId);
    System.out.println("Cohort Name: " + cohortName);
    System.out.println("Cohort Description: " + cohortDescription);
    System.out.println("Start Date: " + startDate);
    System.out.println("End Date: " + endDate);
    System.out.println("Learners: ");
    for (Learner learner : learnerList) {
      learner.displayLearnerDetails();
    }
    System.out.println("Instructors: ");
    for (Instructor instructor : instructorList) {
      instructor.displayInstructorDetails();
    }
    System.out.println("-------------------------------");
  }

  public void calculateAverageXps() {
    int totalXps = 0;
    for (Learner learner : learnerList) {
      totalXps += learner.getXp();
    }
    int averageXps = totalXps / learnerList.size();
    System.out.println("Average Xps: " + averageXps);
  }
}
