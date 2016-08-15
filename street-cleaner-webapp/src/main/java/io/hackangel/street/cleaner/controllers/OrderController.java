package io.hackangel.street.cleaner.controllers;

import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.SimpleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by amylniko on 09.08.2016.
 */
@RestController
@RequestMapping("/rest/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public SimpleResponse postOrder(@RequestParam("file") MultipartFile file, OrderPojo order) {
        return null;
    }

}
