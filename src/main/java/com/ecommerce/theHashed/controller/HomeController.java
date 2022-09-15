package com.ecommerce.theHashed.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.Product;
import com.ecommerce.theHashed.service.UserServices.HomeService;

@RestController
@RequestMapping("hashedApi")
public class HomeController {
	
	@Autowired
	HomeService homeService;

	@RequestMapping("latestProducts")
	public ResponseEntity<?> latestProduct() {
		try {
			List<Product> product = homeService.getLatestProduct();
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
			} else {
			return  ResponseEntity.ok(product);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("collectionsName")
	public ResponseEntity<?> Collections() {
		try {
			List<String> collection = homeService.getCollectionsName();
			if(collection == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Collections not found");
			} else {
			return  ResponseEntity.ok(collection);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("allCollection")
	public ResponseEntity<?> allCollections() {
		try {
			Map<String, Set<String>> collection = homeService.getAllCollection();
			if(collection == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Collections not found");
			} else {
			return  ResponseEntity.ok(collection);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
		
}
