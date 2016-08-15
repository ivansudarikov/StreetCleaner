package io.hackangel.street.cleaner.security;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amylniko on 11.07.2016.
 */
public class MongoAuthenticationManager implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token;
        User user = userRepository.findByName((String) authentication.getPrincipal());
        if(user==null || !user.getPassword().equals(authentication.getCredentials())) {
            throw new BadCredentialsException("User not found");
        }
        ((UserDetails)authentication.getDetails()).setUser(user);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Authorities.USER.authority));
        return new UsernamePasswordAuthenticationToken(((String)authentication.getPrincipal()),authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        if(aClass.equals(UsernamePasswordAuthenticationToken.class)) {
            return true;
        }
        return false;
    }
}
