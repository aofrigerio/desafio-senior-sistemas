package br.com.desafio.senior.resources;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.DiscountDTO;
import br.com.desafio.senior.domain.dtos.OrderClose;
import br.com.desafio.senior.domain.dtos.OrderListDTO;
import br.com.desafio.senior.domain.dtos.OrderRequestDTO;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.services.DiscountOrderService;
import br.com.desafio.senior.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Pedido")
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderResource {
	
	private final OrderService orderService;
	private final DiscountOrderService discountOrderService;
	
	@GetMapping
	@Operation(summary = "Listar todos paginado")
	private ResponseEntity<Page<OrderListDTO>> pageable(@QuerydslPredicate(root = OrderEntity.class) Predicate predicate,
			Pageable pageable){
		return ResponseEntity.ok(orderService.listPageable(predicate, pageable));
	}

	
	@GetMapping("/{uuId}")
	@Operation(summary = "Buscar um recurso por UUID")
	private ResponseEntity<OrderListDTO> read(@PathVariable UUID uuId){
		return ResponseEntity.ok(new OrderListDTO(orderService.getOne(uuId)));
	}
	
	@PostMapping
	@Operation(summary = "Criar um recurso")
	private ResponseEntity<OrderListDTO> create(@Valid @RequestBody OrderRequestDTO order, UriComponentsBuilder uriBuilder){
		var createdOrder = orderService.create(order);		
		var uri = uriBuilder.path("/order/{id}").buildAndExpand(createdOrder.getId()).toUri();		
		return ResponseEntity.created(uri).body(new OrderListDTO(createdOrder));
	}
	
	@PutMapping("/{uuId}")
	@Operation(summary = "Editar um recurso")
	private ResponseEntity<OrderListDTO> update(@PathVariable UUID uuId, @Valid @RequestBody OrderRequestDTO orders){
		return ResponseEntity.ok(new OrderListDTO(orderService.update(uuId, orders)));
	} 
	
	@DeleteMapping("/{uuId}")
	@Operation(summary = "Deletar um recurso")
	private ResponseEntity<Void> delete(@PathVariable UUID uuId){
		orderService.delete(uuId);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/discount")
	@Operation(summary = "Aplicar um desconto para o Pedido")
	private ResponseEntity<Void> discount(@RequestBody DiscountDTO discount) {
		discountOrderService.discountOrder(discount);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/invoice")
	@Operation(summary = "Finalizar o Pedido")
	private ResponseEntity<Void> invoice(@RequestBody OrderClose orderCloseDTO) {
		orderService.orderClose(orderCloseDTO);
		return ResponseEntity.noContent().build();
	}
}
