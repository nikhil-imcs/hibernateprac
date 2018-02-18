package com.imcs.hibernate.service;

import com.imcs.hibernate.entity.Customer;

public interface ICustomerService {
	
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer getCustomer(int id);
	

}
