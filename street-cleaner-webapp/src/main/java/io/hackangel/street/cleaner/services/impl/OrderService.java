package io.hackangel.street.cleaner.services.impl;

import io.angelhack.caller.Caller;
import io.angelhack.caller.Recognition;
import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.mongodb.repos.UserRepository;
import io.hackangel.street.cleaner.geotag.GeoTag;
import io.hackangel.street.cleaner.geotag.JpegGeoTagReader;
import io.hackangel.street.cleaner.services.OrderCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@Service
public class OrderService implements OrderCreationService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;
    private JpegGeoTagReader jpegGeoTagReader = new JpegGeoTagReader();

    @Override
    public Order saveOrder(String userName, File image) {
        String phoneNumber;
        try {
            phoneNumber = Recognition.recognize(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        phoneNumber = "89118465234";
        System.out.println(("Актуальный номер:" + phoneNumber));
        Order order = new Order();
        order.setUserName(userName);
        order.setImagePath(image.getPath());
        order.setOrderStatus(Order.OrderStatus.NOT_INITED);
        order.setPhoneNumber(phoneNumber);

        GeoTag geoTag = readGeoTag(image);
        if (geoTag != null) {
            // geoTag.getLatitude
            order.setLatitude("59.979984");
            // geoTag.getLongitude
            order.setLongitude("30.326916");
        }
        System.out.println(order);
        orderRepository.save(order);
        order.setOrderStatus(Order.OrderStatus.IN_PROGRESS);
        Caller.call(order.getPhoneNumber());
        return order;
    }

    @Override
    public List getAllOrders() {
        return orderRepository.getAllOrder();
    }

    private GeoTag readGeoTag(File image) {
        GeoTag geoTag = null;
        try {
            geoTag = jpegGeoTagReader.readMetadata(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geoTag;
    }
}
