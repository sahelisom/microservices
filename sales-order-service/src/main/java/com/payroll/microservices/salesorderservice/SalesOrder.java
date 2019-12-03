package com.payroll.microservices.salesorderservice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sales_order")
public class SalesOrder implements Serializable{

	private static final long serialVersionUID = 1l;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "order_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date orderDate;

	@Column(name = "cust_id")
	private Long custId;
	
	@Column(name = "order_desc")
	private String orderDesc;

	@Column(name = "total_price")
	private Double totalPrice;

	@OneToMany(cascade = { CascadeType.ALL},orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private List<OrderLineItem> lineItems;
	
	@Transient
	private List<InputItem> inputItems;
	
	@Transient
	private String message;

	public SalesOrder(Long id, Date orderDate, Long custId, String orderDesc, Double totalPrice) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
	}

	public SalesOrder() {

	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	

	public List<OrderLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<OrderLineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public List<InputItem> getInputItems() {
		return inputItems;
	}

	public void setInputItems(List<InputItem> inputItems) {
		this.inputItems = inputItems;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
