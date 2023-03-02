package br.com.desafio.senior.domain.dtos;

import java.util.UUID;

import br.com.desafio.senior.domain.entities.OrderEntity;
import io.swagger.v3.oas.annotations.media.Schema;

public record OrderListDTO(
		UUID id,
		String customer,
		double setOff,
		Double total
		) {

	public OrderListDTO(OrderEntity order) {
		this(order.getId(), order.getCustomer(), order.getOff(), order.getTotal());
	}
}
