package com.payroll.microservices.salesorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
	@Autowired
	private CustomerSOSRepository repo;
	private static Logger log = LoggerFactory.getLogger(RabbitMQReceiver.class);
	
	@RabbitListener(queues="${customer.rabbitmq.queue}",containerFactory="jsaFactory")
    public void receivedMessage(Customer cust) {
        log.info("Received Message: " + cust);
        repo.save(cust);
    }
}
