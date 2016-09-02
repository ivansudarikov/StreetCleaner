package io.hackangel.street.cleaner.services.impl;

import io.angelhack.mongodb.enitites.Comment;
import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.OrderStatus;
import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.response.UserInformation;
import io.hackangel.street.cleaner.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author amylnikov
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public String saveOrder(Order order) {
        String orderImageId = null;
        orderRepository.save(order);
        return order.getOrderId();
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Order> getNearestOrders(double latitude, double longitude) {
        return orderRepository.findNearestOrders(latitude, longitude);
    }

    @Override
    public boolean addCommentToOrder(String orderId, String message, UserInformation user) {
        try {
            Order order = orderRepository.findByOrderId(orderId);
            if(order==null) {
                return false;
            }
            User userEntity = userRepository.findByName(user.getUserName());
            if(userEntity==null) {
                return false;
            }
            Comment comment = new Comment();
            comment.setUser(userEntity);
            comment.setMessage(message);
            order.getComments().add(comment);
            orderRepository.save(order);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean subscribeToOrder(String orderId, UserInformation user) {
        Order order = orderRepository.findByOrderId(orderId);
        if(order==null) {
            return false;
        }
        User userEntity = userRepository.findByName(user.getUserName());
        if(userEntity==null) {
            return false;
        }
        order.getSubscribedUsers().add(userEntity);
        orderRepository.save(order);
        return true;
    }

    @Override
    public boolean unsubscribeToOrder(String orderId, UserInformation user) {
        Order order = orderRepository.findByOrderId(orderId);
        if(order==null) {
            return false;
        }
        User userEntity = userRepository.findByName(user.getUserName());
        if(userEntity==null) {
            return false;
        }
        orderRepository.removeUserFromOrder(userEntity,order);
        return true;
    }

    @Override
    public boolean cancelOrder(String orderID, UserInformation user) {
        Order order = orderRepository.findByOrderId(orderID);
        if(order==null) {
            return false;
        }
        if(!order.getUserName().equals(user.getUserName())) {
            return false;
        }
        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrderPojo> getAll() {
        return null;
    }

    @Override
    public List<Order> getUserOrders(String userName) {
        return orderRepository.getOrdersByUser(userName);
    }

    @Override
    public List<Order> getSubscribedOrders(String userName) {
        User user = userRepository.findByName(userName);
        if(user==null) {
            return new LinkedList<>();
        }
        return orderRepository.getSubscribedOrders(user);
    }
}
