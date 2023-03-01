package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.dtos.OrderListDTO;
import br.com.desafio.senior.dtos.OrderRequestDTO;

public interface OrderService {
	
	Page<OrderListDTO> listPageable(Pageable pageable);
	OrderEntity create(OrderRequestDTO orderRequestDTO);
	OrderEntity getOne(UUID uuId);
	OrderEntity update(UUID uuId, OrderRequestDTO orderRequestDTO);
	void update(OrderEntity orderEntity);
	void delete(UUID uuId);
}
