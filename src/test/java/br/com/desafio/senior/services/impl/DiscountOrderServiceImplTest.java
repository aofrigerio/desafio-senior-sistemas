package br.com.desafio.senior.services.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.senior.domain.dtos.DiscountDTO;
import br.com.desafio.senior.domain.dtos.OrderClose;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.domain.enuns.OrderStatusEnum;
import br.com.desafio.senior.resources.exceptions.OrderNotOpenException;
import br.com.desafio.senior.services.ItemOrderService;
import br.com.desafio.senior.services.OrderService;

@ExtendWith(MockitoExtension.class)
public class DiscountOrderServiceImplTest {
	
	@Mock
	OrderService orderService;
	@Mock
	ItemOrderService itemOrderService;
	
	DiscountOrderServiceImpl discountOrderServiceImpl;

	@BeforeEach
    void setUp() {
		discountOrderServiceImpl = new DiscountOrderServiceImpl(orderService,itemOrderService);
    }

    @Test
    void create() {
    	when(orderService.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"))).thenReturn(buildOrderEntity());
    	assertDoesNotThrow(() -> discountOrderServiceImpl.discountOrder(buildDiscountDTO()));
    }
    
    @Test
    void createWhenStatusIsClose() {
    	when(orderService.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"))).thenReturn(buildOrderEntityWithClose());
    	assertThrows(OrderNotOpenException.class, () -> discountOrderServiceImpl.discountOrder(buildDiscountDTO()));
    }
    
    DiscountDTO buildDiscountDTO() {
    	return DiscountDTO.builder().orderId(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")).discount(6D).build();
    }
    
    OrderClose buildOrderClose() {
    	return OrderClose.builder().build();
    }
    
	OrderEntity buildOrderEntity() {
		return OrderEntity.builder().status(OrderStatusEnum.OPEN).customer("ok").off(3D).build();
	}
	
	OrderEntity buildOrderEntityWithClose() {
		return OrderEntity.builder().status(OrderStatusEnum.CLOSED).customer("ok").off(3D).build();
	}
    
}
