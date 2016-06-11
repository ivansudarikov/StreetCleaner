package io.hackangel.street.cleaner.services.impl;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.mongodb.repos.UserRepository;
import io.hackangel.street.cleaner.services.OrderCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@Service
public class OrderService implements OrderCreationService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Order saveOrder(String userName, File image) {
        return null;
    }
}
