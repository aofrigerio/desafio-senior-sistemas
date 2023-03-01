package br.com.desafio.senior.dtos;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.enuns.ProductTypeEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductRequestDTO(
		@NotEmpty
		String name,
		@NotNull
		ProductTypeEnum type,
		@Min(value = 0)
		Double price
		) {
	
			public ProductRequestDTO(ProductEntity productEntity) {
				this(productEntity.getName(), productEntity.getType(), productEntity.getPrice());
			}
}
