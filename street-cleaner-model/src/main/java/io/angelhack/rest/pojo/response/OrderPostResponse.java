package io.angelhack.rest.pojo.response;

import io.angelhack.rest.status.Status;

public class OrderPostResponse {

    String orderId;

    Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
