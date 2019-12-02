package com.payroll.microservices.customerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

	private static Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

	@Value("${customer.rabbitmq.exchange}")
	private String exchange;

	@Value("${customer.rabbitmq.routingkey}")
	private String routingkey;

	@Autowired
	private AmqpTemplate amqpTemplate;

	/*@Autowired
	public RabbitMQSender(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
		this.rabbitTemplate = rabbitTemplate;
		this.topicExchange = topicExchange;
	}*/

	public void send(Customer customer) {
		log.info("Sending msg to the exchange : " + exchange + ". The value is :" + customer);
		amqpTemplate.convertAndSend(exchange, routingkey, customer);
		log.info("Sending msg : " + customer);
	}
}
