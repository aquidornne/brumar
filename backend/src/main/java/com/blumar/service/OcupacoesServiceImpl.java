package com.blumar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumar.entity.Ocupacoes;
import com.blumar.entity.Quartos;
import com.blumar.entity.criteria.OcupacoesFiltros;
import com.blumar.entity.criteria.OcupacoesPesquisas;
import com.blumar.entity.criteria.OcupacoesQuery;
import com.blumar.repository.OcupacoesRepository;
import com.blumar.repository.QuartosRepository;

@Service
public class OcupacoesServiceImpl implements OcupacoesService {
	
	@Autowired
	public OcupacoesRepository repository;
	@Autowired
	public QuartosRepository repoQuartos;
	
	@PersistenceContext
	private EntityManager em;
	
	public OcupacoesServiceImpl(OcupacoesRepository repository, QuartosRepository repoQuartos){
		this.repository = repository;
		this.repoQuartos = repoQuartos;
	}
	
	public OcupacoesPesquisas filtro(OcupacoesFiltros filtros) {
    	Long total = OcupacoesQuery.quantidade(em, filtros);
		List<Ocupacoes> Ocupacoeses = OcupacoesQuery.buscarPorCriterios(em, filtros);
		return new OcupacoesPesquisas(total, Ocupacoeses);
	}
	
	public Page<Ocupacoes> lista(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	public Ocupacoes obterPorId(Long id) {
		return this.repository.findOne(id);
	}
	
	public Ocupacoes salvar(Ocupacoes Ocupacoes, Long quartoId) {   
		Quartos quarto = this.atualizarOcupacaoQuarto(quartoId);
    	Ocupacoes.setQuartos(quarto);
		return this.repository.save(Ocupacoes);
	}
	
	private Quartos atualizarOcupacaoQuarto(Long quartoId) {
		Quartos quarto = this.repoQuartos.findById(quartoId);
    	quarto.setOcupado(true);
    	return this.repoQuartos.save(quarto);
	}
}
