package io.hackangel.street.cleaner.controllers;

import io.angelhack.rest.pojo.response.Statistics;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class StatisticsController {


    public Statistics statistics(@RequestParam(value = "user") String userName) {
        return null;
    }
}
