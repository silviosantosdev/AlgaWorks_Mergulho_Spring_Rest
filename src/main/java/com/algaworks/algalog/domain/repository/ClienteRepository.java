package com.algaworks.algalog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.algaworks.algalog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByName(String nome); //permite consultar por um nome específico.
	List<Cliente> findByNameContaining(String nome); //permite consultar por um nome que contenha esse parâmetro.
	
	

}
