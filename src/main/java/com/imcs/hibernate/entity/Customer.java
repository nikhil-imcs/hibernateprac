package com.imcs.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cust_id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="middle_name")
	private String middleName;
	@Column(name="suffix")
	private String suffix;
	@Column(name="email")
	private String email;
	@Column(name="company")
	private String company;
	@Column(name="display_name")
	private String displayName;
	@Column(name="print_on_check_as")
	private String printOnCheckAs;
	@Column(name="other_details")
	private String otherDetails;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany
	@JoinColumn(name="cust_id")
	private List<Order> orders;
	
	public Customer(){
		
	}
	
	public boolean addOrder(Order order){
		if(orders==null){
			orders=new ArrayList<Order>();
		}
		boolean status=orders.add(order);
		return status;
	}
	
	public boolean removeOrder(Order order){
		boolean status=orders.remove(order);
		return status;
		
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPrintOnCheckAs() {
		return printOnCheckAs;
	}

	public void setPrintOnCheckAs(String printOnCheckAs) {
		this.printOnCheckAs = printOnCheckAs;
	}

	
	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", suffix=");
		builder.append(suffix);
		builder.append(", email=");
		builder.append(email);
		builder.append(", company=");
		builder.append(company);
		builder.append(", displayName=");
		builder.append(displayName);
		builder.append(", printOnCheckAs=");
		builder.append(printOnCheckAs);
		builder.append(", otherDetails=");
		builder.append(otherDetails);
		builder.append(", orders=");
		builder.append(orders);
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
	
	
	

}
