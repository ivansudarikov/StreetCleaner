package io.hackangel.street.cleaner.services;


import io.angelhack.mongodb.enitites.Order;

import java.io.File;

/**
 * @author Ivan
 * @since 11.06.2016
 */
public interface OrderCreationService {

    Order saveOrder(String userName, File image);
}
