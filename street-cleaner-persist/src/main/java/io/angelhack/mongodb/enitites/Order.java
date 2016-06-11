package io.angelhack.mongodb.enitites;

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

    private String orderId;

    private String imagePath;

    private String userName;

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
}



