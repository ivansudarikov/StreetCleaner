package io.angelhack.rest.pojo;

/**
 * Created by amylniko on 09.08.2016.
 */
public class OrderPojo {



    GeolocationPojo geolocation;

    OrderInfoPojo orderInfo;

    public GeolocationPojo getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(GeolocationPojo geolocation) {
        this.geolocation = geolocation;
    }

    public OrderInfoPojo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoPojo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
