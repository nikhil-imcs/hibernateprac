package com.imcs.hibernate.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer id;
	private String name;
	private String description;
	private double price;

	@OneToMany
	@JoinColumn(name = "product_id")
	private List<OrdersProducts> ordersProducts;

	public Product() {

	}

	public Product(Integer id, String name, String description, double price, List<OrdersProducts> ordersProducts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ordersProducts = ordersProducts;
	}

	public List<OrdersProducts> getOrdersProducts() {
		return ordersProducts;
	}

	public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
		this.ordersProducts = ordersProducts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}
