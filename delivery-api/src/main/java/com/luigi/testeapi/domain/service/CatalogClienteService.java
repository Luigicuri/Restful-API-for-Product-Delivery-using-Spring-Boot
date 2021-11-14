package com.luigi.testeapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luigi.testeapi.domain.exception.DomainException;
import com.luigi.testeapi.domain.model.Cliente;
import com.luigi.testeapi.repository.ClienteRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CatalogClienteService {
	private ClienteRepository clRepository;
	public Cliente buscar(Long clienteId) {
		return clRepository.findById(clienteId)
				.orElseThrow(() -> new DomainException("Cliente NOT FOUND"));
	}
	 @Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if(emailEmUso) {
			throw new DomainException("THIS E-MAIL IS ALREADY USED, PLEASE TRY ANOTHER");
		}
		 return clRepository.save(cliente);
	}
	 @Transactional
	 public void excluir(Long clienteId) {
		 clRepository.deleteById(clienteId);
	 }
		
}
