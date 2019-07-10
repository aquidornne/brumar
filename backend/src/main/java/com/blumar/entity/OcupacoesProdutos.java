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
@Table(name = "ocupacoes_produtos")
public class OcupacoesProdutos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@JoinColumn(name = "ocupacao_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ocupacoes ocupacoes;
	
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Produtos produtos;
	
	public OcupacoesProdutos() {
	}
	
	public OcupacoesProdutos(Long id) {
		super();
		this.id = id;
	}
	
	public OcupacoesProdutos(Long id, Ocupacoes ocupacoes, Produtos produtos) {
		super();
		this.id = id;
		this.ocupacoes = ocupacoes;
		this.produtos = produtos;
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
	
	public Produtos getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ocupacoes == null) ? 0 : ocupacoes.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
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
		OcupacoesProdutos other = (OcupacoesProdutos) obj;
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
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "OcupacoesProdutos [id=" + id + ", ocupacoes=" + ocupacoes + ", produtos=" + produtos + "]";
	}
}
