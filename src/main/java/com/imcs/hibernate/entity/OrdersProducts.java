package com.imcs.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders_products")
public class OrdersProducts {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_products_id")
	private int id;
	private int quantity;
	/*@Column(name="order_id")
	private int orderId;
	@Column(name="product_id")
	private int productId;*/
	
	public OrdersProducts(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}
	
	

	/*public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	*/
	

}
