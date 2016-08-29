package io.hackangel.street.cleaner.services.impl;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.rest.pojo.OrderPojo;
import io.hackangel.street.cleaner.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.io.File;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String saveOrder(Order order) {
        String orderImageId = null;
        orderRepository.save(order);
        return order.getOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Order> getNearestOrders(double latitude, double longitude) {
        return orderRepository.findNearestOrders(latitude, longitude);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrderPojo> getAll() {
        return null;
    }
}
