package com.blumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blumar.entity.Ocupacoes;
import com.blumar.entity.Quartos;
import com.blumar.entity.Pessoas;
import com.blumar.entity.criteria.OcupacoesFiltros;
import com.blumar.entity.criteria.OcupacoesPesquisas;
import com.blumar.service.OcupacoesService;
import com.blumar.service.QuartosService;
import com.blumar.service.PessoasService;

@Controller
@RequestMapping("/ocupacoes")
@CrossOrigin
public class ManterOcupacoesController {
	
	@Autowired
	public OcupacoesService OcupacoesService;
	@Autowired
	public QuartosService QuartosService;
	@Autowired
	public PessoasService PessoasService;
	
	public ManterOcupacoesController(OcupacoesService ocupacoesService,
			QuartosService quartosService, PessoasService pessoasService) {
		OcupacoesService = ocupacoesService;
		QuartosService = quartosService;
		PessoasService = pessoasService;
	}
	
    @GetMapping("/filtro")
    @ResponseBody
    public OcupacoesPesquisas filtro(OcupacoesFiltros filtros) {
		return this.OcupacoesService.filtro(filtros);
    }
    
    @PutMapping("/adicionarOcupacoes/{quarto_id}")
    @ResponseBody
    public Ocupacoes adicionarOcupacoes(
    		@RequestBody Ocupacoes Ocupacoes,
    		@PathVariable("quarto_id") Long quartoId
	) {
    	return this.OcupacoesService.salvar(Ocupacoes, quartoId);
    }
    
    @PutMapping("/adicionarPessoas/{ocupacao_id}")
    @ResponseBody
    public void adicionarPessoas(
    		@RequestBody Pessoas Pessoas,
    		@PathVariable("ocupacao_id") Long ocupacaoId
	) {
    	this.PessoasService.salvarOcupacoesPessoas(Pessoas, ocupacaoId);
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Ocupacoes obterPorId(@PathVariable(value = "id") Long id) {
    	return this.OcupacoesService.obterPorId(id);
    }
    
    @GetMapping("/obterQtdQuartosDisponiveis")
    @ResponseBody
    public Integer obterQtdQuartosDisponiveis() {
    	return this.QuartosService.obterQtdQuartosDisponiveis();
    }
    
    @GetMapping("/obterQtdQuartosOcupados")
    @ResponseBody
    public Integer obterQtdQuartosOcupados() {
    	return this.QuartosService.obterQtdQuartosOcupados();
    }
    
    @GetMapping("/obterQuartos")
    @ResponseBody
    public List<Quartos> obterQuartos() {
    	return this.QuartosService.listarTodos();
    }
    
    @GetMapping("/obterListaQuartosDisponiveis")
    @ResponseBody
    public List<Quartos> obterListaQuartosDisponiveis() {
    	return this.QuartosService.obterListaQuartosDisponiveis();
    }
    
}
