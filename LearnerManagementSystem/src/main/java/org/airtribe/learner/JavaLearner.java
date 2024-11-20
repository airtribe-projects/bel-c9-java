package org.airtribe.learner;

public class JavaLearner extends Learner {
  private Integer javaExperience;

  private Integer javaProjects;

  public JavaLearner(String leanerId, String learnerName, int xp, Integer javaExperience, Integer javaProjects) {
    super(leanerId, learnerName, xp);
    this.javaExperience = javaExperience;
    this.javaProjects = javaProjects;
  }

  public Integer getJavaExperience() {
    return javaExperience;
  }

  public void setJavaExperience(Integer javaExperience) {
    this.javaExperience = javaExperience;
  }

  public Integer getJavaProjects() {
    return javaProjects;
  }

  public void setJavaProjects(Integer javaProjects) {
    this.javaProjects = javaProjects;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("JavaLearner{" + "learnerId='" + getLeanerId() + '\'' + ", learnerName='" + getLearnerName() + '\'' + ", xp=" + getXp() + ", javaExperience=" + javaExperience + ", javaProjects=" + javaProjects + '}');
  }
}
