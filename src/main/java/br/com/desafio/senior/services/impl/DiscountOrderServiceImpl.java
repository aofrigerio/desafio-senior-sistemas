package br.com.desafio.senior.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.desafio.senior.domain.dtos.DiscountDTO;
import br.com.desafio.senior.domain.dtos.OrderClose;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.domain.enuns.OrderStatusEnum;
import br.com.desafio.senior.resources.exceptions.OrderNotOpenException;
import br.com.desafio.senior.services.DiscountOrderService;
import br.com.desafio.senior.services.ItemOrderService;
import br.com.desafio.senior.services.OrderService;
import br.com.desafio.senior.util.DiscountUtil;
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
		
		Double totalProducts = DiscountUtil.simpleDiscount(discountOrderService.discount(), items);
		
		orderEntity.setOff(discountOrderService.discount());
		orderEntity.setTotal(totalProducts);
		orderService.update(orderEntity);

	}

	@Override
	public void orderClose(OrderClose orderCloseDTO) {
		OrderEntity orderEntity = orderService.getOne(orderCloseDTO.orderId());
		if(orderEntity.getStatus().equals(OrderStatusEnum.CLOSED)){
			throw new OrderNotOpenException();
		}
		orderEntity.setStatus(OrderStatusEnum.CLOSED);
		orderService.update(orderEntity);
	}

}
