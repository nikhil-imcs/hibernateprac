package com.imcs.hibernate.dao;

import com.imcs.hibernate.entity.Customer;

public interface ICustomerDao {

	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer getCustomer(int id);
}
