package edu.miu.cs545.waa.util;

import edu.miu.cs545.waa.constant.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * JwtUtils Class which contains utility function related to json web token
 *
 * @version 1.0.0
 */
@Component
public class JwtUtils {

  private static List<String> jwtTokens = new ArrayList<>();

  /**
   * Method add token to list
   *
   * @param token String token value is passed
   */
  public static void addToken(String token) {
    jwtTokens.add(token);
  }

  /**
   * Method check token validity
   *
   * @param token String token value
   * @return boolean
   */
  public static boolean isValidToken(String token) {
    return jwtTokens.contains(token);
  }

  /**
   * Method Generate and return Jwt Token with validity period
   *
   * @param authentication authenticated User
   * @param rememberMe     Remember Me Parameter
   * @return jwtToken
   */
  public String generateJwtToken(Authentication authentication, boolean rememberMe) {

    long validityDay = rememberMe ? 864000000 : 36000000;
    List<String> roles = authentication.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());
    byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

    String token = Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
            .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
            .setIssuer(SecurityConstants.TOKEN_ISSUER)
            .setAudience(SecurityConstants.TOKEN_AUDIENCE)
            .setSubject(authentication.getName())
            .setExpiration(new Date(System.currentTimeMillis() + validityDay))
            .claim("rol", roles)
            .compact();

    return SecurityConstants.TOKEN_PREFIX + token;
  }

  /**
   * Method remove token form list
   *
   * @param token
   */
  public static void removeToken(String token) {
    if (isValidToken(token)) {
      jwtTokens.remove(token);
    }
  }

  /**
   * Method getToken from request header
   *
   * @param request Takes request
   * @return header as a string
   */
  public static String getToken(HttpServletRequest request) {
    return request.getHeader(SecurityConstants.TOKEN_HEADER);
  }

}
