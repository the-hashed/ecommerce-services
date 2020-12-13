package com.ecommerce.theHashed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.AccountType;
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
	
}
