package com.ecommerce.theHashed.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.theHashed.controller.RequestPojo.ApiResponse;
import com.ecommerce.theHashed.model.Product;
import com.ecommerce.theHashed.service.UserServices.ProductService;

@RestController
@RequestMapping("hashedApi")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping("products")
	public ResponseEntity<?> allProduct() {
		try {
			List<Product> product = productService.getAllProduct();
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
			} else {
			return  ResponseEntity.ok(product);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("productById")
	public ResponseEntity<?> productById(@RequestParam String id) {
		try {
			Optional<Product> product = productService.productById(id);
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
			} else {
			return  ResponseEntity.ok(product.get());
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("productByBrand")
	public ResponseEntity<?> productByBrand(@RequestParam String brand) {
		try {
			List<Product> product = productService.productByBrand(brand);
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found by Brand");
			} else {
			return  ResponseEntity.ok(product);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("productsByCollection")
	public ResponseEntity<?> allProductByCollection(@RequestParam String collectionName) {
		try {
			List<Product> product = productService.getAllProductByCollection(collectionName);
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
			} else {
			return  ResponseEntity.ok(product);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("productsBySubCollection")
	public ResponseEntity<?> allProductBySubCollection(@RequestParam String subCollectionName) {
		try {
			List<Product> product = productService.getAllProductBySubCollection(subCollectionName);
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
			} else {
			return  ResponseEntity.ok(product);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	@RequestMapping("addProducts")
	public ResponseEntity<?> addProduct() {
		try {
			List<Product> product = productService.getAddProduct();
			if(product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
			} else {
			return  ResponseEntity.ok(product);
			}
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}
