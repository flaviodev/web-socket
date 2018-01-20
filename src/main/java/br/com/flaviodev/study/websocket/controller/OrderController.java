package br.com.flaviodev.study.websocket.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.flaviodev.study.websocket.model.Order;
import br.com.flaviodev.study.websocket.model.OutputOrder;

@Controller
public class OrderController {

	@MessageMapping("/order")
	@SendTo("/topic/orders")
	public OutputOrder send(Order order) throws Exception {
		return new OutputOrder(order, LocalDateTime.now());
	}
}
