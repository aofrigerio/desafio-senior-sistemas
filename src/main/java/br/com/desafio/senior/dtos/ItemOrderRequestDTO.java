package br.com.desafio.senior.dtos;

import java.util.UUID;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;

public record ItemOrderRequestDTO(
		UUID id,
		int quantity,
		Double price
		) {
	
	public  ItemOrderRequestDTO(ItemOrderEntity itemOrderEntity) {
		this(itemOrderEntity.getId(), itemOrderEntity.getQuantity(), itemOrderEntity.getProduct().getPrice()); //TODO- validar se é da linha
	}

}
