package com.ecommerce.theHashed.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.JWTConfiguration.UserPrincipal;
import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.CustomerCard;
import com.ecommerce.theHashed.pojo.CustomerCardPojo;
import com.ecommerce.theHashed.service.UserServices.CustomerCardService;

@RestController
@RequestMapping("hashedApi")
public class CustomerCardController {

	@Autowired
	CustomerCardService customerCardService;
	
	@RequestMapping("addCustomerCard")
	public ResponseEntity<?> addAccountCard(@RequestBody CustomerCardPojo customerCard) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomerCard customerAdd = customerCardService.addCustomerCard(customerCard, authentication.getId());
			return  ResponseEntity.ok(customerAdd);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("deleteCustomerCard")
	public ResponseEntity<?> deleteAccountCard(@RequestParam String customerCardId) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			customerCardService.deleteCustomerCard(customerCardId, authentication.getId());
			
			
			return  ResponseEntity.ok("Card is deleted");
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("customerCard")
	public ResponseEntity<?> accountCard() {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<CustomerCard> customerCard = customerCardService.customerCard(authentication.getId());
			if(customerCard == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
			} else {
			return  ResponseEntity.ok(customerCard);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	
	
}
