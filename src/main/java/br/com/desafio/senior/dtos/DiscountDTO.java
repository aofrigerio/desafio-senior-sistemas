package br.com.desafio.senior.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public record DiscountDTO(
		@NotEmpty
		Double discount, 
		@NotEmpty
		UUID orderId) {

}
