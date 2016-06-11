package io.hackangel.street.cleaner.controllers;

import io.angelhack.rest.pojo.Greeting;
import io.angelhack.rest.pojo.UserVox;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class StreetCleanerController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/startScenarios", method = RequestMethod.GET)
    public void greeting() {
        RestTemplate restTemplate = new RestTemplate();
        String loginURL = "https://api.voximplant.com/platform_api/Logon/?account_email=sevostyanovg.d@gmail.com&account_password=Uthvfy1q2w3e";
        ResponseEntity<UserVox> response =
                restTemplate.getForEntity(loginURL, UserVox.class);
        System.out.println(response);
    }

}