package com.ecommerce.theHashed.service.UserServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.model.CustomerCurrency;

@Service
public interface CustomerCurrencyService {

	List<CustomerCurrency> insertCustomerCurrency();

}
