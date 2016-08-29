package io.angelhack.mongodb.enitites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.geo.Point;
import org.mongodb.morphia.utils.IndexType;

/**
 * @author amylnikov
 */
@Entity
@Indexes({
        @Index(fields = @Field(value = "position", type = IndexType.GEO2D))
})
public class Order {

    public Order() {
    }

    public Order(String userName, String phoneNumber, Point position, OrderStatus orderStatus) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.orderStatus = orderStatus;
    }

    @Id
    private String orderId;

    private Set<String> imagePaths;

    private String userName;

    private String phoneNumber;

    private Point position;

    private OrderStatus orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public Set<String> getImagePaths() {
        if (imagePaths == null) {
            imagePaths = new HashSet<>();
        }
        return imagePaths;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setOrderId(String id) {
        this.orderId = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}



