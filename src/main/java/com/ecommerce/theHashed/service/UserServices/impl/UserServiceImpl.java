package com.ecommerce.theHashed.service.UserServices.impl;

import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.AccountTypeRepository;
import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerCurrencyRepository;
import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.model.AuthProvider;
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
	public CustomerAccount getUserDetailById(String userId) throws Exception {
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public CustomerAccount signUpUser(HashMap<String, String> signupRequest) throws Exception {
		Base64.Encoder enc = Base64.getEncoder();
		try {
			if(userRepo.findByMobileNo(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			
			Optional<CustomerAccount> customerAccountbyEmail = userRepo.findByEmailId(signupRequest.get("email"));
			
			if(customerAccountbyEmail.isPresent()) {
				if(customerAccountbyEmail.get().getProvider().equals(AuthProvider.local)) {
				throw new Exception("User is already registered with Email ID");
				} else {
					CustomerAccount cusmtomerOfSocial = customerAccountbyEmail.get();
					cusmtomerOfSocial.setFirstName(signupRequest.get("firstname"));
					cusmtomerOfSocial.setLastName(signupRequest.get("lastname"));
					cusmtomerOfSocial.setEmailId(signupRequest.get("email"));
					cusmtomerOfSocial.setMobileNo(signupRequest.get("mobile"));
					String encoded = enc.encodeToString(signupRequest.get("password").getBytes());
					cusmtomerOfSocial.setPassword(encoded);
					Optional<AccountType> a = accountType.findByAccountType(signupRequest.get("accounttype"));
					if(a.isPresent())
						cusmtomerOfSocial.setAccountType(a.get());
					Optional<CustomerCurrency> c = customerCurrency.findByCurrencyName(signupRequest.get("currency"));
					if(c.isPresent())
						cusmtomerOfSocial.setCustomerCurrency(c.get());
					cusmtomerOfSocial.setEmailVerified(false);
					cusmtomerOfSocial.setPasswordResetCompleted(false);
					cusmtomerOfSocial.setMobileVerified(false);
					cusmtomerOfSocial.setProvider(AuthProvider.local);
					cusmtomerOfSocial.setProviderUpdatedAt(new Timestamp(System.currentTimeMillis()));
					userRepo.save(cusmtomerOfSocial);
					return cusmtomerOfSocial;
				}
			} else {
			CustomerAccount user = new CustomerAccount();
			String uniqueID = UUID.randomUUID().toString();
			user.setId(uniqueID);
			user.setFirstName(signupRequest.get("firstname"));
			user.setLastName(signupRequest.get("lastname"));
			user.setEmailId(signupRequest.get("email"));
			user.setMobileNo(signupRequest.get("mobile"));
			String encoded = enc.encodeToString(signupRequest.get("password").getBytes());
			user.setPassword(encoded);
			Optional<AccountType> a = accountType.findByAccountType(signupRequest.get("accounttype"));
			if(a.isPresent())
			user.setAccountType(a.get());
			Optional<CustomerCurrency> c = customerCurrency.findByCurrencyName(signupRequest.get("currency"));
			if(c.isPresent())
			user.setCustomerCurrency(c.get());
			user.setEmailVerified(false);
			user.setPasswordResetCompleted(false);
			user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			user.setMobileVerified(false);
			user.setProvider(AuthProvider.local);
			userRepo.save(user);
			return user;
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public CustomerAccount findByEmail(String email) throws Exception {
		return userRepo.findByEmailId(email).orElseThrow(()->new Exception("User Not found.."));
	}
	
	@Override
	public CustomerAccount updateCustomerAccountSummary(HashMap<String, String> summaryRequest, String id) throws Exception {
		
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(id);
		if(customerAccountbyId.isPresent()) {
			if(userRepo.findByMobileNo(summaryRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with this mobile no. from another account");
			}
			if(userRepo.findByEmailId(summaryRequest.get("email")).isPresent()) {
				throw new Exception("User is already registered with this email from another account");
			}
			
			CustomerAccount user = customerAccountbyId.get();
			if(summaryRequest.get("firstname") != null)
			user.setFirstName(summaryRequest.get("firstname"));
			if(summaryRequest.get("lastname") != null)
			user.setLastName(summaryRequest.get("lastname"));
			if(summaryRequest.get("email") != null)
			user.setEmailId(summaryRequest.get("email"));
			if(summaryRequest.get("mobile") != null)
			user.setMobileNo(summaryRequest.get("mobile"));
			
			userRepo.save(user);
			return user;
		} else {
			throw new Exception("User not found.");
		}
		
	}

	@Override
	public CustomerAccount customerAccount(String id) throws Exception {
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(id);
		
		if(customerAccountbyId.isPresent()) {
			return customerAccountbyId.get();		
		}
		else {
			throw new Exception("User not found.");
		}
		
	}
}
