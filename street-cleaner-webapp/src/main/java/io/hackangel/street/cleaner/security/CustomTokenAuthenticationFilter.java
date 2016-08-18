package io.hackangel.street.cleaner.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by amylniko on 11.07.2016.
 */
public class CustomTokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public final String HEADER_SECURITY_TOKEN = "AuthToken";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String userName = request.getHeader("username");
        String pass = request.getHeader("password");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, pass);
        setDetails(request, token);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        //UserDetails userDetails = new UserDetails();
        //authRequest.setDetails(new UserDetails());
    }

    private String getJSessionId(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
