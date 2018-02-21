package com.imcs.hibernate.apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.imcs.hibernate.entity.Address;
import com.imcs.hibernate.entity.Customer;
import com.imcs.hibernate.entity.Order;
import com.imcs.hibernate.entity.OrdersProducts;
import com.imcs.hibernate.entity.Product;
import com.imcs.hibernate.service.CustomerService;
import com.imcs.hibernate.service.ICustomerService;
import com.imcs.hibernate.service.IOrderService;
import com.imcs.hibernate.service.IOrdersProductsService;
import com.imcs.hibernate.service.IProductService;
import com.imcs.hibernate.service.OrderService;
import com.imcs.hibernate.service.OrdersProductsService;
import com.imcs.hibernate.service.ProductService;

public class App {

	public static void main(String[] args) throws ParseException {

		/*// 1.Creating a Customer Object c1
		Customer c1 = new Customer();
		c1.setFirstName("Nikhil");
		c1.setLastName("Shende");
		c1.setEmail("niks@gmail.com");
		c1.setCompany("IMCS");

		// 2.Creating an Address Object for Customer c1
		Address address1 = new Address();
		address1.setShippingStreet("6445 Love Dr");
		address1.setShippingCity("Irving");
		address1.setShippingState("TX");
		address1.setShippingZip("76058");

		// 3.Associating Address to Customer c1
		c1.setAddress(address1);

		// 1b.Creating a Customer Object c2
		Customer c2 = new Customer();
		c2.setFirstName("Praveen");
		c2.setLastName("Kumar");
		c2.setEmail("praveen@gmail.com");
		c2.setCompany("IMCS");

		// 2b.Creating an Address Object for Customer c2
		Address address2 = new Address();
		address2.setShippingStreet("1036 Love Dr");
		address2.setShippingCity("Irving");
		address2.setShippingState("TX");
		address2.setShippingZip("76060");

		// 3b.Associating Address to Customer c2
		c2.setAddress(address2);
		
		//4 Creating Orders Object for Customer c1
		Order o1=new Order();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		Date invoiceCreationDate=sdf.parse("02/15/2018");
		o1.setInvoiceCreationDate(invoiceCreationDate);
		Date deliveryDate=sdf.parse("02/25/2018");
		o1.setDeliveryDate(deliveryDate);
		Date paymentDate=sdf.parse("02/21/2018");
		o1.setPaymentDate(paymentDate);
		o1.setOrderStatus();
		
		Order o2=new Order();
		Date invoiceCreationDate1=sdf.parse("02/17/2018");
		o2.setInvoiceCreationDate(invoiceCreationDate1);
		Date deliveryDate1=sdf.parse("02/27/2018");
		o2.setDeliveryDate(deliveryDate1);
		Date paymentDate1=sdf.parse("02/23/2018");
		o2.setPaymentDate(paymentDate1);
		o2.setOrderStatus();
		
		//5 Creating Products
		Product p1=new Product();
		p1.setName("Phone");
		p1.setDescription("Iphone 7 plus");
		p1.setPrice(750.0);
		
		Product p2=new Product();
		p2.setName("Laptop");
		p2.setDescription("HP Laptop");
		p2.setPrice(550.0);
		
		//6 Adding Customers and Orders into Database by cascade operation on Orders
		c1.addOrder(o1);
		c2.addOrder(o2);
		ICustomerService customerService=new CustomerService();
		customerService.addCustomer(c1);
		customerService.addCustomer(c2);
		
		//7 Adding Products into the Database
		IProductService productService=new ProductService();
		productService.addProduct(p1);
		productService.addProduct(p2);
		
		//8 Creating OrdersProducts objects
		OrdersProducts ordersProducts=new OrdersProducts();
		ordersProducts.setOrder(o1);
		ordersProducts.setProduct(p1);
		ordersProducts.setQuantity(2);
		
		OrdersProducts ordersProducts1=new OrdersProducts();
		ordersProducts1.setOrder(o1);
		ordersProducts1.setProduct(p2);
		ordersProducts1.setQuantity(3);
		
		OrdersProducts ordersProducts2=new OrdersProducts();
		ordersProducts2.setOrder(o2);
		ordersProducts2.setProduct(p1);
		ordersProducts2.setQuantity(2);
		
		//9 Adding OrdersProducts into the Database
		IOrdersProductsService ordersProductsService=new OrdersProductsService();
		ordersProductsService.addOrdersProducts(ordersProducts);
		ordersProductsService.addOrdersProducts(ordersProducts1);
		ordersProductsService.addOrdersProducts(ordersProducts2);
		
		//10 Setting the Total Order Price for Orders
		List<Integer> productIds=ordersProductsService.getProductIdsByOrderId(1);
		List<Integer> productIds1=ordersProductsService.getProductIdsByOrderId(2);
		List<Product> products=productService.getProducts(productIds);
		List<Product> products1=productService.getProducts(productIds1);
		IOrderService orderService=new OrderService();
		orderService.setTotalOrderPrice(products, o1);
		orderService.setTotalOrderPrice(products1, o2);*/
		
		//**********************************************************************
		//Ready to Make Operations on Database
		SimpleDateFormat sdf1=new SimpleDateFormat("MM/dd/yyyy");
		IOrderService orderService1=new OrderService();
		
		//1 Get Orders by Invoice creation Date range
		Date lowDate=sdf1.parse("02/14/2018");
		Date highDate=sdf1.parse("02/29/2018");
		List<Order> orders_invoice=orderService1.getOrdersByInvoiceRange(lowDate, highDate);
		System.out.println("Orders in the Range of :"+lowDate+" and "+highDate+" based on Invoice Creation Date");
		System.out.println("#####################################################");
		for(Order o:orders_invoice){
			System.out.println(o);
		}
		System.out.println("***************************************************************");
		
		//2 Get Orders by Delivery Date range
		List<Order> orders_delivery=orderService1.getOrdersByDeliveryRange(lowDate, highDate);
		System.out.println("Orders in the Range of :"+lowDate+" and "+highDate+" based on Delivery Date");
		System.out.println("#####################################################");
		for(Order o:orders_delivery){
			System.out.println(o);
		}
		System.out.println("***************************************************************");
		
		//3 Get Orders By Order Price
		double torderPrice=1000.0;
		List<Order> orders_totalPrice=orderService1.getOrdersGreaterByGivenTotalOrderPrice(torderPrice);
		System.out.println("Orders whose Total Order Price is greater than->"+ torderPrice);
		System.out.println("#####################################################");
		for(Order o:orders_totalPrice){
			System.out.println(o);
		}
		System.out.println("***************************************************************");
		
		//4 Get Orders based on Order Status
		String status="processing";
		List<Order> orders_status=orderService1.getOrdersByOrderStatus(status);
		System.out.println("Orders which are at a status of :"+status);
		System.out.println("#####################################################");
		for(Order o:orders_status){
			System.out.println(o);
		}
		System.out.println("***************************************************************");
		
		//5 Fetch Products in a particular Order
		IOrdersProductsService ordersProductsService1=new OrdersProductsService();
		List<Integer> productIds1=ordersProductsService1.getProductIdsByOrderId(1);
		IProductService productService1=new ProductService();
		List<Product> products1=productService1.getProducts(productIds1);
		System.out.println("Products for Order Id 1");
		System.out.println("#####################################################");
		for(Product p:products1){
			System.out.println(p);
		}
		System.out.println("***************************************************************");
		System.out.println("Thank you for using this application....");
		
		
		
		
		
		
		
		
		
		

	}

}
