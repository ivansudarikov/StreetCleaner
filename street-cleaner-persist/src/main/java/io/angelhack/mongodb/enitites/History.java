package io.angelhack.mongodb.enitites;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 *
 */
@Entity
public class History {

    @Reference
    private Order order;

    private Date date;

    private String message;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
