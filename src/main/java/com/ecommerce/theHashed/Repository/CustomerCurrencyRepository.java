package com.ecommerce.theHashed.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.CustomerCurrency;

@Repository
public interface CustomerCurrencyRepository extends JpaRepository<CustomerCurrency, Long> {

	Optional<CustomerCurrency> findByCurrencyName(String string);

}
