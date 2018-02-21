package com.imcs.hibernate.service;

import java.util.Date;
import java.util.List;

import com.imcs.hibernate.entity.Order;
import com.imcs.hibernate.entity.Product;

public interface IOrderService {

	Order getOrder(Integer id);

	boolean addOrder(Order order);

	boolean updateOrder(Order order);

	boolean deleteOrder(Integer id);

	List<Order> getOrdersByInvoiceRange(Date d1, Date d2);

	List<Order> getOrdersByDeliveryRange(Date d1, Date d2);

	boolean setTotalOrderPrice(List<Product> products, Order o);

	List<Order> getOrdersGreaterByGivenTotalOrderPrice(Double totalOrderPrice);

	List<Order> getOrdersByOrderStatus(String status);

}
