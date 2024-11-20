package org.airtribe.ResourceServer.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceController {
  @GetMapping("/api/resource")
  public String hello(Principal principal) {
    return "hello world!";
  }
}
