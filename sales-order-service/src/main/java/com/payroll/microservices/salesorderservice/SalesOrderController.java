package com.payroll.microservices.salesorderservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class SalesOrderController {

	private static Logger log = LoggerFactory.getLogger(SalesOrderController.class);

	@Autowired
	private CustomerSOSRepository custRepo;

	@Autowired
	private ItemService itemService;

	@Autowired
	private SalesOrderRepository salesOrderRepo;

	@Value("${default.message}")
	private String message;

	@RequestMapping(value = "/customersos/{id}", method = RequestMethod.GET)
	public Customer getCustomerSOSDetail(@PathVariable("id") Long id) {
		log.info("::: Inside subscriber :::");
		Optional<Customer> cust = custRepo.findById(id);
		log.info(":: Customer  :" + cust);
		return cust.get();
	}

	@RequestMapping(value = "/Orders", method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "fallbackSalesOrder")
	public SalesOrder createOrderDetail(@RequestBody SalesOrder salesOrder) {

		log.info("inside createOrderDetail");
		boolean isValidCustomer = false;
		Double totalPrice = 0.0;
		// validating items and populating orderItems
		List<OrderLineItem> lineItems = new ArrayList<OrderLineItem>();
		if (salesOrder.getInputItems() != null && salesOrder.getInputItems().size() > 0)

		{
			for (InputItem inputItem : salesOrder.getInputItems()) {
				// validating item
				boolean isValidItem = false;
				Item item = itemService.getItemDetail(inputItem.getItemName());
				isValidItem = (item != null && item.getId() != null ? true : false);
				if (isValidItem) {
					OrderLineItem lineItem = new OrderLineItem();
					// lineItem.setId(item.getId());
					lineItem.setItemName(item.getItemName());
					lineItem.setItemQuantity(inputItem.getItemQuantity());
					totalPrice = totalPrice + item.getItemPrice()*inputItem.getItemQuantity();
					lineItems.add(lineItem);

				}
			}

			log.info("total numbers of lineitem added  ", lineItems.size());
		}

		// validating the customer with cust_id
		if (salesOrder != null && salesOrder.getCustId() != null) {
			Optional<Customer> optional = custRepo.findById(salesOrder.getCustId());
			try {
				Customer cust = optional.get();
				log.info("customer validated ", isValidCustomer);
				salesOrder.setCustId(cust.getId());
				salesOrder.setTotalPrice(totalPrice);
				salesOrder.setLineItems(lineItems);
			} catch (Exception e) {
				log.error("customer not found with this id ", salesOrder.getCustId());
				throw e;
			}

		}

		SalesOrder order = salesOrderRepo.save(salesOrder);
		log.info("saved order" + order.getId());
		
		
		return order;
	}

	public SalesOrder fallbackSalesOrder(SalesOrder salesOrder)

	{
		SalesOrder order = new SalesOrder();
		order.setMessage(message);
		return order;
	}
}
