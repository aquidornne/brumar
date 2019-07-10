package com.blumar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumar.entity.Ocupacoes;
import com.blumar.entity.OcupacoesPessoas;
import com.blumar.entity.Pessoas;
import com.blumar.repository.OcupacoesPessoasRepository;
import com.blumar.repository.PessoasRepository;

@Service
public class PessoasServiceImpl implements PessoasService {
	
	@Autowired
	public PessoasRepository repository;
	@Autowired
	public OcupacoesPessoasRepository repoOcupacoesPessoas;
	
	public PessoasServiceImpl(PessoasRepository repository, OcupacoesPessoasRepository repoOcupacoesPessoas){
		this.repository = repository;
		this.repoOcupacoesPessoas = repoOcupacoesPessoas;
	}
	
	public Page<Pessoas> lista(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	public Pessoas obterPorId(Long id) {
		return this.repository.findOne(id);
	}
	
	public Pessoas salvar(Pessoas Pessoas) {
		return this.repository.save(Pessoas);
	}
	
	public void salvarOcupacoesPessoas(Pessoas Pessoas, Long ocupacaoId) {
		Pessoas pessoa = this.salvar(Pessoas);
		
		Ocupacoes ocupacao = new Ocupacoes(ocupacaoId);
		OcupacoesPessoas ocupacaoPessoa = new OcupacoesPessoas();
		ocupacaoPessoa.setOcupacoes(ocupacao);
		ocupacaoPessoa.setPessoas(pessoa);
		repoOcupacoesPessoas.save(ocupacaoPessoa);
	}
	
}
