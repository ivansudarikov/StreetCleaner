package io.hackangel.street.cleaner.controllers;

import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.pojo.request.User;
import io.angelhack.rest.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public SimpleResponse user(@RequestBody User user) {
        io.angelhack.mongodb.enitites.User foundUser = userRepository.findOneByName(user.getUserName());
        Status status;
        String message;
        if (foundUser != null) {
            status = Status.OK;
            message = "User exists: " + foundUser.getUserName();
        } else {
            status = Status.ERROR;
            message = String.format("User %s not found", foundUser.getUserName());
        }
        return getSimpleResponse(status, message);
    }

    private SimpleResponse getSimpleResponse(Status status, String message) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(status);
        simpleResponse.setMessage(message);
        return simpleResponse;
    }

}
