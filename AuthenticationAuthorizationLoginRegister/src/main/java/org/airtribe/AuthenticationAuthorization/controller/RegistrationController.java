package org.airtribe.AuthenticationAuthorization.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User register(@Valid @RequestBody UserModel user, HttpServletRequest request) {
    User storedUser = userService.register(user);
    String token = UUID.randomUUID().toString();
    String applicationUrl = getApplicationUrl(request) + "/verifyRegistration?token=" + token;
    userService.createVerificationToken(storedUser, token);
    System.out.println("Verification token created for user: " + storedUser.getEmail());
    System.out.println("Verification url: " + applicationUrl);
    return storedUser;
  }

  @PostMapping("/verifyRegistration")
  public String verifyRegistration(@RequestParam String token) {
    boolean isValid = userService.validateTokenAndEnableUser(token);
    if (!isValid) {
      return "Invalid token";
    }
    return "User enabled successfully";
  }

  @PostMapping("/signin")
  public String login(@RequestParam String email, @RequestParam String password) {
    return userService.login(email, password);
  }

  private String getApplicationUrl(HttpServletRequest request) {
    return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
  }

  @GetMapping("/api/hello")
  public String hello() {
    return "Hello from auth";
  }


  @GetMapping("/find")
  public List<User> findUser(@RequestParam String email) {
    return userService.getUsersByName(email);
  }
}