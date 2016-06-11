package io.hackangel.street.cleaner.controllers;

import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.pojo.request.User;
import io.angelhack.rest.status.Status;
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

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public SimpleResponse user(@RequestBody User user) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        simpleResponse.setMessage(user.getUserName());
        return simpleResponse;
    }

}
