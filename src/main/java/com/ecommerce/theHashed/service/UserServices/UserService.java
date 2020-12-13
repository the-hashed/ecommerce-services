package com.ecommerce.theHashed.service.UserServices;

import java.util.HashMap;


import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.CustomerAccount;

@Service
public interface UserService {
	CustomerAccount findByUsername(String mobile) throws Exception;
	CustomerAccount findByEmail(String email) throws Exception;
	CustomerAccount getUserDetailById(long userId) throws Exception;
	CustomerAccount signUpUser(HashMap<String,String> signupRequest) throws Exception;
	
}