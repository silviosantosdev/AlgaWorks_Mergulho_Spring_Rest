package com.algaworks.algalog.domain.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {
	
	@EqualsAndHashCode.Include // limita notação à propriedade Id
	@Id //define a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define a geração da chave como a nativa do banco de dados
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public void setId(Long clienteId) {
		// TODO Auto-generated method stub
		
	}

}
