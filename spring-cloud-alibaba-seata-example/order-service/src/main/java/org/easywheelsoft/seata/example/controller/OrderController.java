package org.easywheelsoft.seata.example.controller;

import org.easywheelsoft.seata.example.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/create", produces = "application/json")
	public Boolean create(String userId, String commodityCode, Integer count) {

		orderService.create(userId, commodityCode, count);
		return true;
	}

}
