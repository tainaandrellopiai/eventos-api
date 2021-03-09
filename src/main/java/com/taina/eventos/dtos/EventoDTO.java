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
	
	@NotEmpty(message="campo lugar é requerido")
	@Length(min=3,max=100,message="o campo lugar deve ter entre 3 e 100 caracteres")
	private String lugar;
	
	public EventoDTO() {
		super();
	}

	public EventoDTO(Evento obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.lugar = obj.getLugar();
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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
