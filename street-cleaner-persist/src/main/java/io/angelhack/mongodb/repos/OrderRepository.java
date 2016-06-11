package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.Order;

/**
 * Created by sasha_000 on 10.06.2016.
 */
public interface OrderRepository {

    Order findByOrderId(String id);

    void save(Order order);

}
