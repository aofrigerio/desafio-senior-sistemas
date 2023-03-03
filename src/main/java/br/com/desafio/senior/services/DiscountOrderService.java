package br.com.desafio.senior.services;

import br.com.desafio.senior.domain.dtos.DiscountDTO;

public interface DiscountOrderService {
	/**
	 * Aplicar um desconto no Pedido
	 * 
	 * @param discountOrderService DiscountDTO
	 */
	void discountOrder(DiscountDTO discountOrderService);
}
