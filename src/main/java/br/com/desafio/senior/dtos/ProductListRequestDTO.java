package br.com.desafio.senior.dtos;

import java.util.UUID;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.enuns.ProductTypeEnum;

public record ProductListRequestDTO(
		UUID id,
		String name,
		ProductTypeEnum type,
		Double price
		) {
	
			public ProductListRequestDTO(ProductEntity productEntity) {
				this(productEntity.getId(), productEntity.getName(), productEntity.getType(), productEntity.getPrice());
			}
}
