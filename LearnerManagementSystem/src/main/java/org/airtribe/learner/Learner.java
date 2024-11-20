package org.airtribe.learner;

abstract public class Learner {
  private String leanerId;

  private String learnerName;

  private int xp;

  public Learner(String leanerId, String learnerName, int xp) {
    this.leanerId = leanerId;
    this.learnerName = learnerName;
    this.xp = xp;
  }

  public Learner(String leanerId, String learnerName) {
    this.leanerId = leanerId;
    this.learnerName = learnerName;
    this.xp = 0;
  }

  public String getLeanerId() {
    return leanerId;
  }

  public void setLeanerId(String leanerId) {
    this.leanerId = leanerId;
  }

  public String getLearnerName() {
    return learnerName;
  }

  public void setLearnerName(String learnerName) {
    this.learnerName = learnerName;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  public abstract void displayLearnerDetails();
}
