package br.com.desafio.senior.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.dtos.DiscountDTO;
import br.com.desafio.senior.enuns.OrderStatusEnum;
import br.com.desafio.senior.enuns.ProductTypeEnum;
import br.com.desafio.senior.resources.exceptions.OrderNotOpenException;
import br.com.desafio.senior.services.DiscountOrderService;
import br.com.desafio.senior.services.ItemOrderService;
import br.com.desafio.senior.services.OrderService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscountOrderServiceImpl implements DiscountOrderService {

	private final OrderService orderService;
	private final ItemOrderService itemOrderService;

	public void discountOrder(DiscountDTO discountOrderService) {

		OrderEntity orderEntity = orderService.getOne(discountOrderService.orderId());

		if (orderEntity.getStatus().equals(OrderStatusEnum.CLOSED)) {
			throw new OrderNotOpenException();
		}

		List<ItemOrderEntity> items = itemOrderService.listByOrder(orderEntity.getId());
		
		if(items == null) {
			return;
		}
	
		//TODO - Verificar desconto pois precisa ver os totais do serviço ou colocar em uma classe
		
		Double totalServices = items.stream()
				.filter(predicate -> predicate.getProduct().getType().equals(ProductTypeEnum.SERVICE))
				.mapToDouble(map -> map.getQuantity() * map.getProduct().getPrice()).sum();

		Double totalProducts = items.stream()
				.filter(predicate -> predicate.getProduct().getType().equals(ProductTypeEnum.PRODUCT))
				.mapToDouble(map -> map.getQuantity() * map.getProduct().getPrice()).sum();
				

		totalProducts = totalServices + (totalProducts * (1 - discountOrderService.discount()));
		
		orderEntity.setTotal(totalProducts);
		orderService.update(orderEntity);

	}

}
