package com.payroll.microservicess.employeepayrollservices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayroll {
	
	@Id
	@Column(name="payroll_id")
	@GeneratedValue
	private Long payrollId;
	
	@Column(name="emp_id")
	private Long empId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
		
	@Column(name = "role_id")
	private Long id;
	
	@Column(name = "role_name")
	private String roleName;

	@Transient
	private int port;
	

	public EmployeePayroll(Long payrollId, Long empId, String firstName, String lastName, Long id, String roleName,
			String description) {
		super();
		this.payrollId = payrollId;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.roleName = roleName;
		this.description = description;
	}

	@Column(name = "description")
	private String description;
	
	
	public EmployeePayroll() {
		
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
