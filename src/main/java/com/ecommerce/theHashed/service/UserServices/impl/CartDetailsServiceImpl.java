package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CartDetailsRepository;
import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.ProductRepository;
import com.ecommerce.theHashed.model.CartDetail;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.Product;
import com.ecommerce.theHashed.pojo.CartDetailPojo;
import com.ecommerce.theHashed.service.UserServices.CartDetailsService;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {
	
	@Autowired
	CustomerAccountRepository userRepo;
	
	@Autowired
	CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public CartDetail addCustomerCart(CartDetailPojo cartDetailPojo, String userId) throws Exception {
	    
		CartDetail cartDetails = new CartDetail();
		String uniqueID = UUID.randomUUID().toString();
		cartDetails.setId(uniqueID);
		cartDetails.setColor(cartDetailPojo.getColor());
		cartDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
		if(customerAccountbyId.isPresent()) {
			cartDetails.setCreatedBy(customerAccountbyId.get());
			cartDetails.setCustomerAccount(customerAccountbyId.get());
		} else {
			throw new Exception("User Not found..");
		}
		Optional<Product> productbyId = productRepo.findById(cartDetailPojo.getProduct());
		if(productbyId.isPresent()) {
			cartDetails.setProduct(productbyId.get());
		} else {
			throw new Exception("Product Not found..");
		}
		cartDetails.setQuantity(cartDetailPojo.getQuantity());
		cartDetails.setSize(cartDetailPojo.getSize());
		cartDetails.setStatus(cartDetailPojo.getStatus());
		cartDetails.setPrice(cartDetails.getProduct().getPrice() * cartDetailPojo.getQuantity());
		cartDetailsRepository.save(cartDetails);		
		return cartDetails;
	}

	@Override
	public CartDetail updateCustomerCart(CartDetailPojo cartDetailPojo, String userId) throws Exception {
		Optional<CartDetail> cartDetailbyId = cartDetailsRepository.findById(cartDetailPojo.getId());
		if(cartDetailbyId.isPresent()) {
			CartDetail cartDetails = cartDetailbyId.get();
			cartDetails.setQuantity(cartDetailPojo.getQuantity());
			cartDetails.setPrice(cartDetails.getProduct().getPrice() * cartDetailPojo.getQuantity());
			cartDetailsRepository.save(cartDetails);
			return cartDetails;
		} else {
			throw new Exception("User Not found..");
		}	
	}

	@Override
	public void deleteCustomerCart(String cartId, String userId) {
		cartDetailsRepository.deleteByIdAndCustomerAccount_Id(cartId, userId);
	}

	@Override
	public List<CartDetail> customerCart(String userId) {
		return cartDetailsRepository.findByCustomerAccount_Id(userId);	
	}

	@Override
	public Integer countAccountCart(String userId) {
		return cartDetailsRepository.findByCustomerAccount_Id(userId).stream().mapToInt(i -> i.getQuantity()).sum();	
	}

}
