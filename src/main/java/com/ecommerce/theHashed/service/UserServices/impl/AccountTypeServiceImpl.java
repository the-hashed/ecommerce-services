package com.ecommerce.theHashed.service.UserServices.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.AccountTypeRepository;
import com.ecommerce.theHashed.model.AccountType;
import com.ecommerce.theHashed.service.UserServices.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
	
	@Autowired
	AccountTypeRepository accountType;

	@Override
	public List<AccountType> insertAccountType() {
		List<AccountType> listAccount = new ArrayList<AccountType>();
		AccountType acc1 = new AccountType();
		String uniqueID = UUID.randomUUID().toString();
		acc1.setId(uniqueID);
		acc1.setAccountType("WEB");
		accountType.save(acc1);
		listAccount.add(acc1);
		AccountType acc2 = new AccountType();
		String uniqueID2 = UUID.randomUUID().toString();
		acc2.setId(uniqueID2);
		acc2.setAccountType("NON_WEB");
		accountType.save(acc2);
		listAccount.add(acc2);
		AccountType acc3 = new AccountType();
		String uniqueID3 = UUID.randomUUID().toString();
		acc3.setId(uniqueID3);
		acc3.setAccountType("SOCIAL");
		accountType.save(acc3);
		listAccount.add(acc3);
		return listAccount;
		
	}

}
