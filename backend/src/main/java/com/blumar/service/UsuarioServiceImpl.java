package com.blumar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumar.entity.Usuario;
import com.blumar.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	public UsuarioRepository repository;
	
	@PersistenceContext
	private EntityManager em;
	
	public UsuarioServiceImpl(UsuarioRepository repository){
		this.repository = repository;
	}
	
	public Page<Usuario> lista(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	public List<Usuario> listarTodos() {
		return (List<Usuario>) this.repository.findAll();
	}
	
	public Usuario obterPorId(Long id) {
		return this.repository.findOne(id);
	}
	
	public Usuario salvar(Usuario usuario) {
		return this.repository.save(usuario);
	}
	
	public void removerPorId(Usuario usuario) {
		this.repository.delete(usuario);
	}
	
	public Usuario verificarDadosLogin(String cpfCnpj, String senha) {
		return this.repository.verificarDadosLogin(cpfCnpj, senha);
	}	
}
