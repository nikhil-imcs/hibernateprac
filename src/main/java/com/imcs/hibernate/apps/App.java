package com.imcs.hibernate.apps;

import com.imcs.hibernate.entity.Customer;
import com.imcs.hibernate.service.CustomerService;
import com.imcs.hibernate.service.ICustomerService;

public class App {

	public static void main(String[] args) {
		Customer c=new Customer();
		c.setFirstName("Nikhil");
		
		ICustomerService serv=new CustomerService();
		serv.addCustomer(c);
		
		

	}

}
