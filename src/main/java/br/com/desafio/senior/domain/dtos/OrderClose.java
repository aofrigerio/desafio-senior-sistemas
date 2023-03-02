package br.com.desafio.senior.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public record OrderClose (
	@NotEmpty
	UUID orderId) {
}
