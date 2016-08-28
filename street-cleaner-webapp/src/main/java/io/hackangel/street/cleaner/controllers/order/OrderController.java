package io.hackangel.street.cleaner.controllers.order;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.response.NearestOrdersPojo;
import io.angelhack.rest.pojo.response.OrderPostResponse;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.controllers.ControllerConstants;
import io.hackangel.street.cleaner.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
        orderService.saveOrder(orderEntity, null);
        OrderPostResponse response = new OrderPostResponse();
        response.setOrderId(orderEntity.getId().toString());
        response.setStatus(Status.OK);
        return response;
    }

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<OrderPojo> getAllOrders() {
		List<OrderPojo> allOrders = orderService.getAll();
		return allOrders;
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
