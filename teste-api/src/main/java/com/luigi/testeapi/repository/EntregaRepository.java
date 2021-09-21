package com.luigi.testeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luigi.testeapi.domain.model.Entrega;
@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
	
}
