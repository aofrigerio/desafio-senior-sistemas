package br.com.desafio.senior.dtos;

import jakarta.validation.constraints.NotEmpty;

public record OrderRequestDTO(
		@NotEmpty
		String customer
		) {
}
