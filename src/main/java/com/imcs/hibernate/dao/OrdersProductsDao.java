package com.imcs.hibernate.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.imcs.hibernate.entity.OrdersProducts;


public class OrdersProductsDao implements IOrdersProductsDao {
	
	private Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	public OrdersProducts getOrdersProducts(Integer id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			OrdersProducts op = (OrdersProducts) session.get(OrdersProducts.class, id);
			transaction.commit();
			return op;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public boolean addOrdersProducts(OrdersProducts op) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(op);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean updateOrdersProducts(OrdersProducts op) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(op);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean deleteOrdersProducts(Integer id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			OrdersProducts op = (OrdersProducts) session.get(OrdersProducts.class, id);
			session.delete(op);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public List<Integer> getProductIdsByOrderId(Integer orderId) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try{
			Query query=session.createSQLQuery("select product_id from customerschema.orders_products where order_id=:orderId");
			query.setParameter("orderId", orderId);
			@SuppressWarnings("unchecked")
			List<Integer> productIds=query.list();
			System.out.println(productIds);
			transaction.commit();
			return productIds;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	

}
