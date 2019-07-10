package com.blumar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.blumar.entity.Ocupacoes;
import com.blumar.entity.criteria.OcupacoesFiltros;
import com.blumar.entity.criteria.OcupacoesPesquisas;

public interface OcupacoesService {
	public OcupacoesPesquisas filtro(OcupacoesFiltros filtros);
	public Page<Ocupacoes> lista(Pageable pageable);
	public Ocupacoes obterPorId(Long id);
	public Ocupacoes salvar(Ocupacoes Ocupacoes, Long quartoId);
}
