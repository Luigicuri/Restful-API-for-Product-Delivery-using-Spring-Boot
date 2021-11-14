package com.luigi.testeapi.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luigi.testeapi.domain.model.Cliente;
import com.luigi.testeapi.domain.model.Entrega;
import com.luigi.testeapi.domain.model.StatusEntrega;

import com.luigi.testeapi.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	private CatalogClienteService	catalogClienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		return entregaRepository.save(entrega);
		
	}
	
}	
