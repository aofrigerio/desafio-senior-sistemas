package br.com.desafio.senior.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ItemOrderRequestDTO(
		@NotEmpty
		UUID orderId,
		@NotEmpty
		UUID productId,
		@Min(value = 0)
		int quantity
		) {
}
