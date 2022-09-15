package com.ecommerce.theHashed.service.UserServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.CustomerCard;
import com.ecommerce.theHashed.pojo.CustomerCardPojo;

@Service
public interface CustomerCardService {

	CustomerCard addCustomerCard(CustomerCardPojo customerCard, String id) throws Exception;

	void deleteCustomerCard(String customerCardId, String id);

	List<CustomerCard> customerCard(String id);

}
