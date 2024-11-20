package org.airtribe.ClientOAuth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
  @GetMapping("/")
  public String hello() {
    return "hello world!";
  }

  @GetMapping("/api/hello")
  public String apiHello() {
    return "api hello!";
  }
}
