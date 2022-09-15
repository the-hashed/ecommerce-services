package com.ecommerce.theHashed.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.JWTConfiguration.UserPrincipal;
import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.Order;
import com.ecommerce.theHashed.pojo.OrderPojo;
import com.ecommerce.theHashed.service.UserServices.OrderService;

@RestController
@CrossOrigin
@RequestMapping("hashedApi")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("addOrder")
	public ResponseEntity<?> addOrder(@RequestBody OrderPojo orderPojo) throws Exception {
			
			try {
				UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal();
				Order order = orderService.addOrder(orderPojo, authentication.getId());
				return  ResponseEntity.ok(order);
			}catch(Exception e ) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
			}
	}

	@RequestMapping("orderList")
	public ResponseEntity<?> OrderList() {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			List<Order> Order = orderService.orderList(authentication.getId());
			if (Order == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
			} else {
				return ResponseEntity.ok(Order);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("order")
	public ResponseEntity<?> Order() {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			Optional<Order> Order = orderService.order(authentication.getId());
			if (Order == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
			} else {
				return ResponseEntity.ok(Order);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
