package com.ecommerce.theHashed.service.UserServices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.OrderItem;
import com.ecommerce.theHashed.pojo.OrderItemPojo;

@Service
public interface OrderItemService {

	OrderItem addOrderItem(OrderItemPojo orderItemPojo, String userId) throws Exception;

	void deleteOrderItem(String userId);

	Optional<OrderItem> orderItem(String userId);

	void deleteOrderItemById(String id);



}
