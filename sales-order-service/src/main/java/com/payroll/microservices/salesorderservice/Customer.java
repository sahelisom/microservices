package com.payroll.microservices.salesorderservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_SOS")
public class Customer {

	@Column(name = "cust_first_name")
	private String firstName;

	@Column(name = "cust_last_name")
	private String lastName;

	@Id
	@Column(name = "cust_id")
	private Long id;

	@Column(name = "cust_email")
	private String email;

	public Customer(String firstName, String lastName, Long id, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
	}

	public Customer() {

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
