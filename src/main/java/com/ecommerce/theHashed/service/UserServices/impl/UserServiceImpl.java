package com.ecommerce.theHashed.service.UserServices.impl;

import java.util.HashMap;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.AccountTypeRepository;
import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerCurrencyRepository;
import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerCurrency;
import com.ecommerce.theHashed.service.UserServices.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	CustomerAccountRepository userRepo;
	
	@Autowired
	AccountTypeRepository accountType;
	
	@Autowired
	CustomerCurrencyRepository customerCurrency;
	
	@Override
	public CustomerAccount findByUsername(String user) throws Exception {
		Optional<CustomerAccount> mob = userRepo.findByMobileNo(user);
		if(mob.isPresent()) {
			return mob.get();
		}
		Optional<CustomerAccount> email = userRepo.findByEmailId(user);
		if(email.isPresent()) {
			return email.get();
		}
		throw new Exception("User Not found..");
	}

	@Override
	public CustomerAccount getUserDetailById(long userId) throws Exception {
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public CustomerAccount signUpUser(HashMap<String, String> signupRequest) throws Exception {
		Base64.Encoder enc = Base64.getEncoder();
		try {
			if(userRepo.findByMobileNo(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			if(userRepo.findByEmailId(signupRequest.get("email")).isPresent()) {
				throw new Exception("User is already registered with Email ID");
			}
			CustomerAccount user = new CustomerAccount();
			user.setFirstName(signupRequest.get("firstname"));
			user.setLastName(signupRequest.get("lastname"));
			user.setEmailId(signupRequest.get("email"));
			user.setMobileNo(signupRequest.get("mobile"));
			String encoded = enc.encodeToString(signupRequest.get("password").getBytes());
			user.setPassword(encoded);
			Optional<AccountType> a = accountType.findById(Long.parseLong(signupRequest.get("accounttype")));
			if(a.isPresent())
			user.setAccountType(a.get());
			Optional<CustomerCurrency> c = customerCurrency.findById(Long.parseLong(signupRequest.get("currency")));
			if(c.isPresent())
			user.setCustomerCurrency(c.get());
			user.setEmailVerified(false);
			user.setPasswordResetCompleted(false);
			user.setMobileVerified(false);
			userRepo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public CustomerAccount findByEmail(String email) throws Exception {
		return userRepo.findByEmailId(email).orElseThrow(()->new Exception("User Not found.."));
	}
}
