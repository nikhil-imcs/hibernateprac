package com.imcs.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imcs.hibernate.entity.Product;

public class ProductDao implements IProductDao {

	private Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	public Product getProduct(Integer id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Product product = (Product) session.get(Product.class, id);
			transaction.commit();
			return product;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public boolean addProduct(Product product) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(product);
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

	public boolean updateProduct(Product product) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(product);
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

	public boolean deleteProduct(Integer id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Product product = (Product) session.get(Product.class, id);
			session.delete(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> getProducts(List<Integer> productIds) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		List<Product> products=new ArrayList<>();
		try{
			for(Integer p:productIds){
				Product product = (Product) session.get(Product.class, p);
				products.add(product);
			}
			transaction.commit();
			return products;
		}
		catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

}
