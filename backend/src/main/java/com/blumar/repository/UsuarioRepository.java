package com.blumar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.blumar.entity.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	@Query("SELECT u FROM Usuario u WHERE u.cpf_cnpj = :cpfCnpj AND u.senha = :senha")
	Usuario verificarDadosLogin(@Param("cpfCnpj") String cpfCnpj, @Param("senha") String senha);
}