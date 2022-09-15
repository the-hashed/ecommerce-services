package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.Repository.CartDetailsRepository;
import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.OrderItemRepository;
import com.ecommerce.theHashed.Repository.OrderRepository;
import com.ecommerce.theHashed.Repository.ProductRepository;
import com.ecommerce.theHashed.Repository.CustomerRewardsRepository;
import com.ecommerce.theHashed.model.CartDetail;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerRewards;
import com.ecommerce.theHashed.model.Order;
import com.ecommerce.theHashed.model.OrderItem;
import com.ecommerce.theHashed.pojo.OrderPojo;
import com.ecommerce.theHashed.service.UserServices.CustomerAddressService;
import com.ecommerce.theHashed.service.UserServices.CustomerCardService;
import com.ecommerce.theHashed.service.UserServices.OrderService;
import com.ecommerce.theHashed.util.HibernateProxyTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	CustomerAccountRepository userRepo;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	CustomerAddressService customerAddressService;
	
	@Autowired
	CustomerCardService customerCardService;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	CustomerRewardsRepository promoRepository;

	@Override
	public Order addOrder(OrderPojo orderPojo, String userId) throws Exception {
		Order order = new Order();
		String uniqueID = UUID.randomUUID().toString();
		order.setId(uniqueID);
		order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
		if(customerAccountbyId.isPresent()) {
			order.setCustomerAccount(customerAccountbyId.get());
		} else {
			throw new Exception("User Not found..");
		}
		
		Optional<OrderItem> orderItem = orderItemRepository.findByCustomerAccount_Id(userId);
		if(orderItem.isPresent()) {
			Double total_Cost = 0.0;
			order.setOrderItem(orderItem.get());
			List<Map<String, String>> listOfProductInfo = new ArrayList<Map<String, String>>();
			for(String cartId : orderItem.get().getCartDetail()) {
			Map<String, String> productMap = new HashMap<String, String>();
			Optional<CartDetail> cartbyId = cartDetailsRepository.findById(cartId);
			if(cartbyId.isPresent()) {
				productMap.put("product", cartbyId.get().getProduct().getId());
				productMap.put("size", cartbyId.get().getSize());
				productMap.put("color", cartbyId.get().getColor());
				productMap.put("quantity", cartbyId.get().getQuantity().toString());
				productMap.put("price", cartbyId.get().getPrice().toString());
				total_Cost += total_Cost+cartbyId.get().getPrice();
			} else {
				throw new Exception("Cart Not found..");
			}
			listOfProductInfo.add(productMap);
			}
			order.setProductInfo(listOfProductInfo);
			order.setTotal(total_Cost);
			if (!"NONE".equals(orderItem.get().getPromo())) {
			Optional<CustomerRewards> promo = promoRepository.findByCouponName(orderItem.get().getPromo());
			if (promo.isPresent()) {
				if (promo.get().getDiscountAmount() != null) {
					order.setDiscount(promo.get().getDiscountAmount());
				} else if (promo.get().getDiscountPercentage() != null) {
					order.setDiscount(total_Cost * promo.get().getDiscountPercentage()/100);
				}
			} else {
				throw new Exception("Promo Not found..");
			}
			}
			if(order.getDiscount() == null) {
				order.setFinalAmount(order.getTotal());
			} else {
				order.setFinalAmount(order.getTotal() - order.getDiscount());
			}
		} else {
			throw new Exception("User Not found..");
		}
		
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		
		Gson gson = b.create();
		order.setBillingInfo(gson.toJson(customerAddressService.customerAccountSummary(userId)));
		order.setBuyerInfo(orderPojo.getBuyerInfo());
		order.setBillingNo(orderPojo.getBillingNo());
		order.setStatus(orderPojo.getStatus());
		order.setPaymentStatus(orderPojo.getPaymentStatus());
		order.setShippingInfo(gson.toJson(customerAddressService.customerAccountSummary(userId)));
		order.setIsActive(true);
		Order orderSave = orderRepository.save(order);
		if(orderSave != null) {
			orderRepository.updateOrderWithNoActiveOrder(userId, orderSave.getId());
		}
		return orderSave;	
	}
	

	@Override
	public List<Order> orderList(String userId) {
		return orderRepository.findByCustomerAccount_Id(userId);
	}


	@Override
	public Optional<Order> order(String userId) {
		return orderRepository.findByCustomerAccount_IdAndIsActive(userId, true);
	}

}
