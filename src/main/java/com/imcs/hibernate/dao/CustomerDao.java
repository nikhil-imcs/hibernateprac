package com.imcs.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imcs.hibernate.entity.Customer;

import com.imcs.hibernate.dao.HibernateUtils;

public class CustomerDao implements ICustomerDao {
	
	private Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	public boolean addCustomer(Customer customer) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.save(customer);
			transaction.commit();
			return true;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		finally{
			session.close();
		}
	}

	public boolean updateCustomer(Customer customer) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.update(customer);
			transaction.commit();
			return true;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		finally{
			session.close();
		}
	}

	public boolean deleteCustomer(int id) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try{
			Customer customer=(Customer) session.get(Customer.class, id);
			session.delete(customer);
			transaction.commit();
			return true;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public Customer getCustomer(int id) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try{
			Customer customer=(Customer) session.get(Customer.class, id);
			transaction.commit();
			return customer;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

}
