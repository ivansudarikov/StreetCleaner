package io.hackangel.street.cleaner.services;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.OrderPojo;

import java.io.File;
import java.util.List;

/**
 * Service for processing orders.
 *
 * @author amylnikov
 */
public interface OrderService {

    /**
     * Saves order and return its ID.
     * @param order
     * @return Order ID
     */
    String saveOrder(Order order);

    /**
     *
     * @param latitude
     * @param longitude
     * @return
     */
    List<Order> getNearestOrders(double latitude, double longitude);

    /**
     *
     * @return
     */
    List<OrderPojo> getAll();

}
