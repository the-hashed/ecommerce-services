package com.ecommerce.theHashed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.JWTConfiguration.UserPrincipal;
import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.CartDetail;
import com.ecommerce.theHashed.pojo.CartDetailPojo;
import com.ecommerce.theHashed.service.UserServices.CartDetailsService;

@RestController
@CrossOrigin
@RequestMapping("hashedApi")
public class CartDetailsController {

	@Autowired
	CartDetailsService cartDetailsService;

	@RequestMapping("addCart")
	public ResponseEntity<?> addCart(@RequestBody CartDetailPojo cartDetailPojo) {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			CartDetail cartDetails = cartDetailsService.addCustomerCart(cartDetailPojo, authentication.getId());
			return ResponseEntity.ok(cartDetails);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

	@RequestMapping("updateCart")
	public ResponseEntity<?> updateCart(@RequestBody CartDetailPojo cartDetailPojo) {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			CartDetail customerAdd = cartDetailsService.updateCustomerCart(cartDetailPojo, authentication.getId());
			return ResponseEntity.ok(customerAdd);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	//@CrossOrigin(origins = "https://thehashedbackend.herokuapp.com")
	@RequestMapping("deleteCart")
	public ResponseEntity<?> deleteCart(@RequestParam String cartId) {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			cartDetailsService.deleteCustomerCart(cartId, authentication.getId());

			return ResponseEntity.ok("Cart is deleted");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

	@RequestMapping("cartDetails")
	public ResponseEntity<?> accountCart() {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			List<CartDetail> cartDetails = cartDetailsService.customerCart(authentication.getId());
			if (cartDetails == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caart not found");
			} else {
				return ResponseEntity.ok(cartDetails);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

	@RequestMapping("countCartQuantity")
	public ResponseEntity<?> countAccountCart() {
		try {
			UserPrincipal authentication = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			Integer cartDetails = cartDetailsService.countAccountCart(authentication.getId());
			if (cartDetails == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found");
			} else {
				return ResponseEntity.ok(cartDetails);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

}
