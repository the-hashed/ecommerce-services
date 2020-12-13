package com.ecommerce.theHashed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.service.UserServices.AccountTypeService;

@RestController
@RequestMapping("api")
public class AccountTypeController {
	@Autowired
	AccountTypeService accountTypeService;
	@RequestMapping("accountType")
	public ResponseEntity<?> userLogin() {
		try {
			//TODO validation has to add for client request
			List<AccountType> account = accountTypeService.insertAccountType();
			return  ResponseEntity.ok(account);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
