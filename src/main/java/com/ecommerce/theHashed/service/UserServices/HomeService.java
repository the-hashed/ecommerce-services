package com.ecommerce.theHashed.service.UserServices;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.ecommerce.theHashed.model.Product;

@Service
public interface HomeService {

	List<Product> getLatestProduct();

	List<String> getCollectionsName();

	Map<String, Set<String>> getAllCollection();

}
