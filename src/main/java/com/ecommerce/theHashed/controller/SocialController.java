package com.ecommerce.theHashed.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;

@RestController
@RequestMapping("api")
public class SocialController {

	   @RequestMapping("google")//post and get
	  	public ResponseEntity<?> serverStatus() {
	    	  return new ResponseEntity<>(new ApiResponse("Server is running.", ""), HttpStatus.OK);
	   }
}
