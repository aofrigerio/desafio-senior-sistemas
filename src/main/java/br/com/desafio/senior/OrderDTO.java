package br.com.desafio.senior;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderDTO(
		@NotEmpty
		String customer,
		@NotEmpty
		@NotNull
		List<UUID> item
		) {
}
