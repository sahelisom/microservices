package com.payroll.microservicess.employeeservice;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Configuration
//@EnableScheduling
/*public class EventPublisherConfiguration {
	  @Bean
	  public TopicExchange senderTopicExchange() {
	    return new TopicExchange("eventExchange");
	  }


	  @Bean
	  public EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange) {
	    return new EventPublisher(rabbitTemplate, senderTopicExchange);
	  }

}*/
