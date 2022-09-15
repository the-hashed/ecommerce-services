package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerFavouriteRepository;
import com.ecommerce.theHashed.Repository.ProductRepository;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerFavourite;
import com.ecommerce.theHashed.model.Product;
import com.ecommerce.theHashed.pojo.CustomerFavouritePojo;
import com.ecommerce.theHashed.service.UserServices.CustomerFavouriteService;

@Service
public class CustomerFavouriteServiceImpl implements CustomerFavouriteService {
	
	@Autowired
	CustomerFavouriteRepository customerFavouriteRepository;
	
	@Autowired
	CustomerAccountRepository userRepo;
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public CustomerFavourite addCustomerFavourite(CustomerFavouritePojo customerFavouritePojo, String userId) throws Exception {
		CustomerFavourite customerFavourite = new CustomerFavourite();
		String uniqueID = UUID.randomUUID().toString();
		customerFavourite.setId(uniqueID);
		customerFavourite.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
		if(customerAccountbyId.isPresent()) {
			customerFavourite.setCreatedBy(customerAccountbyId.get());
			customerFavourite.setCustomerAccount(customerAccountbyId.get());
		} else {
			throw new Exception("User Not found..");
		}
		Optional<Product> productbyId = productRepo.findById(customerFavouritePojo.getProduct());
		if(productbyId.isPresent()) {
			customerFavourite.setProduct(productbyId.get());
		} else {
			throw new Exception("Product Not found..");
		}
		return customerFavouriteRepository.save(customerFavourite);
	}

	@Override
	public void deleteCustomerCard(String userId, String product) {
		customerFavouriteRepository.deleteByCustomerAccount_IdAndProduct_Id(userId, product);
	}

	@Override
	public List<CustomerFavourite> customerFavourite(String userId) {
		return customerFavouriteRepository.findByCustomerAccount_Id(userId);	
	}

}
