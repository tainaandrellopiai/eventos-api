package com.taina.eventos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="eventos")
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="campo nome é requerido")
	@Length(min=3,max=100,message="o campo nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message="campo lugar é requerido")
	@Length(min=3,max=100,message="o campo lugar deve ter entre 3 e 100 caracteres")
	private String lugar;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="local_id")
	private Lugar local;

	public Evento(Integer id, String nome, String lugar, Lugar local) {
		super();
		this.id = id;
		this.nome = nome;
		this.lugar = lugar;
		this.local = local;
	}

	public Evento() {
		super();
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

	public Lugar getLocal() {
		return local;
	}

	public void setLocal(Lugar local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
