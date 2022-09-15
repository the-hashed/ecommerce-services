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
import com.ecommerce.theHashed.model.CustomerAddress;
import com.ecommerce.theHashed.pojo.CustomerAddressPojo;
import com.ecommerce.theHashed.service.UserServices.CustomerAddressService;

@RestController
@RequestMapping("hashedApi")
public class CustomerAddressController {

	@Autowired
	CustomerAddressService customerAddressService;
	
	@RequestMapping("addCustomerAddress")
	public ResponseEntity<?> addAccountAddress(@RequestBody CustomerAddressPojo customerAddress) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomerAddress customerAdd = customerAddressService.addCustomerAccountSummary(customerAddress, authentication.getId());
			return  ResponseEntity.ok(customerAdd);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("updateAccountAddress")
	public ResponseEntity<?> updateAccountAddress(@RequestBody CustomerAddressPojo customerAddressPojo) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomerAddress customerAdd = customerAddressService.updateCustomerAccountSummary(customerAddressPojo, authentication.getId());
			return  ResponseEntity.ok(customerAdd);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("deleteAccountAddress")
	public ResponseEntity<?> deleteAccountAddress(@RequestParam String customerAddressId) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			customerAddressService.deleteCustomerAccountSummary(customerAddressId, authentication.getId());
			
			
			return  ResponseEntity.ok("Address is deleted");
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("accountAddress")
	public ResponseEntity<?> accountAddress() {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<CustomerAddress> customerAdd = customerAddressService.customerAccountSummary(authentication.getId());
			if(customerAdd == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
			} else {
			return  ResponseEntity.ok(customerAdd);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	
	
}
