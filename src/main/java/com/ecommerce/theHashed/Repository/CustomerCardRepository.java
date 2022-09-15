package com.ecommerce.theHashed.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.model.CustomerCard;

@Repository
public interface CustomerCardRepository extends JpaRepository<CustomerCard, String> {

	List<CustomerCard> findByCustomerAccount_Id(String userId);

	@Transactional
	void deleteByIdAndCustomerAccount_Id(String customerAddressId, String userId);

	Optional<CustomerCard> findByCardNo(String cardNo);

	@Transactional
    @Modifying
    @Query(value = "UPDATE customer_cards c set isdefault =:defaultStatus where c.customer_account = :userId",
            nativeQuery = true)
	void updateCustomerIsDefault(@Param("defaultStatus") boolean defaultStatus, @Param("userId") String userId);

}
