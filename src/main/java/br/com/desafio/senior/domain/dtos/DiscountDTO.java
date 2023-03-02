package br.com.desafio.senior.domain.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record DiscountDTO(
		@Schema(example = "10.33", description = "Desconto em porcentagem")
		@NotEmpty
		Double discount, 
		@NotEmpty
		UUID orderId) {

}
