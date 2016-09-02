package io.hackangel.street.cleaner.controllers;

import org.mongodb.morphia.geo.GeoJson;
import org.mongodb.morphia.geo.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.OrderStatus;
import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.UserRepository;
import io.hackangel.street.cleaner.services.OrderService;
import io.hackangel.street.cleaner.services.impl.UserServiceImpl;


@RestController
@RequestMapping(value = "/init")
public class InitController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public void initStartUsersAndOrders() {
		User user = new User("Germa", "0000", "+79118465234");
		userRepository.save(user);
		Point point = GeoJson.point(10.0,10.0);
		Order order = new Order("German", user.getPhoneNumber(), point, OrderStatus.NOT_INITED);
		orderService.saveOrder(order);
	}
}
