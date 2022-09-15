package com.ecommerce.theHashed.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.model.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, String> {

	List<CustomerAddress> findByCustomerAccount_Id(String userId);

	@Transactional
    @Modifying
    @Query(value = "UPDATE customer_address u set isdefault =:defaultStatus where u.customer_account = :userId",
            nativeQuery = true)
	void updateCustomerIsDefault(@Param("defaultStatus") boolean defaultStatus, @Param("userId") String userId);

	@Transactional
	void deleteByIdAndCustomerAccount_Id(String customerAddressId, String userId);

	@Transactional
	CustomerAddress findTopByOrderByCreatedAtDesc();

}
