package com.ecommerce.theHashed.service.UserServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.Order;
import com.ecommerce.theHashed.pojo.OrderPojo;

@Service
public interface OrderService {

	Order addOrder(OrderPojo orderPojo, String userId) throws Exception;

	List<Order> orderList(String userId);

	Optional<Order> order(String userId);

}
