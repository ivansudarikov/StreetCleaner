package io.hackangel.street.cleaner.controllers;

import io.angelhack.caller.Caller;
import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.rest.pojo.UserVox;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/call", method = RequestMethod.GET)
    public void startCall(@RequestParam(value = "number", defaultValue = "+79118465234") String number,
                          @RequestParam(value = "id") String id) {
        Order order = orderRepository.findByOrderId(id);
        order.setOrderStatus(Order.OrderStatus.IN_PROGRESS);
        orderRepository.save(order);
        Caller.call(number);
    }


}