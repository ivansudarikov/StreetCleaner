package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.rest.pojo.OrderPojo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * This is {@link OrderPojo} to {@link Order} object.
 *
 * @author Ivan
 * @since 28.08.2016
 */
@Component(value = "orderPojoToOrderEntityConverter")
public class OrderPojoToOrderConverter implements Converter<OrderPojo, Order> {
    @Override
    public Order convert(OrderPojo orderPojo) {
        // TODO Actual conversion
        return null;
    }
}
