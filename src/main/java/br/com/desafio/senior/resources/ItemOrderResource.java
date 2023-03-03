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

import br.com.desafio.senior.domain.dtos.ItemOrderListDTO;
import br.com.desafio.senior.domain.dtos.ItemOrderRequestDTO;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.services.ItemOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Itens do Pedido")
@RestController
@RequestMapping("/item-order")
@AllArgsConstructor
public class ItemOrderResource {
	
	private final ItemOrderService itemOrderService;
	
	@GetMapping
	@Operation(summary = "Listar todos paginado")
	private ResponseEntity<Page<ItemOrderListDTO>> pageable(
			@QuerydslPredicate(root = ItemOrderEntity.class) Predicate predicate,
			Pageable pageable){
		return ResponseEntity.ok(itemOrderService.listPageable(predicate, pageable));
	}
	
	@GetMapping("/{uuId}")
	@Operation(summary = "Buscar um recurso por UUID")
	private ResponseEntity<ItemOrderListDTO> read(@PathVariable UUID uuId){
		return ResponseEntity.ok(new ItemOrderListDTO(itemOrderService.getOne(uuId)));
	}
	
	@PostMapping
	@Operation(summary = "Criar um recurso")
	private ResponseEntity<ItemOrderListDTO> create(@Valid @RequestBody ItemOrderRequestDTO itemOrderRequestDTO, UriComponentsBuilder uriBuilder){		
		var createItemOrder = itemOrderService.create(itemOrderRequestDTO);		
		var uri = uriBuilder.path("/order/{id}").buildAndExpand(createItemOrder.id()).toUri();
		return ResponseEntity.created(uri).body(createItemOrder);
	}
	
	@PutMapping("/{uuId}")
	@Operation(summary = "Editar um recurso")
	private ResponseEntity<ItemOrderListDTO> update(@PathVariable UUID uuId, @Valid @RequestBody ItemOrderRequestDTO itemOrderRequestDTO){
		return ResponseEntity.noContent().build();
	} 
	
	@DeleteMapping("/{uuId}")
	@Operation(summary = "Deletar um recurso")
	private ResponseEntity<?> delete(@PathVariable UUID uuId){
		return ResponseEntity.noContent().build();
	} 

}
