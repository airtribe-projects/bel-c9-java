package org.airtribe.instructor;

public class Instructor {
  private String instructorId;

  private String instructorName;


  public Instructor(String instructorId, String instructorName) {
    this.instructorId = instructorId;
    this.instructorName = instructorName;
  }

  public String getInstructorId() {
    return instructorId;
  }

  public void setInstructorId(String instructorId) {
    this.instructorId = instructorId;
  }

  public String getInstructorName() {
    return instructorName;
  }

  public void setInstructorName(String instructorName) {
    this.instructorName = instructorName;
  }

  public void displayInstructorDetails() {
    System.out.println("Instructor ID: " + instructorId);
    System.out.println("Instructor Name: " + instructorName);
  }
}
