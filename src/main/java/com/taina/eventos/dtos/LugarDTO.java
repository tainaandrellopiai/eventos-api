package com.taina.eventos.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.taina.eventos.domain.Lugar;

public class LugarDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="campo nome é requerido")
	@Length(min=3,max=100,message="o campo nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	//@NotEmpty(message="campo capacidade é requerido")
	private int capacidade;
	
	public LugarDTO() {
		super();
	}

	public LugarDTO(Lugar obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.capacidade = obj.getCapacidade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
