package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.OrderStatus;
import io.angelhack.mongodb.enitites.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.geo.GeoJson;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author amylniko
 */
@Repository
public class OrderRepository extends MongoRepository<Order,ObjectId> {

    public OrderRepository() {
        super(Order.class);
    }

    public Order findByOrderId(String id) {
        return find(new ObjectId(id));
    }

    public List<Order> findNearestOrders(double latitude, double longitude) {
        return datastore.find(classType).field("position").near(GeoJson.point(latitude,longitude),10000).field("orderStatus").equal(OrderStatus.IN_PROGRESS.toString()).asList();
    }

    public void removeUserFromOrder(User user, Order order) {
        UpdateOperations<Order> updateOps = datastore.createUpdateOperations(Order.class).removeAll("subscribedUsers", user);
        datastore.update(order,updateOps);
    }

}
