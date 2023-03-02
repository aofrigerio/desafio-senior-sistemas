package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.domain.dtos.OrderListDTO;
import br.com.desafio.senior.domain.dtos.OrderRequestDTO;
import br.com.desafio.senior.domain.entities.OrderEntity;

public interface OrderService {
	
	Page<OrderListDTO> listPageable(Pageable pageable);
	OrderEntity create(OrderRequestDTO orderRequestDTO);
	OrderEntity getOne(UUID uuId);
	OrderEntity update(UUID uuId, OrderRequestDTO orderRequestDTO);
	void update(OrderEntity orderEntity);
	void delete(UUID uuId);
}
