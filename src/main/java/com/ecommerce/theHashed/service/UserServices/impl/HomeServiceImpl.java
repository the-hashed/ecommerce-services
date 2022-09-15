package com.ecommerce.theHashed.service.UserServices.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CollectionRepository;
import com.ecommerce.theHashed.Repository.ProductRepository;
import com.ecommerce.theHashed.model.Product;
import com.ecommerce.theHashed.service.UserServices.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CollectionRepository collectionRepo;
	

	@Override
	public List<String> getCollectionsName() {
		return collectionRepo.findAll().stream().map(i -> i.getName()).distinct().collect(Collectors.toList());
	}

	@Override
	public List<Product> getLatestProduct() {
		return productRepo.findFirst4ByOrderByCreatedAtDesc();
	}

	@Override
	public Map<String, Set<String>> getAllCollection() {
		Map<String, Set<String>> mapofCollection = new HashMap<String, Set<String>>();
		List<String> listofCollection = collectionRepo.findAll().stream().map(i -> i.getName()).distinct().collect(Collectors.toList());

		for (String collection: listofCollection) {
		    Set<String> setOfSubCollection =  collectionRepo.findByName(collection).stream().map(i -> i.getSubcollection()).collect(Collectors.toSet());
		    mapofCollection.put(collection, setOfSubCollection);
		}

		return mapofCollection;
	}

}
