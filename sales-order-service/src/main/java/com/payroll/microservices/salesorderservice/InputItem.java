package com.payroll.microservices.salesorderservice;

public class InputItem {
	
	private String itemName;
	private Integer itemQuantity;
	
	public InputItem()
	{
		
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

}
