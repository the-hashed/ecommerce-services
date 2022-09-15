package com.ecommerce.theHashed.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.JWTConfiguration.UserPrincipal;
import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.service.UserServices.UserService;

@RestController
@RequestMapping("hashedApi")
public class CustomerAccountController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	public String currentUserName(HttpServletRequest request) {
		UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext()
			    .getAuthentication().getPrincipal();

			String u =  authentication.getId();
			return u;
			
	}
	
	@RequestMapping("accountSummary")
	public ResponseEntity<?> userAccountSummary(@RequestBody HashMap<String,String> summaryRequest) {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomerAccount user = userservice.updateCustomerAccountSummary(summaryRequest, authentication.getId());
			return  ResponseEntity.ok(user);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("account")
	public ResponseEntity<?> userAccount() {
		try {
			UserPrincipal authentication = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CustomerAccount user = userservice.customerAccount(authentication.getId());
			return  ResponseEntity.ok(user);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	
	
}
