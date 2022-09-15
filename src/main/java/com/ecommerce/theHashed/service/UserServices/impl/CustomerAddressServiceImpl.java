package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerAddressRepository;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerAddress;
import com.ecommerce.theHashed.pojo.CustomerAddressPojo;
import com.ecommerce.theHashed.service.UserServices.CustomerAddressService;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	CustomerAccountRepository userRepo;
	
	@Override
	public List<CustomerAddress> customerAccountSummary(String userId) {
		
		return customerAddressRepository.findByCustomerAccount_Id(userId);	
	}

	@Override
	public CustomerAddress addCustomerAccountSummary(CustomerAddressPojo customerAddress, String userId) throws Exception {
		CustomerAddress customerAddres = new CustomerAddress();
		String uniqueID = UUID.randomUUID().toString();
		customerAddres.setId(uniqueID);
		if(customerAddress.getAddress1() != null)
			customerAddres.setAddress1(customerAddress.getAddress1());
			if(customerAddress.getAddress2() != null)
			customerAddres.setAddress2(customerAddress.getAddress2());
			if(customerAddress.getCity() != null)
			customerAddres.setCity(customerAddress.getCity());
			if(customerAddress.getCompanyName() != null)
			customerAddres.setCompanyName(customerAddress.getCompanyName());
			if(customerAddress.getCountry() != null)
			customerAddres.setCountry(customerAddress.getCountry());
		customerAddres.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
		if(customerAccountbyId.isPresent()) {
			customerAddres.setCreatedBy(customerAccountbyId.get());
			customerAddres.setCustomerAccount(customerAccountbyId.get());
		} else {
			throw new Exception("User Not found..");
		}
		customerAddres.setFirstName(customerAddress.getFirstName());
		
		List<CustomerAddress> listOfCustomerAddress = customerAddressRepository.findByCustomerAccount_Id(userId);	
		if(listOfCustomerAddress.isEmpty()) {
			customerAddres.setIsdefault(true);	
		} else if(customerAddress.getIsDefault() != null) {
			if(customerAddress.getIsDefault() == true) {
				customerAddressRepository.updateCustomerIsDefault(false, userId);
			}
			customerAddres.setIsdefault(customerAddress.getIsDefault());
		} else {
			customerAddres.setIsdefault(false);	
		}
		customerAddres.setLastName(customerAddress.getLastName());
		if(customerAddress.getMobileNo() != null)
		customerAddres.setMobileNo(customerAddress.getMobileNo());
		if(customerAddress.getRegion() != null)
		customerAddres.setRegion(customerAddress.getRegion());
		if(customerAddress.getZipCode() != null)
		customerAddres.setZipCode(customerAddress.getZipCode());
		if(customerAddress.getIsBillingAddress() != null) {
			customerAddres.setIsBillingAddress(customerAddress.getIsBillingAddress());
		} else {
			customerAddres.setIsBillingAddress(false);
		}
		if(customerAddress.getIsShippingAddress() != null) {
			customerAddres.setIsShippingAddress(customerAddress.getIsShippingAddress());
		} else {
			customerAddres.setIsShippingAddress(false);
		}
		customerAddressRepository.save(customerAddres);
		return customerAddres;
	}

	@Override
	public CustomerAddress updateCustomerAccountSummary(CustomerAddressPojo customerAddress, String userId) throws Exception {
		Optional<CustomerAddress> customerAddressbyId = customerAddressRepository.findById(customerAddress.getId());
		if(customerAddressbyId.isPresent()) {
			CustomerAddress customerAddres = customerAddressbyId.get();
			if(customerAddress.getAddress1() != null)
			customerAddres.setAddress1(customerAddress.getAddress1());
			if(customerAddress.getAddress2() != null)
			customerAddres.setAddress2(customerAddress.getAddress2());
			if(customerAddress.getCity() != null)
			customerAddres.setCity(customerAddress.getCity());
			if(customerAddress.getCompanyName() != null)
			customerAddres.setCompanyName(customerAddress.getCompanyName());
			if(customerAddress.getCountry() != null)
			customerAddres.setCountry(customerAddress.getCountry());
			customerAddres.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			
			Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
			if(customerAccountbyId.isPresent()) {
				customerAddres.setUpdatedBy(customerAccountbyId.get());
			} else {
				throw new Exception("User Not found..");
			}
			if(customerAddress.getFirstName() != null)
			customerAddres.setFirstName(customerAddress.getFirstName());
			if(customerAddress.getIsDefault() != null) {
				if(customerAddress.getIsDefault() == true) {
					customerAddressRepository.updateCustomerIsDefault(false, userId);
				}
				customerAddres.setIsdefault(customerAddress.getIsDefault());
			}
			if(customerAddress.getLastName() != null)
			customerAddres.setLastName(customerAddress.getLastName());
			if(customerAddress.getMobileNo() != null)
			customerAddres.setMobileNo(customerAddress.getMobileNo());
			if(customerAddress.getRegion() != null)
			customerAddres.setRegion(customerAddress.getRegion());
			if(customerAddress.getZipCode() != null)
			customerAddres.setZipCode(customerAddress.getZipCode());
			if(customerAddress.getIsBillingAddress() != null) {
				customerAddres.setIsBillingAddress(customerAddress.getIsBillingAddress());
			} else {
				customerAddres.setIsBillingAddress(false);
			}
			if(customerAddress.getIsShippingAddress() != null) {
				customerAddres.setIsShippingAddress(customerAddress.getIsShippingAddress());
			} else {
				customerAddres.setIsShippingAddress(false);
			}
			customerAddressRepository.save(customerAddres);
			return customerAddres;
			
		} else {
			throw new Exception("Address not found.");
		}
	}

	@Override
	public void deleteCustomerAccountSummary(String customerAddressId, String userId) {
		Optional<CustomerAddress> customerAddressbyId = customerAddressRepository.findById(customerAddressId);
		if(customerAddressbyId.isPresent()) {
			CustomerAddress cd = customerAddressbyId.get();
			if(cd.getIsdefault() == true) {
				CustomerAddress customerAddress = customerAddressRepository.findTopByOrderByCreatedAtDesc();
				customerAddress.setIsdefault(true);
				customerAddressRepository.save(customerAddress);
			}
		}
		customerAddressRepository.deleteByIdAndCustomerAccount_Id(customerAddressId, userId);
	}

}
