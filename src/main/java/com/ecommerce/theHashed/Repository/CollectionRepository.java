package com.ecommerce.theHashed.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, String> {

	List<Collection> findByName(String collection);

}
