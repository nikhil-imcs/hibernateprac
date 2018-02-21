package com.imcs.hibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.imcs.hibernate.entity.Order;

public class OrderDao implements IOrderDao {

	private Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	public Order getOrder(Integer id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Order order = (Order) session.get(Order.class, id);
			transaction.commit();
			return order;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public boolean addOrder(Order order) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(order);
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

	public boolean updateOrder(Order order) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(order);
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

	public boolean deleteOrder(Integer id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Order order = (Order) session.get(Order.class, id);
			session.delete(order);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Order> getOrdersByInvoiceRange(Date d1, Date d2) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Order.class);
			criteria.add(Restrictions.between("invoiceCreationDate", d1, d2));
			@SuppressWarnings("unchecked")
			List<Order> orders = criteria.list();
			return orders;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Order> getOrdersByDeliveryRange(Date d1, Date d2) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Order.class);
			criteria.add(Restrictions.between("deliveryDate", d1, d2));
			@SuppressWarnings("unchecked")
			List<Order> orders = criteria.list();
			return orders;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean setTotalOrderPrice(Double totalOrderPrice, Order o) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Integer id = o.getId();
			Query query = session
					.createSQLQuery("update orders set total_order_price=:totalOrderPrice where order_id=:orderId");
			query.setParameter("totalOrderPrice", totalOrderPrice);
			query.setParameter("orderId", id);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Order> getOrdersGreaterByGivenTotalOrderPrice(Double totalOrderPrice) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query query = session.createQuery("from Order o where o.totalOrderPrice >:totalOrderPrice");
			query.setParameter("totalOrderPrice", totalOrderPrice);
			@SuppressWarnings("unchecked")
			List<Order> orders = query.list();
			transaction.commit();
			return orders;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Order> getOrdersByOrderStatus(String orderStatus) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try{
			Criteria criteria=session.createCriteria(Order.class);
			criteria.add(Restrictions.like("orderStatus", orderStatus));
			
			@SuppressWarnings("unchecked")
			List<Order> orders=criteria.list();
			transaction.commit();
			return orders;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

}
