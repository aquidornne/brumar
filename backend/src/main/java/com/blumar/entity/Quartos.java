package com.blumar.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quartos")
public class Quartos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private Integer nu_quarto;
	@Column
	private Boolean ocupado;
	
	@OneToMany(mappedBy = "id")
	@JsonIgnore
    private List<Ocupacoes> ocupacoes;
	
	public Quartos() {
	}
	
	public Quartos(Long id) {
		super();
		this.id = id;
	}
	
	public Quartos(Long id, Integer nu_quarto, Boolean ocupado, List<Ocupacoes> ocupacoes) {
		super();
		this.id = id;
		this.nu_quarto = nu_quarto;
		this.ocupado = ocupado;
		this.ocupacoes = ocupacoes;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNu_quarto() {
		return nu_quarto;
	}
	
	public void setNu_quarto(Integer nu_quarto) {
		this.nu_quarto = nu_quarto;
	}
	
	public Boolean getOcupado() {
		return ocupado;
	}
	
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public List<Ocupacoes> getOcupacoes() {
		return ocupacoes;
	}
	
	public void setOcupacoes(List<Ocupacoes> ocupacoes) {
		this.ocupacoes = ocupacoes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nu_quarto == null) ? 0 : nu_quarto.hashCode());
		result = prime * result + ((ocupacoes == null) ? 0 : ocupacoes.hashCode());
		result = prime * result + ((ocupado == null) ? 0 : ocupado.hashCode());
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
		Quartos other = (Quartos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nu_quarto == null) {
			if (other.nu_quarto != null)
				return false;
		} else if (!nu_quarto.equals(other.nu_quarto))
			return false;
		if (ocupacoes == null) {
			if (other.ocupacoes != null)
				return false;
		} else if (!ocupacoes.equals(other.ocupacoes))
			return false;
		if (ocupado == null) {
			if (other.ocupado != null)
				return false;
		} else if (!ocupado.equals(other.ocupado))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Quartos [id=" + id + ", nu_quarto=" + nu_quarto + ", ocupado=" + ocupado + ", ocupacoes=" + ocupacoes
				+ "]";
	}
}
