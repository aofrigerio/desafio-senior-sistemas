package br.com.desafio.senior.dtos;

import br.com.desafio.senior.enuns.ProductTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ProductDTO(
		@Schema(example = "Pão Frances")
		@NotEmpty
		String name,
		@NotEmpty
		ProductTypeEnum type,
		@Schema(example = "11.75")
		@Min(value = 0)
		Double price
		) {
}
