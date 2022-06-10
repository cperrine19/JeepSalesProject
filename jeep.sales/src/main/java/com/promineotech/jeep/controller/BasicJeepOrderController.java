package com.promineotech.jeep.controller;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.service.JeepOrderService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BasicJeepOrderController implements JeepOrderController {
	
	@Autowired
	private JeepOrderService jeepOrderService;

	@Override
	public Order createORDER(OrderRequest orderRequest) {
		log.debug("Order:{}", orderRequest);
		return jeepOrderService.createOrder(orderRequest);
	}

}
