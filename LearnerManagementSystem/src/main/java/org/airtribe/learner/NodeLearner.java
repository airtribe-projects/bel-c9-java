package org.airtribe.learner;

public class NodeLearner extends  Learner {
  private Integer nodeExperience;

  private Integer nodeProjects;

  public NodeLearner(String leanerId, String learnerName, int xp, Integer nodeExperience, Integer nodeProjects) {
    super(leanerId, learnerName, xp);
    this.nodeExperience = nodeExperience;
    this.nodeProjects = nodeProjects;
  }

  public Integer getNodeExperience() {
    return nodeExperience;
  }

  public void setNodeExperience(Integer nodeExperience) {
    this.nodeExperience = nodeExperience;
  }

  public Integer getNodeProjects() {
    return nodeProjects;
  }

  public void setNodeProjects(Integer nodeProjects) {
    this.nodeProjects = nodeProjects;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("NodeLearner{" + "learnerId='" + getLeanerId() + '\'' + ", learnerName='" + getLearnerName() + '\'' + ", xp=" + getXp() + ", nodeExperience=" + nodeExperience + ", nodeProjects=" + nodeProjects + '}');
  }
}
