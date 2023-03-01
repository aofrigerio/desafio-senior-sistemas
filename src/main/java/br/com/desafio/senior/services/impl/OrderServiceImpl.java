package br.com.desafio.senior.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.dtos.OrderListDTO;
import br.com.desafio.senior.dtos.OrderRequestDTO;
import br.com.desafio.senior.enuns.ProductTypeEnum;
import br.com.desafio.senior.repositories.OrderRepository;
import br.com.desafio.senior.services.ItemOrderService;
import br.com.desafio.senior.services.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	private OrderRepository repository;
	private ItemOrderService itemOrderService;

	public Page<OrderListDTO> listPageable(Pageable pageable) {
		return null;
	}

	@Transactional
	public OrderListDTO create(OrderRequestDTO orderRequestDTO) {
		var order = new OrderEntity(orderRequestDTO);
		persisteOrder(orderRequestDTO, order);
		return new OrderListDTO(order);
	}

	private void persisteOrder(OrderRequestDTO orderRequestDTO, OrderEntity order) {
		Double totalPrice = Double.valueOf(0);
		Double totalPriceWithDiscount = Double.valueOf(0);
		Double discount = Double.valueOf(0);
		List<UUID> uuIdItems = orderRequestDTO.item().stream().map(map -> map.id()).toList();
		List<ItemOrderEntity> itemsEntity = itemOrderService.getItems(uuIdItems);

		order.setCustomer(orderRequestDTO.customer());
		order.setItems(itemsEntity);

		itemsEntity.stream().forEach(item -> {
			
			Double priceProduct = item.getProduct().getPrice();
			
			if(item.getProduct().getType().equals(ProductTypeEnum.PRODUCT) &&
					orderRequestDTO.setOff() > 0
					) {
				totalPriceWithDiscount.sum(totalPriceWithDiscount, priceProduct);
			}
			
			totalPrice.sum(totalPrice, priceProduct);
		});
		
		totalPrice.min(totalPrice, totalPriceWithDiscount);

		order.setOff(orderRequestDTO.setOff());
		order.setTotal(totalPriceWithDiscount * (1 - orderRequestDTO.setOff()));		
		repository.save(order);
	}

	public OrderListDTO getOne(UUID uuId) {
		var order = repository.findById(uuId).orElse(null);
		return new OrderListDTO(order);
	}

	public OrderListDTO update(UUID uuId, OrderRequestDTO orderRequestDTO) {
		var order = new OrderEntity(orderRequestDTO);
		persisteOrder(orderRequestDTO, order);
		return new OrderListDTO(order);
	}

	public void delete(UUID uuId) {
		repository.deleteById(uuId);
	}

}
