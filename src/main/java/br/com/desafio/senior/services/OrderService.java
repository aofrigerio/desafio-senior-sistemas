package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.dtos.OrderListDTO;
import br.com.desafio.senior.dtos.OrderRequestDTO;

public interface OrderService {
	
	Page<OrderListDTO> listPageable(Pageable pageable);
	OrderListDTO create(OrderRequestDTO orderRequestDTO);
	OrderListDTO getOne(UUID uuId);
	OrderListDTO update(UUID uuId, OrderRequestDTO orderRequestDTO);
	void delete(UUID uuId);
}
