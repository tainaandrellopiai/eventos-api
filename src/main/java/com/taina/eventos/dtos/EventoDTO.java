package com.taina.eventos.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.taina.eventos.domain.Evento;

public class EventoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="campo nome é requerido")
	@Length(min=3,max=100,message="o campo nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message="campo tipo é requerido")
	@Length(min=3,max=100,message="o campo tipo deve ter entre 3 e 100 caracteres")
	private String tipo;
	
	public EventoDTO() {
		super();
	}

	public EventoDTO(Evento obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.tipo = obj.getTipo();
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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
