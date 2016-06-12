package io.angelhack.mongodb.repos.impl;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.mongodb.repos.UserRepository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan
 * @since 11.06.2016
 */
public class DummyRepositories implements OrderRepository, UserRepository {

    private Map<String, User> dummyUsers = new HashMap<>();
    private Map<String, List<Order>> dummyOrders = new HashMap<>();

    @Override
    public Order findByOrderId(String id) {
        return null;
    }

    @Override
    public User findOneByName(String name) {
        return dummyUsers.get(name);
    }

    @Override
    public void save(Order order) {
        Assert.notNull(order, "can't save null order");
        User user = dummyUsers.get(order.getUserName());
        List<Order> ordersByUser = dummyOrders.get(user.getUserName());
        if (ordersByUser == null) {
            ordersByUser = new ArrayList<>();
            dummyOrders.put(user.getUserName(), ordersByUser);
        }
        ordersByUser.add(order);
    }

    public void onStartUp() {
        dummyUsers.put("admin", createUser("admin", "admin"));
        dummyUsers.put("max", createUser("max", "max"));
    }

    private User createUser(String name, String password) {
        return new User(name, password);
    }
}
