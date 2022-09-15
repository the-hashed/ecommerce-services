package com.ecommerce.theHashed.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.CustomerRewards;

@Repository
public interface CustomerRewardsRepository extends JpaRepository<CustomerRewards, String> {

	Optional<CustomerRewards> findByCouponName(String promo);

}
