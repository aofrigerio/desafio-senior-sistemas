package br.com.desafio.senior.dtos;

import java.util.List;
import java.util.UUID;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;

public record OrderListDTO(
		UUID id,
		String customer,
		List<ItemOrderEntity> items,
		double setOff,
		Double total
		) {

	public OrderListDTO(OrderEntity order) {
		this(order.getId(), order.getCustomer(), order.getItems(), order.getOff(), order.getTotal());
	}
}
