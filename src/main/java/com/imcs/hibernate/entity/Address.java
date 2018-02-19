package com.imcs.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer id;

	@Column(name = "billing_street")
	private String billingStreet;
	@Column(name = "billing_city")
	private String billingCity;
	@Column(name = "billing_state")
	private String billingState;
	@Column(name = "billing_zip")
	private String billingZip;
	@Column(name = "billing_country")
	private String billingCountry;
	@Column(name = "shipping_street")
	private String shippingStreet;
	@Column(name = "shipping_city")
	private String shippingCity;
	@Column(name = "shipping_state")
	private String shippingState;
	@Column(name = "shipping_zip")
	private String shippingZip;
	@Column(name = "shipping_country")
	private String shippingCountry;

	public Address() {

	}

	public Address(Integer id, String billingStreet, String billingCity, String billingState, String billingZip,
			String billingCountry, String shippingStreet, String shippingCity, String shippingState, String shippingZip,
			String shippingCountry) {
		super();
		this.id = id;
		this.billingStreet = billingStreet;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
		this.billingCountry = billingCountry;
		this.shippingStreet = shippingStreet;
		this.shippingCity = shippingCity;
		this.shippingState = shippingState;
		this.shippingZip = shippingZip;
		this.shippingCountry = shippingCountry;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getShippingStreet() {
		return shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingZip() {
		return shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", billingStreet=");
		builder.append(billingStreet);
		builder.append(", billingCity=");
		builder.append(billingCity);
		builder.append(", billingState=");
		builder.append(billingState);
		builder.append(", billingZip=");
		builder.append(billingZip);
		builder.append(", billingCountry=");
		builder.append(billingCountry);
		builder.append(", shippingStreet=");
		builder.append(shippingStreet);
		builder.append(", shippingCity=");
		builder.append(shippingCity);
		builder.append(", shippingState=");
		builder.append(shippingState);
		builder.append(", shippingZip=");
		builder.append(shippingZip);
		builder.append(", shippingCountry=");
		builder.append(shippingCountry);
		builder.append("]");
		return builder.toString();
	}

}
