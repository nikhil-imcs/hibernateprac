package com.imcs.hibernate.service;

import com.imcs.hibernate.dao.CustomerDao;
import com.imcs.hibernate.dao.ICustomerDao;
import com.imcs.hibernate.entity.Customer;

public class CustomerService implements ICustomerService {
	
	private ICustomerDao customerDao=new CustomerDao();

	public boolean addCustomer(Customer customer) {
		boolean status=customerDao.addCustomer(customer);
		return status;
	}

	public boolean updateCustomer(Customer customer) {
		boolean status=customerDao.updateCustomer(customer);
		return status;
	}

	public boolean deleteCustomer(int id) {
		boolean status=customerDao.deleteCustomer(id);
		return status;
	}

	public Customer getCustomer(int id) {
		Customer customer=customerDao.getCustomer(id);
		return customer;
	}

}
