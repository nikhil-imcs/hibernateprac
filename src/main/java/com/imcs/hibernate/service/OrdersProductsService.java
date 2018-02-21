package com.imcs.hibernate.service;

import java.util.List;

import com.imcs.hibernate.dao.IOrdersProductsDao;
import com.imcs.hibernate.dao.OrdersProductsDao;
import com.imcs.hibernate.entity.OrdersProducts;


public class OrdersProductsService implements IOrdersProductsService {
	
	private IOrdersProductsDao opDao=new OrdersProductsDao();

	public OrdersProducts getOrdersProducts(Integer id) {
		OrdersProducts op=opDao.getOrdersProducts(id);
		return op;
	}

	public boolean addOrdersProducts(OrdersProducts op) {
		boolean status=opDao.addOrdersProducts(op);
		return status;
	}

	public boolean updateOrdersProducts(OrdersProducts op) {
		boolean status=opDao.updateOrdersProducts(op);
		return status;
	}

	public boolean deleteOrdersProducts(Integer id) {
		boolean status=opDao.deleteOrdersProducts(id);
		return status;
	}

	public List<Integer> getProductIdsByOrderId(Integer orderId) {
		List<Integer> productIds=opDao.getProductIdsByOrderId(orderId);
		return productIds;
	}

	

}
