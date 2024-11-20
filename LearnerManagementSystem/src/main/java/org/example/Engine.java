package org.example;

public abstract class Engine {
  public String engineId;

  public String engineName;

  public int power;

  public Engine(String engineId, String engineName, int power) {
    this.engineId = engineId;
    this.engineName = engineName;
    this.power = power;
  }

  public String getEngineId() {
    return engineId;
  }

  public void setEngineId(String engineId) {
    this.engineId = engineId;
  }

  public String getEngineName() {
    return engineName;
  }

  public void setEngineName(String engineName) {
    this.engineName = engineName;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public abstract void displayEngineDetails();
}
