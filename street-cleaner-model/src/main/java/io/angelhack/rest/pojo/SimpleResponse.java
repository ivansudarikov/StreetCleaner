package io.angelhack.rest.pojo;

import io.angelhack.rest.status.Status;

/**
 * @author Ivan
 * @since 11.06.2016
 */
public class SimpleResponse {

    private Status status;
    private String message;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
