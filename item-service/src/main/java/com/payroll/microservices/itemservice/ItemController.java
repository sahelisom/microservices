package com.payroll.microservices.itemservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository repo;
	@Autowired
	private Environment env;

	private static Logger log = LoggerFactory.getLogger(ItemController.class);

	@RequestMapping(value = "/items/{itemName}",method = RequestMethod.GET)
	public Item getItemDetail(@PathVariable String itemName)
	{
		log.info("inside getItemDetail");
		Item item=repo.findByItemName(itemName);
		item.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return item;
	}

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public List<Item> getAllItemDetails() {
		log.info("inside getAllItemDetails");
		return repo.findAll();
	}
}
