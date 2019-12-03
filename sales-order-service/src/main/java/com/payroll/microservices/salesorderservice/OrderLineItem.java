package com.payroll.microservices.salesorderservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_line_item")
public class OrderLineItem implements Serializable {

	private static final long serialVersionUID = 1l;
	@Id
	@Column(name = "order_line_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @ManyToOne(cascade = CascadeType.ALL
	// @JoinColumn(name = "order_id")
	// private SalesOrder salesOrder;

	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_quantity")
	private Integer itemQuantity;

	public OrderLineItem() {

	}

	public OrderLineItem(Long id, SalesOrder salesOrder, String itemName, Integer itemQuantity) {
		super();
		this.id = id;
		// this.salesOrder = salesOrder;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
