package br.com.desafio.senior.domain.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ItemOrderRequestDTO(
		@NotEmpty
		UUID orderId,
		@NotEmpty
		UUID productId,
		@Min(value = 0)
		@Schema(example = "25", description = "Quantidade. Pode ser fração")
		int quantity
		) {
}
