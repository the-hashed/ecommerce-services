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
import com.ecommerce.theHashed.model.CustomerFavourite;
import com.ecommerce.theHashed.pojo.CustomerFavouritePojo;
import com.ecommerce.theHashed.service.UserServices.CustomerFavouriteService;

@RestController
@RequestMapping("hashedApi")
public class CustomerFavouriteController {

	@Autowired
	CustomerFavouriteService customerFavouriteService;
	
	@RequestMapping("addCustomerFavourite")
	public ResponseEntity<?> addCustomerFavourite(@RequestBody CustomerFavouritePojo customerFavouritePojo) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomerFavourite customerFavourite = customerFavouriteService.addCustomerFavourite(customerFavouritePojo, authentication.getId());
			return  ResponseEntity.ok(customerFavourite);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("deleteCustomerFavourite")
	public ResponseEntity<?> deleteCustomerFavourite(@RequestParam String product) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			customerFavouriteService.deleteCustomerCard(authentication.getId(), product);
			
			
			return  ResponseEntity.ok("CustomerFavourite is deleted");
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("customerFavourite")
	public ResponseEntity<?> customerFavourite() {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<CustomerFavourite> customerFavourite = customerFavouriteService.customerFavourite(authentication.getId());
			if(customerFavourite == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Favourites not found");
			} else {
			return  ResponseEntity.ok(customerFavourite);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
