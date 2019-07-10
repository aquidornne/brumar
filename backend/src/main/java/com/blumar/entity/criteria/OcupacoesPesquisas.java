package com.blumar.entity.criteria;

import java.util.List;

import com.blumar.entity.Ocupacoes;

public class OcupacoesPesquisas {
	private long quantidade;
	
	private List<Ocupacoes> Ocupacoes;
	
	public OcupacoesPesquisas(long quantidade, List<Ocupacoes> Ocupacoes) {
		this.quantidade = quantidade;
		this.Ocupacoes = Ocupacoes;
	}
	
	public List<Ocupacoes> getOcupacoes() {
		return Ocupacoes;
	}
	
	public long getQuantidade() {
		return quantidade;
	}
}
