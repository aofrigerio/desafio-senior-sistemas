package br.com.desafio.senior.dtos;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDTO(
		@NotEmpty
		String customer,
		@NotEmpty
		@NotNull
		List<ItemOrderRequestDTO> item,
		double setOff
		) {
}
