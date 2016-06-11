package io.hackangel.street.cleaner.controllers;

import io.angelhack.rest.pojo.Greeting;
import main.java.Caller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/call", method = RequestMethod.GET)
    public void startCall(@RequestParam(value = "number", defaultValue = "+79118465234") String number) {
        Caller.call(number);
    }

}