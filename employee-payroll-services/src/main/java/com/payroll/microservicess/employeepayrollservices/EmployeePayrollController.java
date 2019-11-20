package com.payroll.microservicess.employeepayrollservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayrollController {

	@Autowired
	private EmployeePayrollRepository repo;

	@Autowired
	private EmployeeService empService;

	@Autowired
	//private RoleService roleService;
	
	private static Logger log = LoggerFactory.getLogger(EmployeePayrollController.class);

	@RequestMapping(value = "/employee/{empId}/role/{roleName}", method = RequestMethod.POST)
	public EmployeePayroll insertEmployeePayrollDetail(@PathVariable Long empId, @PathVariable String roleName) {
		// EmployeePayroll empPayroll = new
		// EmployeePayroll(1l,101l,"saheli","som",10001l,"HR","Human resources");

		// resttemplate
		/*
		 * ResponseEntity<EmployeePayroll> entity =new
		 * RestTemplate().getForEntity("http://localhost:8080/employee/{id}",
		 * EmployeePayroll.class,empId);
		 * 
		 * ResponseEntity<EmployeePayroll> roleEntity = new RestTemplate()
		 * .getForEntity("http://localhost:8101/role/{roleName}", EmployeePayroll.class,
		 * roleName);
		 */

		// feign client implementation
		log.info("inside EmployeePayrollController");
		EmployeePayroll empPayroll = empService.getEmployeeDetail(empId);
		//EmployeePayroll roleDetail = roleService.getRoleDetail(roleName);

		// EmployeePayroll empPayroll= entity.getBody();
		/*empPayroll.setRoleName(roleDetail.getRoleName());
		empPayroll.setDescription(roleDetail.getDescription());
		empPayroll.setId(roleDetail.getId());*/
		/*
		 * empPayroll.setEmpId(101l); empPayroll.setFirstName("saheli");
		 * empPayroll.setLastName("som"); empPayroll.setRoleName("HR");
		 * empPayroll.setId(10001l); empPayroll.setDescription("Human resources");
		 */
		repo.save(empPayroll);
		return empPayroll;
	}

}
