package com.blumar.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.blumar.entity.Usuario;

public interface UsuarioService {
	public Page<Usuario> lista(Pageable pageable);
	public List<Usuario> listarTodos();
	public Usuario obterPorId(Long id);
	public Usuario salvar(Usuario usuario);
	public void removerPorId(Usuario usuario);
	public Usuario verificarDadosLogin(String cpfCnpj, String senha);
}
