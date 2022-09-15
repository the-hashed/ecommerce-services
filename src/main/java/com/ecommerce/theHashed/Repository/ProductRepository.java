package com.ecommerce.theHashed.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findByCollection_Name(String collectionName);

	List<Product> findFirst4ByOrderByCreatedAtDesc();

	List<Product> findByCollection_Subcollection(String subCollectionName);

	List<Product> findByBrand(String brand);

}
