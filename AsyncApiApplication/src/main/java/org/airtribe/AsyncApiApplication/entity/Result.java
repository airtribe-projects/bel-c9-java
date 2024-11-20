package org.airtribe.AsyncApiApplication.entity;

import java.util.List;


public class Result {
  public List<Measurement> products;

  public Result() {
  }

  public Result(List<Measurement> productsList) {
    products = productsList;
  }

  public List<Measurement> getMeasurementList() {
    return products;
  }

  public void setMeasurementList(List<Measurement> measurementList) {
    products = measurementList;
  }
}
