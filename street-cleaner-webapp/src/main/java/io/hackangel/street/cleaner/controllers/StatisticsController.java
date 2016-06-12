package io.hackangel.street.cleaner.controllers;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.response.Statistics;
import io.hackangel.street.cleaner.services.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class StatisticsController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public Statistics statistics(@RequestParam(value = "user", required = false) String userName) {
        return null;
    }

    @RequestMapping(value = "/allOrders", method = RequestMethod.GET)
    public Map<String, List<Order>> getAllOrders() {
        return orderService.getAllOrders();
    }

}
