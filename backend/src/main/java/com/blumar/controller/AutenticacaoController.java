package com.blumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blumar.entity.Usuario;
import com.blumar.service.UsuarioService;
import com.blumar.util.Util;

@Controller
@RequestMapping("/autenticacao")
@CrossOrigin
public class AutenticacaoController {
	
	@Autowired
	public UsuarioService UsuarioService;
	
	public AutenticacaoController(UsuarioService UsuarioService) {
		this.UsuarioService = UsuarioService;
	}
	
    @GetMapping("/listarTodos")
    @ResponseBody
    public List<Usuario> listarTodos() {
    	return this.UsuarioService.listarTodos();
    }
    
    @PostMapping("/adicionar/")
    @ResponseBody
    public Usuario salvar(@RequestBody Usuario Usuario) {
    	return this.UsuarioService.salvar(Usuario);
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Usuario obterPorId(@PathVariable(value = "id") Long id) {
    	return this.UsuarioService.obterPorId(id);
    }
    
    @PostMapping("/verificarDadosLogin")
    @ResponseBody
    public Usuario verificarDadosLogin(@RequestBody Usuario usuario) {
    	return this.UsuarioService.verificarDadosLogin(usuario.getCpf_cnpj(), Util.gerarMD5(usuario.getSenha()));
    }
}
