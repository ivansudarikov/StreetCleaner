package io.hackangel.street.cleaner.controllers.order;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.SimpleResponse;
import io.hackangel.street.cleaner.controllers.ControllerConstants;
import io.hackangel.street.cleaner.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by amylniko on 09.08.2016.
 */
@RestController
@RequestMapping(value = ControllerConstants.ORDER_CONTROLLER_PATH)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier(value = "orderPojoToOrderEntityConverter")
    private Converter<OrderPojo, Order> converter;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public SimpleResponse postOrder(@RequestParam("file") MultipartFile file, OrderPojo order) {
        if(file!=null) {

        }
        Order orderEntrity = converter.convert(order);


        return null;
    }

}
