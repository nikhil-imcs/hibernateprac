package com.imcs.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int id;
	@Column(name="invoice_creation_date")
	private Date invoiceCreationDate;
	@Column(name="delivery_date")
	private Date deliveryDate;
	@Column(name="payment_date")
	private Date paymentDate;
	@Column(name="custom_message")
	private String customMessage;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	public Order(){
		
	}

	public Order(int id, Date invoiceCreationDate, Date deliveryDate, Date paymentDate, String customMessage,
			List<Product> products) {
		super();
		this.id = id;
		this.invoiceCreationDate = invoiceCreationDate;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
		this.customMessage = customMessage;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInvoiceCreationDate() {
		return invoiceCreationDate;
	}

	public void setInvoiceCreationDate(Date invoiceCreationDate) {
		this.invoiceCreationDate = invoiceCreationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public boolean add(Product product){
		if(products==null){
			products=new ArrayList<Product>();
		}
		
		boolean status=products.add(product);
		return status;
	}
	
	public boolean deleteProduct(Product product){
		boolean status=products.remove(product);
		return status;
	}
	
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", invoiceCreationDate=");
		builder.append(invoiceCreationDate);
		builder.append(", deliveryDate=");
		builder.append(deliveryDate);
		builder.append(", paymentDate=");
		builder.append(paymentDate);
		builder.append(", customMessage=");
		builder.append(customMessage);
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}
	
	

}
