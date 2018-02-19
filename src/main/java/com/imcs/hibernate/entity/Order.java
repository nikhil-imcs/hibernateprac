package com.imcs.hibernate.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer id;
	@Column(name = "invoice_creation_date")
	@Temporal(TemporalType.DATE)
	private Date invoiceCreationDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_date")
	private Date deliveryDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date")
	private Date paymentDate;
	@Column(name = "custom_message")
	private String customMessage;

	@OneToMany
	@JoinColumn(name = "order_id")
	private List<OrdersProducts> ordersProducts;

	public Order() {

	}

	public Order(int id, Date invoiceCreationDate, Date deliveryDate, Date paymentDate, String customMessage) {
		super();
		this.id = id;
		this.invoiceCreationDate = invoiceCreationDate;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
		this.customMessage = customMessage;

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
		return builder.toString();
	}

}
