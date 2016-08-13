package io.angelhack.rest.pojo.response;

import io.angelhack.rest.status.Status;

/**
 * Created by amylniko on 09.08.2016.
 */
public class OrderPostResponse {

    Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
