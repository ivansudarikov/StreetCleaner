package io.angelhack.mongodb.repos.impl;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.mongodb.repos.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan
 * @since 11.06.2016
 */
public class DummyRepositories implements OrderRepository, UserRepository {

    private Map<String, User> dummyMap = new HashMap<>();

    @Override
    public Order findByOrderId(String id) {
        return null;
    }

    @Override
    public User findOneByName(String name) {
        return dummyMap.get(name);
    }

    @Override
    public void save(Order order) {
    }

    public void onStartUp() {
        dummyMap.put("admin", createUser("admin", "admin"));
        dummyMap.put("max", createUser("max", "max"));
    }

    private User createUser(String name, String password) {
        return new User(name, password);
    }
}
