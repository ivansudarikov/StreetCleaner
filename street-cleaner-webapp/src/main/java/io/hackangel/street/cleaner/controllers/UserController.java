package io.hackangel.street.cleaner.controllers;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserPojo;
import io.angelhack.rest.pojo.response.UserResponse;
import io.angelhack.rest.pojo.response.UserInformationResponse;
import io.angelhack.rest.status.Status;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Controller for user operations, such as get information (name, email, etc.),
 * update user information, upload new order.
 *
 * @author Ivan
 * @author Aleksandr Mylnikov
 * @since 11.06.2016
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {

    /**
     *
     */
    @Qualifier(value = "userPojoToEntityMapper")
    Converter<User,UserPojo> userEntityToPojoConverter;

    /**
     * Gets information about user (name, surname etc.).
     *
     * NOTE! No user id must be sended, because we can get user by jsessionid.
     *
     * @return user's indormation.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public UserInformationResponse getInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
        UserPojo userPojo = userEntityToPojoConverter.convert(user);
        return userPojo;
    }

    /**
     *
     * @param status
     * @param user
     * @return
     */
    private UserResponse getUserResponse(Status status, User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setStatus(status);
        return userResponse;
    }

}
