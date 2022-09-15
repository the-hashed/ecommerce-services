package com.ecommerce.theHashed.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
	
	List<Order> findByCustomerAccount_Id(String userId);

	@Transactional
    @Modifying
    @Query(value = "Update Orders set is_active = false where customer_account = :userid and NOT id = :currentid",
            nativeQuery = true)
	void updateOrderWithNoActiveOrder(@Param("userid") String userId, @Param("currentid") String id);

	Optional<Order> findByCustomerAccount_IdAndIsActive(String userId, boolean isActive);

}
