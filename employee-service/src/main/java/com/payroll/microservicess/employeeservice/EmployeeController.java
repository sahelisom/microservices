package com.payroll.microservicess.employeeservice;


import java.util.Date;

import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class EmployeeController {
	
	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private Environment env;
		
	@Autowired
	private EmployeeConfiguration properties;
	
	@RequestMapping(value = "employee/{id}",method=RequestMethod.GET)
	public Employee getEmployeeDetail(@PathVariable Long id)
	{
		//Employee emp =new Employee("saheli", "som", id, new Date());
		
		log.info("inside EmployeeController getEmployeeDetail method" );
		Employee emp= repo.findOne(id);
		emp.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return emp;
		
	}
	@RequestMapping(value = "employee/fault-tolerance",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "fallbackEmployeeDetail")
	public Employee getEmployeeDetailFaultTolerance()
	{
		throw new RuntimeException("exceptiom");
		
		
	}
	
	public Employee fallbackEmployeeDetail()
	{
		return new Employee(properties.getDefaultFirstName(), properties.getDefaultLastName(), 1l, new Date());
	}

}
