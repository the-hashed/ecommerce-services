package com.ecommerce.theHashed.service.UserServices.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CustomerCurrencyRepository;
import com.ecommerce.theHashed.model.CustomerCurrency;
import com.ecommerce.theHashed.service.UserServices.CustomerCurrencyService;

@Service
public class CustomerCurrencyServiceImpl implements CustomerCurrencyService {
	
	@Autowired
	CustomerCurrencyRepository customerCurrency;

	@Override
	public List<CustomerCurrency> insertCustomerCurrency() {
		List<CustomerCurrency> listCuurency = new ArrayList<CustomerCurrency>();
		CustomerCurrency acc1 = new CustomerCurrency();
		String uniqueID = UUID.randomUUID().toString();
		acc1.setId(uniqueID);
		acc1.setCurrencyName("INR");
		customerCurrency.save(acc1);
		listCuurency.add(acc1);
		CustomerCurrency acc2 = new CustomerCurrency();
		String uniqueID2 = UUID.randomUUID().toString();
		acc2.setId(uniqueID2);
		acc2.setCurrencyName("USD");
		customerCurrency.save(acc2);
		listCuurency.add(acc2);
		CustomerCurrency acc3 = new CustomerCurrency();
		String uniqueID3 = UUID.randomUUID().toString();
		acc3.setId(uniqueID3);
		acc3.setCurrencyName("EURO");
		customerCurrency.save(acc3);
		listCuurency.add(acc3);
		return listCuurency;
		
	}

}
