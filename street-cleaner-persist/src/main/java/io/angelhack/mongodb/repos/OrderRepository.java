package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sasha_000 on 10.06.2016.
 */
@Repository
public class OrderRepository extends MongoRepository<Order,String> {

    public OrderRepository() {
        super(Order.class);
    }

    public Order findByOrderId(String id) {
        return find(id);
    }

    public List<Order> findNearestOrders() {
        return null;
    }


}
