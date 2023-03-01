package br.com.desafio.senior.dtos;

import java.util.UUID;

public record ItemOrderRequestDTO(
		UUID id,
		int quantity
		) {

}
