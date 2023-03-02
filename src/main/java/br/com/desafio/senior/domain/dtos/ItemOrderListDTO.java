package br.com.desafio.senior.domain.dtos;

import java.util.UUID;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.domain.entities.ProductEntity;

public record ItemOrderListDTO(
		UUID id,
		OrderEntity order,
		ProductEntity product,
		int quantity
		) {
	
	public ItemOrderListDTO(ItemOrderEntity itemOrderEntity) {
		this(itemOrderEntity.getId(), itemOrderEntity.getOrder(), itemOrderEntity.getProduct(), itemOrderEntity.getQuantity());
	}

}
