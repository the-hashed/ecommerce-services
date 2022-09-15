package com.ecommerce.theHashed.service.UserServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.theHashed.model.CartDetail;
import com.ecommerce.theHashed.pojo.CartDetailPojo;

@Service
public interface CartDetailsService {

	CartDetail addCustomerCart(CartDetailPojo cartDetailPojo, String userId) throws Exception;

	CartDetail updateCustomerCart(CartDetailPojo cartDetailPojo, String userId) throws Exception;

	void deleteCustomerCart(String cartId, String userId);

	List<CartDetail> customerCart(String userId);

	Integer countAccountCart(String userId);

}
