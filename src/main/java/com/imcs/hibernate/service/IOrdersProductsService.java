package com.imcs.hibernate.service;


import java.util.List;

import com.imcs.hibernate.entity.OrdersProducts;

public interface IOrdersProductsService {

	OrdersProducts getOrdersProducts(Integer id);

	boolean addOrdersProducts(OrdersProducts op);

	boolean updateOrdersProducts(OrdersProducts op);

	boolean deleteOrdersProducts(Integer id);
	
	List<Integer> getProductIdsByOrderId(Integer orderId);
	
	
	

}
