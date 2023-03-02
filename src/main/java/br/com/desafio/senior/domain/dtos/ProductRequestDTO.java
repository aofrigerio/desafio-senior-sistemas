package br.com.desafio.senior.domain.dtos;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.domain.enuns.ProductTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record ProductRequestDTO(
		@NotEmpty
		String name,
		@NotNull
		@Schema(description = "Tipo do Item: PRODUCT / SERVICE")
		ProductTypeEnum type,
		@Schema(example = "22.33", description = "Valor do produto/servico")
		@Min(value = 0)
		Double price
		) {
	
			public ProductRequestDTO(ProductEntity productEntity) {
				this(productEntity.getName(), productEntity.getType(), productEntity.getPrice());
			}
}
