package io.hackangel.street.cleaner.controllers.order;

import java.util.List;
import java.util.stream.Collectors;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.CommentPojo;
import io.angelhack.rest.pojo.OrderStatusPojo;
import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.pojo.response.UserInformation;
import io.hackangel.street.cleaner.Util.SimpleResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.response.NearestOrdersPojo;
import io.angelhack.rest.pojo.response.OrderPostResponse;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.controllers.ControllerConstants;
import io.hackangel.street.cleaner.services.OrderService;


/**
 * @author amylniko
 */
@RestController
@RequestMapping(value = ControllerConstants.ORDER_CONTROLLER_PATH)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier(value = "orderEntityToPojoConverter")
    private Converter<Order, OrderPojo> orderEntityToPojoConverter;

    @Autowired
    @Qualifier(value = "orderPojoToEntityConverter")
    private Converter<OrderPojo, Order> orderPojoToEntityConverter;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public OrderPostResponse postOrder(@RequestBody OrderPojo order) {
        Order orderEntity = orderPojoToEntityConverter.convert(order);
        orderService.saveOrder(orderEntity);
        OrderPostResponse response = new OrderPostResponse();
        response.setOrderId(orderEntity.getOrderId());
        response.setStatus(Status.OK);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<OrderPojo> getAllOrders() {
        List<OrderPojo> allOrders = orderService.getAll();
        return allOrders;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{orderId}")
    public SimpleResponse finalizeOrder(@PathVariable("orderId") String orderId, OrderStatusPojo orderStatus) {
        UserInformation userInformation = (UserInformation)SecurityContextHolder.getContext().getAuthentication().getDetails();
        boolean finalizeResult = orderService.cancelOrder(orderId,userInformation);
        if(finalizeResult) {
            return SimpleResponseUtil.getGoodResponse();
        } else {
            return SimpleResponseUtil.getBadResponse();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{orderId}/subscribe")
    public SimpleResponse subscribeToOrder(@PathVariable("orderId") String orderId) {
        UserInformation userInformation = (UserInformation)SecurityContextHolder.getContext().getAuthentication().getDetails();
        boolean subsribeResult = orderService.subscribeToOrder(orderId,userInformation);
        if(subsribeResult) {
            return SimpleResponseUtil.getGoodResponse();
        } else {
            return SimpleResponseUtil.getBadResponse();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{orderId}/unsubscribe")
    public SimpleResponse unsubscribeToOrder(@PathVariable("orderId") String orderId) {
        UserInformation userInformation = (UserInformation)SecurityContextHolder.getContext().getAuthentication().getDetails();
        boolean subsribeResult = orderService.subscribeToOrder(orderId,userInformation);
        if(subsribeResult) {
            return SimpleResponseUtil.getGoodResponse();
        } else {
            return SimpleResponseUtil.getBadResponse();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{orderId}/message")
    public SimpleResponse addComment(@PathVariable("orderId") String orderId, @RequestBody CommentPojo message) {
        UserInformation userInformation = (UserInformation)SecurityContextHolder.getContext().getAuthentication().getDetails();
        boolean addCommentResult = orderService.addCommentToOrder(orderId,message.getMessage(),userInformation);
        if(addCommentResult) {
            return SimpleResponseUtil.getGoodResponse();
        } else {
            return SimpleResponseUtil.getBadResponse();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public NearestOrdersPojo getNearestOrders(@RequestParam String latitude, @RequestParam String longitude) {
        try {
            List<OrderPojo> nearestOrders = orderService.getNearestOrders(Double.parseDouble(latitude), Double.parseDouble(longitude)).stream().map(orderEntityToPojoConverter::convert).collect(Collectors.toList());
            NearestOrdersPojo response = new NearestOrdersPojo();
            response.setOrders(nearestOrders);
            return response;
        } catch (NumberFormatException nfe) {
            //TODO implement bad format pojo
            return null;
        }
    }

}
