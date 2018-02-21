package com.imcs.hibernate.service;

import java.util.Date;
import java.util.List;

import com.imcs.hibernate.dao.IOrderDao;
import com.imcs.hibernate.dao.OrderDao;
import com.imcs.hibernate.entity.Order;
import com.imcs.hibernate.entity.Product;

public class OrderService implements IOrderService {

	private IOrderDao orderDao = new OrderDao();

	public Order getOrder(Integer id) {
		Order order = orderDao.getOrder(id);
		return order;
	}

	public boolean addOrder(Order order) {
		boolean status = orderDao.addOrder(order);
		return status;
	}

	public boolean updateOrder(Order order) {
		boolean status = orderDao.updateOrder(order);
		return status;
	}

	public boolean deleteOrder(Integer id) {
		boolean status = orderDao.deleteOrder(id);
		return status;
	}

	@Override
	public List<Order> getOrdersByInvoiceRange(Date d1, Date d2) {
		List<Order> orders = orderDao.getOrdersByInvoiceRange(d1, d2);
		return orders;
	}

	@Override
	public List<Order> getOrdersByDeliveryRange(Date d1, Date d2) {
		List<Order> orders = orderDao.getOrdersByDeliveryRange(d1, d2);
		return orders;
	}

	@Override
	public boolean setTotalOrderPrice(List<Product> products, Order o) {
		Double totalOrderPrice = 0.0;
		for (Product p : products) {
			totalOrderPrice = totalOrderPrice + p.getPrice();
		}

		boolean status = orderDao.setTotalOrderPrice(totalOrderPrice, o);
		return status;

	}

	@Override
	public List<Order> getOrdersGreaterByGivenTotalOrderPrice(Double totalOrderPrice) {
		List<Order> orders=orderDao.getOrdersGreaterByGivenTotalOrderPrice(totalOrderPrice);
		return orders;
	}

	@Override
	public List<Order> getOrdersByOrderStatus(String status) {
		String orderStatus=status.toLowerCase();
		List<Order> orders=orderDao.getOrdersByOrderStatus(orderStatus);
		return orders;
	}

}
