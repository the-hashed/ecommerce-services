package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CardTypeRepository;
import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerCardRepository;
import com.ecommerce.theHashed.model.CardType;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerCard;
import com.ecommerce.theHashed.pojo.CustomerCardPojo;
import com.ecommerce.theHashed.service.UserServices.CustomerAddressService;
import com.ecommerce.theHashed.service.UserServices.CustomerCardService;

@Service
public class CustomerCardServiceImpl implements CustomerCardService {

	@Autowired
	CustomerCardRepository customerCardRepository;
	
	@Autowired
	CardTypeRepository cardTypeRepository;
	
	@Autowired
	CustomerAccountRepository userRepo;
	
	@Autowired
	CustomerAddressService customerAddressService;

	@Override
	public CustomerCard addCustomerCard(CustomerCardPojo customerCardPojo, String userId) throws Exception {
		
		Optional<CustomerCard> customerCardByCardId = customerCardRepository.findByCardNo(customerCardPojo.getCardNo().toString());
		if(customerCardByCardId.isPresent()) {
			throw new Exception("Card already added");
		} 
		CustomerCard customerCard = new CustomerCard();
		String uniqueID = UUID.randomUUID().toString();
		customerCard.setId(uniqueID);
		if(customerCardPojo.getBankName() != null)
		customerCard.setBankName(customerCardPojo.getBankName());
		customerCard.setCardNo(customerCardPojo.getCardNo().toString());
		customerCard.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
		if(customerAccountbyId.isPresent()) {
			customerCard.setCreatedBy(customerAccountbyId.get());
			customerCard.setCustomerAccount(customerAccountbyId.get());
		} else {
			throw new Exception("User Not found..");
		}
		customerCard.setCustomerName(customerCardPojo.getCustomerName());
		customerCard.setCvv(customerCardPojo.getCvv());
		
		if(validateCardExpiryDate(customerCardPojo.getExpiryDate())) {
			customerCard.setExpiryDate(customerCardPojo.getExpiryDate());
		} else {
			throw new Exception("Card Expired");
		}
		List<CustomerCard> listOfCustomerCard = customerCardRepository.findByCustomerAccount_Id(userId);	
		if(listOfCustomerCard.isEmpty()) {
			customerCard.setIsdefault(true);
			customerCardPojo.getCustomerAddressPojo().setIsDefault(true);
		} else if(customerCardPojo.getIsdefault() != null) {
			if(customerCardPojo.getIsdefault() == true) {
				customerCardRepository.updateCustomerIsDefault(false, userId);
				customerCardPojo.getCustomerAddressPojo().setIsDefault(true);
			}
			customerCard.setIsdefault(customerCardPojo.getIsdefault());
		} else {
			customerCard.setIsdefault(false);	
		}
		customerCardPojo.getCustomerAddressPojo().setIsBillingAddress(true);
		customerCard.setCustomerAddress(customerAddressService.addCustomerAccountSummary(customerCardPojo.getCustomerAddressPojo(), userId));
		if(customerCardPojo.getIsVerified() != null) { 
		customerCard.setIsVerified(customerCardPojo.getIsVerified());
		} else {
			customerCard.setIsVerified(false);
		}
		Optional<CardType> cardTypebyNameandType = cardTypeRepository.findByCardTypeAndCardCompanyName(customerCardPojo.getCardTypePojo().getCardType(), customerCardPojo.getCardTypePojo().getCardCompanyName());
		if(cardTypebyNameandType.isPresent()) {
			customerCard.setCardType(cardTypebyNameandType.get());
		} else {
			CardType cardType = new CardType();
			String uniqueID1 = UUID.randomUUID().toString();
			cardType.setId(uniqueID1);
			cardType.setCardType(customerCardPojo.getCardTypePojo().getCardType());
			cardType.setCardCompanyName(customerCardPojo.getCardTypePojo().getCardCompanyName());
			cardTypeRepository.save(cardType);
			customerCard.setCardType(cardType);
		}
		customerCardRepository.save(customerCard);
		return customerCard;
	}

	@Override
	public void deleteCustomerCard(String customerCardId, String userId) {
		customerCardRepository.deleteByIdAndCustomerAccount_Id(customerCardId, userId);
		
	}

	@Override
	public List<CustomerCard> customerCard(String userId) {
		
		
		List<CustomerCard> listofCard = customerCardRepository.findByCustomerAccount_Id(userId);
		return listofCard.stream().map((card) -> { card.setCardNo(card.getCardNo().replaceAll("\\d(?=\\d{4})", "*"));
		return card;
		}).collect(Collectors.toList());
	}
	
	boolean validateCardExpiryDate(String expiryDate) {
		 return expiryDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
	}
}
