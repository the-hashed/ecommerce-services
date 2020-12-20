package com.ecommerce.theHashed.security.oauth2;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ecommerce.theHashed.Repository.AccountTypeRepository;
import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerCurrencyRepository;
import com.ecommerce.theHashed.exception.OAuth2AuthenticationProcessingException;
import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.model.AuthProvider;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerCurrency;
import com.ecommerce.theHashed.security.UserPrincipal;
import com.ecommerce.theHashed.security.oauth2.user.OAuth2UserInfo;
import com.ecommerce.theHashed.security.oauth2.user.OAuth2UserInfoFactory;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	
	
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	AccountTypeRepository accountType;
	
	@Autowired
	CustomerCurrencyRepository customerCurrency;
	

	  @Override
	    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
	        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

	        try {
	            return processOAuth2User(oAuth2UserRequest, oAuth2User);
	        } catch (AuthenticationException ex) {
	            throw ex;
	        } catch (Exception ex) {
	            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
	            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
	        }
	    }

	    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
	    	
	        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
	        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
	            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
	        }

	        Optional<CustomerAccount> userOptional = customerAccountRepository.findByEmailId(oAuth2UserInfo.getEmail());
	        CustomerAccount user;
	        if(userOptional.isPresent()) {
	            user = userOptional.get();
	            if(!user.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
	                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
	                        user.getProvider() + " account. Please use your " + user.getProvider() +
	                        " account to login.");
	            }
	            user = updateExistingUser(user, oAuth2UserInfo);
	        } else {
	            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
	        }

	        return UserPrincipal.create(user, oAuth2User.getAttributes());
	    }
	    
	    private CustomerAccount registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
	    	CustomerAccount user = new CustomerAccount();
	    	String fullname = oAuth2UserInfo.getName();
	    	String lastName = "";
		    String firstName= "";
		    if(fullname.split("\\w+").length>1){

		       lastName = fullname.substring(fullname.lastIndexOf(" ")+1);
		       firstName = fullname.substring(0, fullname.lastIndexOf(' '));
		    }
		     else{
		       firstName = fullname;
		    }
	    	
	        user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
	        user.setProviderId(oAuth2UserInfo.getId());
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmailId(oAuth2UserInfo.getEmail());
	        Optional<AccountType> a = accountType.findById(Long.parseLong("4"));
			if(a.isPresent())
			user.setAccountType(a.get());
			Optional<CustomerCurrency> c = customerCurrency.findById(Long.parseLong("1"));
			if(c.isPresent())
			user.setCustomerCurrency(c.get());
			user.setEmailVerified(false);
			user.setPasswordResetCompleted(false);
			user.setMobileVerified(false);
			user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
	        
	        return customerAccountRepository.save(user);
	    }

	    private CustomerAccount updateExistingUser(CustomerAccount existingUser, OAuth2UserInfo oAuth2UserInfo) {
	    	String fullname = oAuth2UserInfo.getName();
	    	String lastName = "";
		    String firstName= "";
		    if(fullname.split("\\w+").length>1){

		       lastName = fullname.substring(fullname.lastIndexOf(" ")+1);
		       firstName = fullname.substring(0, fullname.lastIndexOf(' '));
		    }
		     else{
		       firstName = fullname;
		    }
	    	
	        existingUser.setFirstName(firstName);
	        existingUser.setFirstName(lastName);
	        return customerAccountRepository.save(existingUser);
	    }


}

