package io.angelhack.mongodb.enitites;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.geo.Point;

import javax.annotation.Generated;

/**
 * @author amylnikov
 */
public class Order {


    public Order() {
    }

    @Id
    private Object id;

    private String imagePath;

    private String userName;

    private String phoneNumber;

    private Point position;

    private OrderStatus orderStatus;

    public enum OrderStatus {NOT_INITED,IN_PROGRESS,COMPLETED}

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    @Override
    public String toString() {
        return "Order{" +
                ", imagePath='" + imagePath + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}



