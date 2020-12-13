package com.ecommerce.theHashed.JWTConfiguration;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import com.ecommerce.theHashed.controller.RequestPojo.LoginRequest;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.service.UserServices.UserService;


@Configuration
public class AuthManager {
	@Autowired
	UserService userService;
	 private static final Logger logger = LoggerFactory.getLogger(AuthManager.class);
	 public Authentication authenticate(UsernamePasswordAuthenticationToken authentication,LoginRequest loginRequest) throws AuthenticationException {
	    String username = authentication.getPrincipal() + "";
	    String password = authentication.getCredentials() + "";
	    CustomerAccount user;
	    Base64.Decoder dec = Base64.getDecoder();
		try {
			logger.info("user is going to validate(AuthManager) "+username);
			if(userService == null) {
				 logger.info("user found the error");
				 throw new BadCredentialsException("1001");
			}
			user = userService.findByUsername(username);
			 if (user == null) {
			        throw new BadCredentialsException("User Not found!!");
			  }
			 String decoded = new String(dec.decode(user.getPassword()));
			 logger.info("from authentication "+password+" from db "+decoded);
			 if(!this.passwordMatch(password, decoded)) {
				 logger.info("Password is wrong for user .."+user.getEmailId()+"-- "+user.getMobileNo());
				 throw new BadCredentialsException("username or password is wrong.");
			 } 

		        return new UsernamePasswordAuthenticationToken(new UserPrincipal(user.getId(), username, password), password);
		} catch (Exception e) {
			logger.info("Error",e);
			 throw new BadCredentialsException(e.getMessage());
		}
	   
	} 
	 private Boolean passwordMatch(String rawPassword,String from_db_encoded) {
		 return rawPassword.equals(from_db_encoded);
		// return BCrypt.checkpw(rawPassword.toString(),from_db_encoded);	 
	 }
	 
}
