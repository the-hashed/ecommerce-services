package com.ecommerce.theHashed.service.UserServices.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CustomerRewardsRepository;
import com.ecommerce.theHashed.model.CustomerRewards;
import com.ecommerce.theHashed.service.UserServices.CustomerRewardsService;

@Service
public class CustomerRewardsServiceImpl implements CustomerRewardsService {
	
	@Autowired
	CustomerRewardsRepository promoRepository;

	@Override
	public void insertPromo() {
		CustomerRewards promo = new CustomerRewards();
		String uniqueID = UUID.randomUUID().toString();
		promo.setId(uniqueID);
		promo.setCouponName("FLAT50%");
		promo.setDiscountPercentage(50);
		promoRepository.save(promo);
		CustomerRewards promo2 = new CustomerRewards();
		String uniqueID2 = UUID.randomUUID().toString();
		promo2.setId(uniqueID2);
		promo2.setCouponName("SAVE30");
		promo2.setDiscountAmount(30.0);
		promoRepository.save(promo2);
	}

}
