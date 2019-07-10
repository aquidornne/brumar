package com.blumar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.blumar.entity.Quartos;

public interface QuartosRepository extends PagingAndSortingRepository<Quartos, Long> {
	
	@Query("SELECT COUNT(q) FROM Quartos q WHERE q.ocupado = false")
	Integer obterQtdQuartosDisponiveis();
	
	@Query("SELECT COUNT(q) FROM Quartos q WHERE q.ocupado = true")
	Integer obterQtdQuartosOcupados();
	
	@Query("SELECT q from Quartos q WHERE q.ocupado = false ORDER BY q.nu_quarto ASC")
	List<Quartos> obterListaQuartosDisponiveis();
	
	Quartos findById(Long id);
}