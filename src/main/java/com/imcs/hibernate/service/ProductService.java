package com.imcs.hibernate.service;

import java.util.List;

import com.imcs.hibernate.dao.IProductDao;
import com.imcs.hibernate.dao.ProductDao;
import com.imcs.hibernate.entity.Product;

public class ProductService implements IProductService {
	
	private IProductDao productDao=new ProductDao();

	public Product getProduct(Integer id) {
		Product product=productDao.getProduct(id);
		return product;
	}

	public boolean addProduct(Product product) {
		boolean status=productDao.addProduct(product);
		return status;
	}

	public boolean updateProduct(Product product) {
		boolean status=productDao.updateProduct(product);
		return status;
	}

	public boolean deleteProduct(Integer id) {
		boolean status=productDao.deleteProduct(id);
		return status;
	}

	public List<Product> getProducts(List<Integer> productIds) {
		List<Product> products=productDao.getProducts(productIds);
		return products;
	}

}
