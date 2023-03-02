package br.com.desafio.senior.services;

import br.com.desafio.senior.domain.dtos.DiscountDTO;
import br.com.desafio.senior.domain.dtos.OrderClose;

public interface DiscountOrderService {
	/**
	 * Aplicar um desconto no Pedido
	 * 
	 * @param discountOrderService DiscountDTO
	 */
	void discountOrder(DiscountDTO discountOrderService);

	/**
	 * Finalizar o Pedido
	 * 
	 * @param orderCloseDTO PedidoDTO
	 */
	void orderClose(OrderClose orderCloseDTO);
}
