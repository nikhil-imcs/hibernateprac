package com.imcs.hibernate.dao;

import java.util.List;

import com.imcs.hibernate.entity.OrdersProducts;


public interface IOrdersProductsDao {
	
	OrdersProducts getOrdersProducts(Integer id);

	boolean addOrdersProducts(OrdersProducts op);

	boolean updateOrdersProducts(OrdersProducts op);

	boolean deleteOrdersProducts(Integer id);

	List<Integer> getProductIdsByOrderId(Integer orderId);

	

}
