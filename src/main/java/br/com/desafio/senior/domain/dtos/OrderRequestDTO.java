package br.com.desafio.senior.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record OrderRequestDTO(
		@NotEmpty
		String customer
		) {
}
