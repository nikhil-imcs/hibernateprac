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
	
	

	

}
