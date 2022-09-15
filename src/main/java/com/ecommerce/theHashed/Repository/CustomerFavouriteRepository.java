package com.ecommerce.theHashed.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.model.CustomerFavourite;

@Repository
public interface CustomerFavouriteRepository extends JpaRepository<CustomerFavourite, String> {

	@Transactional
	void deleteByCustomerAccount_IdAndProduct_Id(String userId, String product);

	List<CustomerFavourite> findByCustomerAccount_Id(String userId);
	
}
