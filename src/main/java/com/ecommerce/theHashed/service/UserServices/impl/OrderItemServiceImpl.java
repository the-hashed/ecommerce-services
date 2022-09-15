package com.ecommerce.theHashed.service.UserServices.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.theHashed.Repository.CustomerAccountRepository;
import com.ecommerce.theHashed.Repository.CustomerRewardsRepository;
import com.ecommerce.theHashed.Repository.OrderItemRepository;
import com.ecommerce.theHashed.model.CartDetail;
import com.ecommerce.theHashed.model.CustomerAccount;
import com.ecommerce.theHashed.model.CustomerRewards;
import com.ecommerce.theHashed.model.OrderItem;
import com.ecommerce.theHashed.pojo.OrderItemPojo;
import com.ecommerce.theHashed.service.UserServices.CartDetailsService;
import com.ecommerce.theHashed.service.UserServices.CustomerAddressService;
import com.ecommerce.theHashed.service.UserServices.CustomerCardService;
import com.ecommerce.theHashed.service.UserServices.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	CustomerAccountRepository userRepo;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	CustomerAddressService customerAddressService;
	
	@Autowired
	CustomerCardService customerCardService;
	
	@Autowired
	CartDetailsService cartDetailsService;
	
	@Autowired
	CustomerRewardsRepository promoRepository;
	
	@Autowired
	EntityManager em;

	@Override
	@Transactional
	public OrderItem addOrderItem(OrderItemPojo orderItemPojo, String userId) throws Exception {

		Optional<OrderItem> opOrderItem = orderItemRepository.findByCustomerAccount_Id(userId);
		if (opOrderItem.isPresent()) {
			List<CartDetail> listOfCartDetails = cartDetailsService.customerCart(userId);
			if(listOfCartDetails.isEmpty()) {
				throw new Exception("Cart Not found..");
			} else {
			opOrderItem.get().setCartDetail(
					listOfCartDetails.stream().map(id -> id.getId()).map(Object::toString).toArray(String[]::new));
			Long quantity = listOfCartDetails.stream().map(id -> id.getId()).count();
			opOrderItem.get().setQuantity(quantity.intValue());
			}
			opOrderItem.get().setCreatedAt(new Timestamp(System.currentTimeMillis()));
			Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
			if (customerAccountbyId.isPresent()) {
				opOrderItem.get().setCreatedBy(customerAccountbyId.get());
				opOrderItem.get().setCustomerAccount(customerAccountbyId.get());
			} else {
				throw new Exception("User Not found..");
			}
			opOrderItem.get().setCustomerAddress(customerAddressService.customerAccountSummary(userId));
			opOrderItem.get().setCustomerCard(customerCardService.customerCard(userId));
			opOrderItem.get().setDeliveryMethod(orderItemPojo.getDeliveryMethod());
			if (!"NONE".equals(orderItemPojo.getPromo())) {
				Optional<CustomerRewards> promo = promoRepository.findByCouponName(orderItemPojo.getPromo());
				if (promo.isPresent()) {
					opOrderItem.get().setPromo(orderItemPojo.getPromo());
				} else {
					throw new Exception("Promo Not found..");
				}
			}

			return orderItemRepository.save(opOrderItem.get());
		} else {
			OrderItem orderItem = new OrderItem();
			String uniqueID = UUID.randomUUID().toString();
			orderItem.setId(uniqueID);
			List<CartDetail> listOfCartDetails = cartDetailsService.customerCart(userId);
			orderItem.setCartDetail(
					listOfCartDetails.stream().map(id -> id.getId()).map(Object::toString).toArray(String[]::new));
			Long quantity = listOfCartDetails.stream().map(id -> id.getId()).count();
			orderItem.setQuantity(quantity.intValue());
			orderItem.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			Optional<CustomerAccount> customerAccountbyId = userRepo.findById(userId);
			if (customerAccountbyId.isPresent()) {
				orderItem.setCreatedBy(customerAccountbyId.get());
				orderItem.setCustomerAccount(customerAccountbyId.get());
			} else {
				throw new Exception("User Not found..");
			}
			orderItem.setCustomerAddress(customerAddressService.customerAccountSummary(userId));
			orderItem.setCustomerCard(customerCardService.customerCard(userId));
			orderItem.setDeliveryMethod(orderItemPojo.getDeliveryMethod());
			orderItem.setPromo(orderItemPojo.getPromo());
			return orderItemRepository.save(orderItem);
		}
	}

	@Override
	public void deleteOrderItem(String userId) {
		orderItemRepository.deleteByCustomerAccount_Id(userId);
	}
	
	@Override
	public void deleteOrderItemById(String id) {
		orderItemRepository.deleteById(id);
	}

	@Override
	public Optional<OrderItem> orderItem(String userId) {
		return orderItemRepository.findByCustomerAccount_Id(userId);
	}

}
