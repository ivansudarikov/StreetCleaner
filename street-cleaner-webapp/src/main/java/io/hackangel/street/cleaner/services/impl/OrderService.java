package io.hackangel.street.cleaner.services.impl;

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
        String phoneNumber = Recognition.recognize(image);
        Order order = new Order();
        order.setUserName(userName);
        order.setImagePath(image.getPath());
        order.setOrderStatus(Order.OrderStatus.NOT_INITED);
        order.setPhoneNumber(phoneNumber);

        GeoTag geoTag = readGeoTag(image);
        if (geoTag != null) {
            order.setLatitude(geoTag.getLatitude() + "");
            order.setLongitude(geoTag.getLongitude() + "");
        }
        System.out.println(order);
        orderRepository.save(order);
        return order;
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
