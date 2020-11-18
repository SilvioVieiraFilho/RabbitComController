package com.eleicao;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitTesteApplication.class, args);
	}

	public static final String QUEUE= "PlayJavaQueue";
	public static final String EXCHANGE  = "PlayJavaExchange";
	public static final String ROUTING_KEY = "PlayJavaRoutingKey";
	

@Bean
Queue queue() {
	
	return new Queue(QUEUE,false);
	
}

@Bean
DirectExchange exchange(){
	
	return new DirectExchange(EXCHANGE);
	
	
}

@Bean
Binding binding(Queue queue, DirectExchange exchange) {
	
return  BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);	
	
}

}
