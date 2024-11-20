package org.airtribe.AsyncApiApplication.controller;

import org.airtribe.AsyncApiApplication.entity.Result;
import org.airtribe.AsyncApiApplication.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class HelloController {

  @Autowired
  public ApiService _apiService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello world!";
  }

  @GetMapping("/products")
  public Result products() {
    return _apiService.getProducts();
  }

  @GetMapping("/productsAsync")
  public Mono<Result> productsAsync() {
    return _apiService.getProductsAsync();
  }


  @GetMapping("/helloClient")
  public String helloClient() {
    return _apiService.clientHello();
  }

  @GetMapping("/productsSyncWebClient")
  public Result productsSyncWebClient() {
    return _apiService.getProductsSyncWebClient();
  }

}
