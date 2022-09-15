package com.ecommerce.theHashed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.CustomerCurrency;
import com.ecommerce.theHashed.service.UserServices.CustomerCurrencyService;

@RestController
@RequestMapping("api")
public class CustomerCurrencyController {
	@Autowired
	CustomerCurrencyService customerCurrencyService;
	@RequestMapping("customerCurrency")
	public ResponseEntity<?> userCurrency() {
		try {
			List<CustomerCurrency> account = customerCurrencyService.insertCustomerCurrency();
			return  ResponseEntity.ok(account);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
