package io.hackangel.street.cleaner.services;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.response.UserInformation;

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
     * Gets order by its id.
     * @param orderId order's
     * @return order if it exists, otherwise null
     */
    Order getOrderById(String orderId);

    /**
     * Gets nearest orders (in radius ~300m) by given coordinates
     *
     * @param latitude
     * @param longitude
     * @return
     */
    List<Order> getNearestOrders(double latitude, double longitude);

    /**
     *
     * @param orderId
     * @param message
     * @param user
     * @return
     */
    boolean addCommentToOrder(String orderId, String message, UserInformation user);

    /**
     *
     * @param orderId
     * @param user
     * @return
     */
    boolean subscribeToOrder(String orderId, UserInformation user);

    /**
     *
     * @param orderId
     * @param user
     * @return
     */
    boolean unsubscribeToOrder(String orderId, UserInformation user);

    /**
     *
     * @return
     */
    boolean cancelOrder(String orderID, UserInformation user);

    /**
     * Gets all orders from repository.
     * @return
     */
    List<OrderPojo> getAll();

    /**
     * Returns user orders, which he created
     * @param userName
     * @return
     */
    List<Order> getUserOrders(String userName);

    /**
     *
     * @param userName
     * @return
     */
    List<Order> getSubscribedOrders(String userName);

}
