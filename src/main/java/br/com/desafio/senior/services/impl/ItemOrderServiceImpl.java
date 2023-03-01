package br.com.desafio.senior.services.impl;

import org.springframework.stereotype.Service;

import br.com.desafio.senior.repositories.ItemOrderRepository;
import br.com.desafio.senior.services.ItemOrderService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemOrderServiceImpl implements ItemOrderService {

	private ItemOrderRepository itemOrderRepository;

}
