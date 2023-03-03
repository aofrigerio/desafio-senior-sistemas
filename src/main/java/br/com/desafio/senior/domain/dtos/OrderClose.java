package br.com.desafio.senior.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record OrderClose (
	@NotEmpty
	UUID orderId) {
}
