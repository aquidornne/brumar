package com.blumar.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "produtos")
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String nm_produto;
	@Column
	private BigDecimal preco;
	
	@OneToMany(mappedBy = "id")
	@JsonIgnore
    private List<OcupacoesProdutos> ocupacoesProdutos;
	
	public Produtos() {
	}
	
	public Produtos(Long id) {
		super();
		this.id = id;
	}
	
	public Produtos(Long id, String nm_produto, BigDecimal preco, List<OcupacoesProdutos> ocupacoesProdutos) {
		super();
		this.id = id;
		this.nm_produto = nm_produto;
		this.preco = preco;
		this.ocupacoesProdutos = ocupacoesProdutos;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNm_produto() {
		return nm_produto;
	}
	
	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public List<OcupacoesProdutos> getOcupacoesProdutos() {
		return ocupacoesProdutos;
	}
	
	public void setOcupacoesProdutos(List<OcupacoesProdutos> ocupacoesProdutos) {
		this.ocupacoesProdutos = ocupacoesProdutos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nm_produto == null) ? 0 : nm_produto.hashCode());
		result = prime * result + ((ocupacoesProdutos == null) ? 0 : ocupacoesProdutos.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nm_produto == null) {
			if (other.nm_produto != null)
				return false;
		} else if (!nm_produto.equals(other.nm_produto))
			return false;
		if (ocupacoesProdutos == null) {
			if (other.ocupacoesProdutos != null)
				return false;
		} else if (!ocupacoesProdutos.equals(other.ocupacoesProdutos))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Produtos [id=" + id + ", nm_produto=" + nm_produto + ", preco=" + preco + ", ocupacoesProdutos="
				+ ocupacoesProdutos + "]";
	}
}
