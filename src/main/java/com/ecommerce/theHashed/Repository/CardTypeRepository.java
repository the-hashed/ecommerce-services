package com.ecommerce.theHashed.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.CardType;
@Repository
public interface CardTypeRepository extends JpaRepository<CardType, String> {

	Optional<CardType> findByCardTypeAndCardCompanyName(String cardType, String cardCompanyName);
	

}
