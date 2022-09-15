package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CollectionRepository;
import com.ecommerce.theHashed.Repository.ProductRepository;
import com.ecommerce.theHashed.model.Collection;
import com.ecommerce.theHashed.model.Product;
import com.ecommerce.theHashed.model.ProductOption;
import com.ecommerce.theHashed.service.UserServices.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CollectionRepository collectionRepo;
	
	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getAllProductByCollection(String collectionName) {

		return productRepo.findByCollection_Name(collectionName);
	}

	@Override
	public List<Product> getAddProduct() {
		
		List<Product> listofProduct = new ArrayList<Product>();
		Product p = new Product();
		Collection c = new Collection();
		String C_uniqueID = UUID.randomUUID().toString();
		c.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		c.setDescription("MEN Collections");
		c.setName("Men");
		c.setSubcollection("Men Jeans");
		c.setId(C_uniqueID);
		String P_uniqueID = UUID.randomUUID().toString();
		p.setCollection(collectionRepo.save(c));
		p.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		p.setDescription("Pepe Mens Jeans");
		p.setDiscount(20);
		p.setId(P_uniqueID);
		p.setName("Pepe Jeans");
		p.setPrice(1500.0);
		p.setProductsStatus("Available");
		p.setQuantity(15);
		p.setWeight(45);
		p.setBrand("PUMA");
		p.setFabric("COTTON");
		
		ProductOption po = new ProductOption();
		List<String> color = new ArrayList<String>();
		color.add("blue");
		color.add("black");
		color.add("grey");
		
		List<String> size = new ArrayList<String>();
		size.add("S");
		size.add("M");
		size.add("L");
		size.add("XL");
		po.setColor(color);
		po.setSize(size);
		p.setSizecoloroption(po);
		productRepo.save(p);
		listofProduct.add(p);
		
		Product p2 = new Product();
		
		String P_uniqueID2 = UUID.randomUUID().toString();
		Collection c2 = new Collection();
		String C_uniqueID3 = UUID.randomUUID().toString();
		c2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		c2.setDescription("MEN Collections");
		c2.setName("Men");
		c2.setSubcollection("Men Shirt");
		c2.setId(C_uniqueID3);
		p2.setCollection(collectionRepo.save(c2));
		p2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		p2.setDescription("Gap Mens Shirt");
		p2.setDiscount(20);
		p2.setId(P_uniqueID2);
		p2.setName("Gap Shirt");
		p2.setPrice(1500.0);
		p2.setProductsStatus("Available");
		p2.setQuantity(15);
		p2.setWeight(45);
		p2.setBrand("NIKE");
		p2.setFabric("LINEN");
		
		ProductOption po2 = new ProductOption();
		List<String> color2 = new ArrayList<String>();
		color2.add("blue");
		color2.add("white");
		color2.add("brown");
		
		List<String> size2 = new ArrayList<String>();
		size2.add("S");
		size2.add("M");
		size2.add("XL");
		po2.setColor(color2);
		po2.setSize(size2);
		p2.setSizecoloroption(po2);
		productRepo.save(p2);
		listofProduct.add(p2);
		
		
		Product p1 = new Product();
		Collection c1 = new Collection();
		String C_uniqueID1 = UUID.randomUUID().toString();
		c1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		c1.setDescription("BAG Collections");
		c1.setName("Bag");
		c1.setSubcollection("Women Bag");
		c1.setId(C_uniqueID1);
		String P_uniqueID1 = UUID.randomUUID().toString();
		p1.setCollection(collectionRepo.save(c1));
		p1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		p1.setDescription("Pepe BAG");
		p1.setDiscount(20);
		p1.setId(P_uniqueID1);
		p1.setName("Pepe BAG");
		p1.setPrice(1500.0);
		p1.setProductsStatus("Available");
		p1.setQuantity(15);
		p1.setWeight(45);
		
		ProductOption po1 = new ProductOption();
		List<String> color1 = new ArrayList<String>();
		color1.add("blue");
		color1.add("black");
		color1.add("grey");
		
		List<String> size1 = new ArrayList<String>();
		size1.add("S");
		size1.add("M");
		size1.add("L");
		size1.add("XL");
		po1.setColor(color1);
		po1.setSize(size1);
		p1.setSizecoloroption(po1);

		p1.setBrand("PUMA");
		p1.setFabric("LINEN");
		productRepo.save(p1);
		listofProduct.add(p1);
		
		
		Product p11 = new Product();
		Collection c11 = new Collection();
		String C_uniqueID11 = UUID.randomUUID().toString();
		c11.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		c11.setDescription("Women Collections");
		c11.setName("Women");
		c11.setSubcollection("Women Jeans");
		c11.setId(C_uniqueID11);
		String P_uniqueID11 = UUID.randomUUID().toString();
		p11.setCollection(collectionRepo.save(c11));
		p11.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		p11.setDescription("Gap Womens Jeans");
		p11.setDiscount(20);
		p11.setId(P_uniqueID11);
		p11.setName("Gay Jeans");
		p11.setPrice(3000.0);
		p11.setProductsStatus("Available");
		p11.setQuantity(15);
		p11.setWeight(45);
		
		ProductOption po11 = new ProductOption();
		List<String> color11 = new ArrayList<String>();
		color11.add("blue");
		color11.add("black");
		color11.add("grey");
		
		List<String> size11 = new ArrayList<String>();
		size11.add("S");
		size11.add("M");
		size11.add("L");
		size11.add("XL");
		po11.setColor(color11);
		po11.setSize(size11);
		p11.setSizecoloroption(po11);

		p2.setBrand("PUMA");
		p2.setFabric("COTTON");
		productRepo.save(p11);
		listofProduct.add(p11);
		
		return listofProduct;
	}

	@Override
	public List<Product> getAllProductBySubCollection(String subCollectionName) {
		
		return productRepo.findByCollection_Subcollection(subCollectionName);
	}

	@Override
	public Optional<Product> productById(String id) {
		return productRepo.findById(id);
	}

	@Override
	public List<Product> productByBrand(String brand) {
		return productRepo.findByBrand(brand);
	}

}
