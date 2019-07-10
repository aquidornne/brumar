package com.blumar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.blumar.entity.Pessoas;

public interface PessoasService {
	public Page<Pessoas> lista(Pageable pageable);
	public Pessoas obterPorId(Long id);
	public Pessoas salvar(Pessoas Pessoas);
	public void salvarOcupacoesPessoas(Pessoas Pessoas, Long ocupacaoId);
}
