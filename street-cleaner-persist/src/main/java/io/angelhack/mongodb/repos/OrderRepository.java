package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.Order;

import java.util.List;

/**
 * Created by sasha_000 on 10.06.2016.
 */
public interface OrderRepository {

    Order findByOrderId(String id);

    List<Order> findOrdersByUserName(String userName);

    void save(Order order);

}
