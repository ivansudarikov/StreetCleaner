package io.hackangel.street.cleaner.controllers;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.rest.pojo.response.UserInformation;
import io.angelhack.rest.pojo.response.UserPojo;
import io.angelhack.rest.pojo.response.UserResponse;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.security.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * Controller for registration (not secured).
 *
 * @author amylnikov
 * @since 1.0
 *
 */
@RestController
@RequestMapping("")
public class RegisterController {

    /**
     * Converter from request param to DB entity.
     */
    @Autowired
    @Qualifier(value = "userPojoToEntityMapper")
    private Converter<UserPojo,User> userPojoToEntityConverter;

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
     * Grants user permission to current context and creates session information about user.
     */
    private void grantUserPermission(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Authorities.USER.name()));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword(),authorities);
        token.setDetails(getDetails(user));
        SecurityContextHolder.getContext().
                setAuthentication(token);
    }

    /**
     * Creates UserInformation object for session
     * @param user user's entity whuch persists in DB
     * @return Session user's information
     */
    private UserInformation getDetails(User user) {
        UserInformation userInformation = new UserInformation();
        userInformation.setName(user.getName());
        userInformation.setUserName(user.getLogin());
        userInformation.setBirth(user.getBirth());
        userInformation.setImageId(0);
        userInformation.setEmail(user.getEmail());
        userInformation.setSurName(user.getSurName());
        return userInformation;
    }

}
