package io.angelhack.mongodb.enitites;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.geo.Point;
import org.mongodb.morphia.utils.IndexType;

/**
 * @author amylnikov
 */
@Entity
@Indexes( {
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
    private ObjectId id;

    private String imagePath;

    private String userName;

    private String phoneNumber;

    private Point position;

    private OrderStatus orderStatus;

    public enum OrderStatus {NOT_INITED,IN_PROGRESS,COMPLETED}

    public Object getId() {
        return id;
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

    public void setId(ObjectId id) {
        this.id = id;
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



