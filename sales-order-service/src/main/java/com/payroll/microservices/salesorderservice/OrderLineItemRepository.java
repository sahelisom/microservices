package com.payroll.microservices.salesorderservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {
	
	//List<OrderLineItem> findByOrderId(Long orderId);
	

}
