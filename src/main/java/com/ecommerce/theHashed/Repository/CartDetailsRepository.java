package com.ecommerce.theHashed.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.model.CartDetail;

@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetail, String> {

	@Transactional
	void deleteByIdAndCustomerAccount_Id(String cartId, String userId);

	List<CartDetail> findByCustomerAccount_Id(String userId);

}
