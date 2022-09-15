package com.ecommerce.theHashed.service.UserServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.CustomerAddress;
import com.ecommerce.theHashed.pojo.CustomerAddressPojo;

@Service
public interface CustomerAddressService {

	List<CustomerAddress> customerAccountSummary(String id);

	CustomerAddress addCustomerAccountSummary(CustomerAddressPojo customerAddress, String id) throws Exception;

	CustomerAddress updateCustomerAccountSummary(CustomerAddressPojo customerAddress, String userId) throws Exception;
	
	void deleteCustomerAccountSummary(String customerAddressId, String userId);

}
