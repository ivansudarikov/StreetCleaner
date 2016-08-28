package io.angelhack.rest.pojo.response;

import io.angelhack.rest.pojo.OrderPojo;

import java.util.List;

/**
 * Created by amylniko on 26.08.2016.
 */
public class NearestOrdersPojo {

    List<OrderPojo> orders;

    public List<OrderPojo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderPojo> orders) {
        this.orders = orders;
    }
}
