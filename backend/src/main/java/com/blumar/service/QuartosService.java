package com.blumar.service;

import java.util.List;

import com.blumar.entity.Quartos;

public interface QuartosService {
	public Quartos salvar(Quartos quartos);
	public Integer obterQtdQuartosDisponiveis();
	public Integer obterQtdQuartosOcupados();
	public List<Quartos> listarTodos();
	public List<Quartos> obterListaQuartosDisponiveis();
}
