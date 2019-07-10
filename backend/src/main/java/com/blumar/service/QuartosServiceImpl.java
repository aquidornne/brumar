package com.blumar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blumar.entity.Quartos;
import com.blumar.repository.QuartosRepository;

@Service
public class QuartosServiceImpl implements QuartosService {
	
	@Autowired
	public QuartosRepository repository;
	
	public QuartosServiceImpl(QuartosRepository repository){
		this.repository = repository;
	}
	
	@Override
	public Quartos salvar(Quartos quartos) {
		return this.repository.save(quartos);
	}
	
	@Override
	public Integer obterQtdQuartosDisponiveis() {
		return this.repository.obterQtdQuartosDisponiveis();
	}
	
	@Override
	public Integer obterQtdQuartosOcupados() {
		return this.repository.obterQtdQuartosOcupados();
	}
	
	@Override
	public List<Quartos> listarTodos() {
		return (List<Quartos>) this.repository.findAll();
	}
	
	@Override
	public List<Quartos> obterListaQuartosDisponiveis(){
		return this.repository.obterListaQuartosDisponiveis();
	}
}
