package com.ecommerce.theHashed.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.CustomerAccount;
@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
	
	Optional<CustomerAccount> findByMobileNo(String mobile);

	Optional<CustomerAccount> findByEmailId(String email);

	Optional<CustomerAccount> findById(String userId);
}
