package com.ecommerce.theHashed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.service.UserServices.AccountTypeService;
import com.ecommerce.theHashed.service.UserServices.CustomerRewardsService;

@RestController
@RequestMapping("api")
public class AccountTypeController {
	
	@Autowired
	AccountTypeService accountTypeService;
	
	@Autowired
	CustomerRewardsService promoService;
	
	@RequestMapping("accountType")
	public ResponseEntity<?> userAccount() {
		try {
			List<AccountType> account = accountTypeService.insertAccountType();
			return  ResponseEntity.ok(account);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("rewards")
	public ResponseEntity<?> insertPromo() {
		try {
			promoService.insertPromo();
			return  ResponseEntity.ok("success");
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
