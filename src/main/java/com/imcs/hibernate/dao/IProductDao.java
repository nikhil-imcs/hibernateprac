package com.imcs.hibernate.dao;

import java.util.List;

import com.imcs.hibernate.entity.Product;

public interface IProductDao {
	
	Product getProduct(Integer id);

	boolean addProduct(Product product);

	boolean updateProduct(Product product);

	boolean deleteProduct(Integer id);

	List<Product> getProducts(List<Integer> productIds);

}
