package com.ecommerce.theHashed.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

	@Transactional
	void deleteByCustomerAccount_Id(String userId);

	Optional<OrderItem> findByCustomerAccount_Id(String userId);

}
