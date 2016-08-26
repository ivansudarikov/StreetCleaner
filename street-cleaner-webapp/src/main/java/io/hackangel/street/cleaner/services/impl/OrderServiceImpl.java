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
 *
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
    public Object saveOrder(Order order, File image) {
        String orderImageId = null;
        if(image!=null) {
            orderImageId = saveOrderImage(image);
        }
        order.setImagePath(orderImageId);
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * Saves order's image to disk and return its path.
     * @param orderImgae order image
     * @return image's path
     */
    private String saveOrderImage(File orderImgae) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Order> getNearestOrders(double latitude, double longitude) {
        return orderRepository.findNearestOrders(latitude,longitude);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrderPojo> getAll() {
        return null;
    }
}
