package br.com.desafio.senior.resources;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.desafio.senior.dtos.OrderListDTO;
import br.com.desafio.senior.dtos.OrderRequestDTO;
import br.com.desafio.senior.services.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderResource {
	
	private OrderService orderService;
	
	@GetMapping
	private ResponseEntity<Page<OrderListDTO>> pageable(Pageable pageable){
		return ResponseEntity.ok(orderService.listPageable(pageable));
	}

	
	@GetMapping("/{uuId}")
	private ResponseEntity<OrderListDTO> read(@PathVariable UUID uuId){
		return ResponseEntity.ok(orderService.getOne(uuId));
	}
	
	@PostMapping
	private ResponseEntity<OrderListDTO> create(@Valid @RequestBody OrderRequestDTO order, UriComponentsBuilder uriBuilder){
		var createdOrder = orderService.create(order);		
		var uri = uriBuilder.path("/order/{id}").buildAndExpand(createdOrder.id()).toUri();
		return ResponseEntity.created(uri).body(createdOrder);
	}
	
	@PutMapping("/{uuId}")
	private ResponseEntity<?> update(@PathVariable UUID uuId, @Valid @RequestBody OrderRequestDTO orders){
		return ResponseEntity.ok(orderService.update(uuId, orders));
	} 
	
	@DeleteMapping("/{uuId}")
	private ResponseEntity<?> delete(@PathVariable UUID uuId){
		orderService.delete(uuId);
		return ResponseEntity.noContent().build();
	} 

}
