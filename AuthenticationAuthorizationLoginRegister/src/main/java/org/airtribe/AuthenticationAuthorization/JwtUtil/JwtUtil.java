package org.airtribe.AuthenticationAuthorization.JwtUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;


public class JwtUtil {
  private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  private static final long expiration = 86400000L;

  public static String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .signWith(key)
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .setIssuedAt(new Date())
        .compact();
  }
}
