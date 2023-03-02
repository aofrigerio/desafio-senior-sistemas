package br.com.desafio.senior.domain.dtos;

import jakarta.validation.constraints.NotEmpty;

public record OrderRequestDTO(
		@NotEmpty
		String customer
		) {
}
