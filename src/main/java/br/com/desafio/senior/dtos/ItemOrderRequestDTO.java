package br.com.desafio.senior.dtos;

import java.util.UUID;

public record ItemOrderRequestDTO(
		UUID id,
		UUID orderId,
		UUID productId,
		int quantity
		) {
}
