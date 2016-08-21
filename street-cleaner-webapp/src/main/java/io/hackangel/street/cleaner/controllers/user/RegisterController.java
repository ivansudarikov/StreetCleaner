package io.hackangel.street.cleaner.controllers;

import org.springframework.beans.factory.annotation.Qualifier;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.rest.pojo.response.UserPojo;
import io.angelhack.rest.pojo.response.UserResponse;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.security.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amylniko on 26.07.2016.
 */
@RestController
@RequestMapping(value = ControllerConstants.USER_CONTROLLER_PATH)
public class RegisterController {

    /**
     * Converter from request param to DB entity.
     */
    @Autowired
    @Qualifier(value = "userPojoToEntityMapper")
    private Converter<UserPojo, User> userPojoToEntityConverter;

    @Autowired
    @Qualifier(value = "userPojoValidator")
    private Validator userPojoValidator;

    @Autowired
    private UserRepository userRepository;

    /**
     * Register new user (persist in DB and provide permissions).
     * @return operation status
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public UserResponse register(@RequestBody UserPojo user) {
        //TODO validate request
        User newUser =userPojoToEntityConverter.convert(user);

        //TODo Set information to user
        userRepository.save(newUser);
        grantUserPermission(newUser);
        return createSuccessUserResponse();
    }

    public UserResponse createSuccessUserResponse() {
        UserResponse userResponse = new UserResponse();
        userResponse.setStatus(Status.OK);
        return userResponse;
    }

    /**
     * Grants user permission to current context
     */
    private void grantUserPermission(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Authorities.USER.name()));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), authorities);
        authentication.setDetails(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
