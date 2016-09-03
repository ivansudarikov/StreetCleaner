package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.OrderStatus;
import io.angelhack.rest.pojo.OrderPojo;
import io.angelhack.rest.pojo.response.UserInformation;
import org.mongodb.morphia.aggregation.GeoNear;
import org.mongodb.morphia.geo.GeoJson;
import org.mongodb.morphia.geo.GeometryCollection;
import org.mongodb.morphia.geo.Point;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component(value = "orderPojoToEntityConverter")
public class OrderPojoToEntityConverter implements Converter<OrderPojo, Order> {

    @Override
    public Order convert(OrderPojo orderPojo) {
        Order orderEntity = new Order();
        orderEntity.setPosition(GeoJson.point(orderPojo.getGeolocation().getLatitude(),orderPojo.getGeolocation().getLongitude()));
        orderEntity.setOrderStatus(OrderStatus.NOT_INITED);
        orderEntity.setInformation(orderPojo.getOrderInfo().getInformation());
        orderEntity.setUserName(((UserInformation)SecurityContextHolder.getContext().getAuthentication()).getUserName());
        return orderEntity;
    }

}
