package org.example;

public class HybridEngine extends Engine {

  public HybridEngine(String engineId, String engineName, int power) {
    super(engineId, engineName, power);
  }

  public void displayEngineDetails() {
    System.out.println("HybridEngine{" + "engineId='" + engineId + '\'' + '}');
  }
}
