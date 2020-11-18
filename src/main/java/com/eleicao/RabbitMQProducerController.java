package com.eleicao;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbit-test")
public class RabbitMQProducerController {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@GetMapping(value = "/produced")
	public String producer() {

		rabbitTemplate.convertAndSend(RabbitTesteApplication.EXCHANGE, RabbitTesteApplication.ROUTING_KEY,
				"Hellow world");

		return "Data produced";
	}
}
