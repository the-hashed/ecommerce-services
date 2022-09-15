package com.ecommerce.theHashed.service.UserServices;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.ecommerce.theHashed.model.Product;

@Service
public interface ProductService {

	List<Product> getAllProduct();

	List<Product> getAllProductByCollection(String collectionName);

	List<Product> getAddProduct() throws SQLException;

	List<Product> getAllProductBySubCollection(String subCollectionName);

	Optional<Product> productById(String id);

	List<Product> productByBrand(String brand);

}
