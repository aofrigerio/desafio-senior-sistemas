package br.com.desafio.senior.dtos;

import java.util.UUID;

public record DiscountDTO(Double discount, UUID orderId) {

}
