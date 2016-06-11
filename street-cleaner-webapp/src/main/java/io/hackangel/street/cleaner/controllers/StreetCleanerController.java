package io.hackangel.street.cleaner.controllers;

import io.angelhack.caller.Caller;
import io.angelhack.rest.pojo.UserVox;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class StreetCleanerController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public List<UserVox> test() {
        UserVox userVox = new UserVox();
        userVox.setAccount_email("test@test.ru");
        userVox.setAccount_id(10L);
        List<UserVox> userVoxList = new ArrayList<>();
        userVoxList.add(userVox);
        return userVoxList;
    }

    @RequestMapping(value = "/call", method = RequestMethod.GET)
    public void startCall(@RequestParam(value = "number", defaultValue = "+79118465234") String number) {
        Caller.call(number);
    }


}