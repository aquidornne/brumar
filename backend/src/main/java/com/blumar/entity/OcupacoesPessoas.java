package com.blumar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ocupacoes_pessoas")
public class OcupacoesPessoas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@JoinColumn(name = "ocupacao_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ocupacoes ocupacoes;
	
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoas pessoas;
	
	public OcupacoesPessoas() {
	}
	
	public OcupacoesPessoas(Long id) {
		super();
		this.id = id;
	}
	
	public OcupacoesPessoas(Long id, Ocupacoes ocupacoes, Pessoas pessoas) {
		super();
		this.id = id;
		this.ocupacoes = ocupacoes;
		this.pessoas = pessoas;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Ocupacoes getOcupacoes() {
		return ocupacoes;
	}
	
	public void setOcupacoes(Ocupacoes ocupacoes) {
		this.ocupacoes = ocupacoes;
	}
	
	public Pessoas getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ocupacoes == null) ? 0 : ocupacoes.hashCode());
		result = prime * result + ((pessoas == null) ? 0 : pessoas.hashCode());
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
		OcupacoesPessoas other = (OcupacoesPessoas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ocupacoes == null) {
			if (other.ocupacoes != null)
				return false;
		} else if (!ocupacoes.equals(other.ocupacoes))
			return false;
		if (pessoas == null) {
			if (other.pessoas != null)
				return false;
		} else if (!pessoas.equals(other.pessoas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "OcupacoesPessoas [id=" + id + ", ocupacoes=" + ocupacoes + ", pessoas=" + pessoas + "]";
	}
}
