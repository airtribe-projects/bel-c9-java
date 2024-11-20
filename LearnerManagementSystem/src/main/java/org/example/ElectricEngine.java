package org.example;

public class ElectricEngine extends Engine {

  public ElectricEngine(String engineId, String engineName, int power) {
    super(engineId, engineName, power);
  }

  public void displayEngineDetails() {
    System.out.println("ElectricEngine{" + "engineId='" + super.engineId + '\'' + ", engineName='" + engineName + '\'' + ", power=" + power + '}');
  }
}
