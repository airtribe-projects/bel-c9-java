package org.example;

public class Car {
  private Engine _engine;

  private String _carId;

  public Car(String carId, Engine engine) {
    _carId = carId;
    engine = new ElectricEngine("E1", "Electric Engine", 100);
  }

  public Engine getEngine() {
    return _engine;
  }

  public void setEngine(Engine engine) {
    _engine = engine;
  }

  public String getCarId() {
    return _carId;
  }

  public void setCarId(String carId) {
    _carId = carId;
  }

  public void start() {
    _engine.displayEngineDetails();
    System.out.println("Car started");
  }
}
