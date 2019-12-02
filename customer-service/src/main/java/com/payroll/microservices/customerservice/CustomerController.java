package com.payroll.microservices.customerservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repo;

	private static Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	RabbitMQSender rabbitMQSender;

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer createCustomerDetail(@RequestBody Customer cust) {
		log.info("inside createCustomerDetail");
		Customer customer = repo.save(cust);
		log.info("saved customer successfully with id" + customer.getId());
		rabbitMQSender.send(customer);
		return customer;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomerDetails() {
		log.info("inside getAllCustomerDetails");
		return repo.findAll();
	}
}
