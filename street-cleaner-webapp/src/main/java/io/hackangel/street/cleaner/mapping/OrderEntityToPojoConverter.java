package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.OrderPojo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by amylniko on 26.08.2016.
 */
@Component(value = "orderEntityToPojoConverter")
public class OrderEntityToPojoConverter implements Converter<Order, OrderPojo> {
    @Override
    public OrderPojo convert(Order order) {
        return null;
    }
}
