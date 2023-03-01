package br.com.desafio.senior.services.impl;

import org.springframework.stereotype.Service;

import br.com.desafio.senior.repositories.OrderRepository;
import br.com.desafio.senior.services.OrderService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService  {
	
	private OrderRepository ordermRepository;

}
