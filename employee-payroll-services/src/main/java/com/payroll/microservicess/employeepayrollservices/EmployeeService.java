package com.payroll.microservicess.employeepayrollservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "employee-service",url = "localhost:8080")
//@FeignClient(name = "employee-service")
@FeignClient(name = "ZUUL-EDGE-SERVER")
@RibbonClient(name = "employee-service")
public interface EmployeeService {
	
	@RequestMapping(value = "employee-service/employee/{id}",method=RequestMethod.GET)
	EmployeePayroll getEmployeeDetail(@PathVariable(value="id") Long id);

}
