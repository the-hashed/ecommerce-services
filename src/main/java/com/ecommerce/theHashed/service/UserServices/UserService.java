package com.ecommerce.theHashed.service.UserServices;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.ecommerce.theHashed.model.CustomerAccount;

@Service
public interface UserService {
	CustomerAccount findByUsername(String mobile) throws Exception;
	CustomerAccount findByEmail(String email) throws Exception;
	CustomerAccount getUserDetailById(String string) throws Exception;
	CustomerAccount signUpUser(HashMap<String,String> signupRequest) throws Exception;
	CustomerAccount updateCustomerAccountSummary(HashMap<String, String> summaryRequest, String id) throws Exception;
	CustomerAccount customerAccount(String id) throws Exception;

}
