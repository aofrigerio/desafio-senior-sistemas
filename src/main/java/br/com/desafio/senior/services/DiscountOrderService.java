package br.com.desafio.senior.services;

import br.com.desafio.senior.domain.dtos.DiscountDTO;
import br.com.desafio.senior.domain.dtos.OrderClose;

public interface DiscountOrderService {
	void discountOrder(DiscountDTO discountOrderService);
	void orderClose(OrderClose orderCloseDTO);
}
