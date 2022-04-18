package edu.miu.cs545.waa.controller;

import edu.miu.cs545.waa.constant.ResponseMessageConstant;
import edu.miu.cs545.waa.constant.SecurityConstants;
import edu.miu.cs545.waa.domain.dto.LoginRequest;
import edu.miu.cs545.waa.exception.InvalidUserException;
import edu.miu.cs545.waa.response.LoginResponse;
import edu.miu.cs545.waa.response.LogoutResponse;
import edu.miu.cs545.waa.service.UserService;
import edu.miu.cs545.waa.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthenticationController {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(JwtUtils jwtUtils, AuthenticationManager authenticationManager, UserService appUserService) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    /**
     * API returns Login response
     *
     * @param login current user Authentication
     * @return loginResponse
     */
    @PostMapping
    public LoginResponse returnLoginResponse(@RequestBody LoginRequest login) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getUserEmail(), login.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            String role = authentication.getAuthorities().toString();
            role = role.substring(1, role.indexOf("]"));
            String token = jwtUtils.generateJwtToken(authentication, login.isRememberMe());
            JwtUtils.addToken(token);
            return new LoginResponse(ResponseMessageConstant.SUCCESS, token, role, ResponseMessageConstant.SUCCESS_LOGIN);
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw new InvalidUserException("Invalid credentials.");

        } catch (AuthenticationException ex) {
            return new LoginResponse(ResponseMessageConstant.ERROR, "", "", ResponseMessageConstant.FAILURE_LOGIN);
        }
    }

    /**
     * Method to logout and return to login page
     *
     * @return LogoutResponse
     */
    @GetMapping("/logout")
    @PreAuthorize("hasAnyRole('" + SecurityConstants.ROLE_ADMIN + "','" + SecurityConstants.ROLE_USER + "')")
    public LogoutResponse logout(HttpServletRequest req) {
        JwtUtils.removeToken(JwtUtils.getToken(req));
        return new LogoutResponse(ResponseMessageConstant.SUCCESS, ResponseMessageConstant.SUCCESS_LOGOUT);
    }
}