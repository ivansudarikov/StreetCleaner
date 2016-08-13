package io.angelhack.mongodb.enitites;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by sasha_000 on 10.06.2016.
 */
public class Order {


    public Order() {
    }

    public Order(String orderId, String imagePath, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.imagePath = imagePath;
        this.orderStatus = orderStatus;
    }

    @Id
    private String orderId;

    private String imagePath;

    private String userName;

    private String phoneNumber;

    private String latitude;

    private String longitude;

    private OrderStatus orderStatus;

    public enum OrderStatus {NOT_INITED,IN_PROGRESS,COMPLETED}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}



