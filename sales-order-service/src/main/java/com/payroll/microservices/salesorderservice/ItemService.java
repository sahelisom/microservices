package com.payroll.microservices.salesorderservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "item-service-saheli")
@RibbonClient(name = "item-service-saheli")
//@FeignClient(name = "ZUUL-EDGE-SERVER")

public interface ItemService {

	@RequestMapping(value = "items/{itemName}",method = RequestMethod.GET)
	public Item getItemDetail(@PathVariable(value="itemName") String itemName);
}
