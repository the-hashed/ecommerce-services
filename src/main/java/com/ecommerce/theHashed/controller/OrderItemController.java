package com.ecommerce.theHashed.controller;

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
import com.ecommerce.theHashed.model.OrderItem;
import com.ecommerce.theHashed.pojo.OrderItemPojo;
import com.ecommerce.theHashed.service.UserServices.OrderItemService;

@RestController
@CrossOrigin
@RequestMapping("hashedApi")
public class OrderItemController {

	@Autowired
	OrderItemService orderIteamService;

	@RequestMapping("addOrderItem")
	public ResponseEntity<?> addOrderItem(@RequestBody OrderItemPojo orderItemPojo) {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			OrderItem orderItem = orderIteamService.addOrderItem(orderItemPojo, authentication.getId());
			return  ResponseEntity.ok(orderItem);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

	@RequestMapping("deleteOrderItem")
	public ResponseEntity<?> deleteOrderItem() {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			orderIteamService.deleteOrderItem(authentication.getId());

			return ResponseEntity.ok("OrderItem is deleted");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

	@RequestMapping("orderItem")
	public ResponseEntity<?> orderItem() {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			Optional<OrderItem> orderItem = orderIteamService.orderItem(authentication.getId());
			if (orderItem == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caart not found");
			} else {
				return ResponseEntity.ok(orderItem.get());
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
