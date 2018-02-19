package com.imcs.hibernate.apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.imcs.hibernate.entity.Customer;
import com.imcs.hibernate.entity.Order;
import com.imcs.hibernate.entity.Product;
import com.imcs.hibernate.service.CustomerService;
import com.imcs.hibernate.service.ICustomerService;

public class App {

	public static void main(String[] args) throws ParseException {
		System.out.println("Adding Customer Info into the Database");
		/*Product p1=new Product();
		p1.setName("Computer");
		p1.setDescription("HP Laptop");
		p1.setPrice(1000);
		
		Product p2=new Product();
		p2.setName("Phone");
		p2.setDescription("Iphone 7 plus");
		p2.setPrice(750);*/
		
		Customer c1=new Customer();
		c1.setFirstName("Nikhil");
		c1.setLastName("Shende");
		c1.setEmail("niks@gmail.com");
		c1.setCompany("imcs");
		
		/*Order o1=new Order();
		SimpleDateFormat s=new SimpleDateFormat("MM/dd/yyyy");
		Date paymentDate=s.parse("02/18/2018");
		Date deliveryDate=s.parse("02/20/2018");
		o1.setPaymentDate(paymentDate);
		o1.setDeliveryDate(deliveryDate);
		o1.add(p1);
		o1.add(p2);
		o1.setCustomer(c1);
		
		c1.addOrder(o1);*/
		
		System.out.println(c1);
		ICustomerService customerService=new CustomerService();
		//customerService.addCustomer(c1);
		/*Customer c=customerService.getCustomer(1);
		System.out.println(c);*/
		//System.out.println("Customer Added to the Database");
		Customer customer2=customerService.getCustomer(1);
		System.out.println(customer2);
		
		

	}

}
