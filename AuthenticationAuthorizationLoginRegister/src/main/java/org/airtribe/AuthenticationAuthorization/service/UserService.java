package org.airtribe.AuthenticationAuthorization.service;

import jakarta.transaction.Transactional;
import java.util.List;
import org.airtribe.AuthenticationAuthorization.JwtUtil.JwtUtil;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.entity.VerificationToken;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.repository.UserRepository;
import org.airtribe.AuthenticationAuthorization.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository _userRepository;

  @Autowired
  private PasswordEncoder _passwordEncoder;

  @Autowired
  private VerificationTokenRepository _verificationTokenRepository;

  public User register(UserModel user) {
    User databaseUser = new User();
    databaseUser.setEmail(user.getEmail());
    databaseUser.setName(user.getName());
    databaseUser.setPassword(_passwordEncoder.encode(user.getPassword()));
    databaseUser.setRole("USER");
    databaseUser.setEnabled(false);
    return _userRepository.save(databaseUser);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = _userRepository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), List.of(new SimpleGrantedAuthority(user.getRole())));
  }

  public void createVerificationToken(User storedUser, String token) {
    VerificationToken verificationToken = new VerificationToken(token, storedUser);
    _verificationTokenRepository.save(verificationToken);
  }

  public boolean validateTokenAndEnableUser(String tokenValue) {
    VerificationToken token = _verificationTokenRepository.findByToken(tokenValue);
    if(token == null) {
      return false;
    }
    if (token.getExpirationDate().getTime() < System.currentTimeMillis()) {
      return false;
    }

    User user = token.getUser();
    if (!user.isEnabled()) {
      user.setEnabled(true);
      _userRepository.save(user);
      _verificationTokenRepository.delete(token);
    } else {
      _verificationTokenRepository.delete(token);
      return false;
    }

    return true;
  }

  public String login(String email, String password) {
    boolean isAuthenticated = authenticateUser(email, password);
    if (isAuthenticated) {
      return JwtUtil.generateToken(email);
    } else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  public boolean authenticateUser(String email, String password) {
    User fetchedUser = _userRepository.findByEmail(email);

    if (fetchedUser == null || !fetchedUser.isEnabled()) {
      return false;
    }

    boolean doesPasswordMatch = _passwordEncoder.matches(password, fetchedUser.getPassword());
    if (!doesPasswordMatch) {
      return false;
    }


    UserDetails userDetails = loadUserByUsername(email);
    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

    SecurityContextHolder.getContext().setAuthentication(authentication);

    return true;

  }

  public List<User> getUsersByName(String email) {
    return _userRepository.findUserByEmailUnsafe(email);
  }
}