package br.com.flaviodev.study.websocket.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
			System.out.println("new -> " + order);
			Client.sendMessage(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/order/confirm/{orderNumber}")
	public void confirm(@PathVariable("orderNumber") String orderNumber) {
		try {
			Order order =  new Order();
			order.setNumber(orderNumber);
			order.setStatus("CONFIRMED");
			
			System.out.println("confirmed -> " + orderNumber);
			
			Client.sendMessage(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
