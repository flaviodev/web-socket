package br.com.flaviodev.study.websocket.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.flaviodev.study.websocket.client.Client;
import br.com.flaviodev.study.websocket.model.Order;

@RestController
public class OrderRestController {

	@PostMapping("/order")
	public void order(@RequestBody Order order) {
		try {
			order.setStatus("SENT");
			Client.sendMessage(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/order/confirm")
	public void confirm(@RequestBody Order order) {
		try {
			order.setStatus("CONFIRMED");
			
			Client.sendMessage(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
