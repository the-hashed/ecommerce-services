package com.ecommerce.theHashed.service.UserServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.CustomerFavourite;
import com.ecommerce.theHashed.pojo.CustomerFavouritePojo;

@Service
public interface CustomerFavouriteService {

	CustomerFavourite addCustomerFavourite(CustomerFavouritePojo customerFavouritePojo, String userId) throws Exception;

	void deleteCustomerCard(String userId, String product);

	List<CustomerFavourite> customerFavourite(String userId);

	
}
