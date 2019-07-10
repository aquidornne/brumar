package com.blumar.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private Long usuario_id;
	@CreationTimestamp
	@Column
	private Date dt_criacao;
	@UpdateTimestamp
	@Column
	private Date dt_atualizacao;
	@Column
	private String nome;
	@Column
	private String cpf_cnpj;
	@Column
	private String email;
	@Column
	private String senha;
	@Column
	private Boolean acesso;
	
    @JoinColumn(name = "usuario_nivel_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioNivel usuarioNivel;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Long id) {
		super();
		this.id = id;
	}
	
	public Usuario(Long id, Long usuario_id, Date dt_criacao, Date dt_atualizacao, String nome, String cpf_cnpj,
			String email, String senha, Boolean acesso, UsuarioNivel usuarioNivel) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.dt_criacao = dt_criacao;
		this.dt_atualizacao = dt_atualizacao;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.email = email;
		this.senha = senha;
		this.acesso = acesso;
		this.usuarioNivel = usuarioNivel;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUsuario_id() {
		return usuario_id;
	}
	
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	public Date getDt_criacao() {
		return dt_criacao;
	}
	
	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}
	
	public Date getDt_atualizacao() {
		return dt_atualizacao;
	}
	
	public void setDt_atualizacao(Date dt_atualizacao) {
		this.dt_atualizacao = dt_atualizacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean getAcesso() {
		return acesso;
	}
	
	public void setAcesso(Boolean acesso) {
		this.acesso = acesso;
	}
	
	public UsuarioNivel getUsuarioNivel() {
		return usuarioNivel;
	}
	
	public void setUsuarioNivel(UsuarioNivel usuarioNivel) {
		this.usuarioNivel = usuarioNivel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acesso == null) ? 0 : acesso.hashCode());
		result = prime * result + ((cpf_cnpj == null) ? 0 : cpf_cnpj.hashCode());
		result = prime * result + ((dt_atualizacao == null) ? 0 : dt_atualizacao.hashCode());
		result = prime * result + ((dt_criacao == null) ? 0 : dt_criacao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuarioNivel == null) ? 0 : usuarioNivel.hashCode());
		result = prime * result + ((usuario_id == null) ? 0 : usuario_id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (acesso == null) {
			if (other.acesso != null)
				return false;
		} else if (!acesso.equals(other.acesso))
			return false;
		if (cpf_cnpj == null) {
			if (other.cpf_cnpj != null)
				return false;
		} else if (!cpf_cnpj.equals(other.cpf_cnpj))
			return false;
		if (dt_atualizacao == null) {
			if (other.dt_atualizacao != null)
				return false;
		} else if (!dt_atualizacao.equals(other.dt_atualizacao))
			return false;
		if (dt_criacao == null) {
			if (other.dt_criacao != null)
				return false;
		} else if (!dt_criacao.equals(other.dt_criacao))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuarioNivel == null) {
			if (other.usuarioNivel != null)
				return false;
		} else if (!usuarioNivel.equals(other.usuarioNivel))
			return false;
		if (usuario_id == null) {
			if (other.usuario_id != null)
				return false;
		} else if (!usuario_id.equals(other.usuario_id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario_id=" + usuario_id + ", dt_criacao=" + dt_criacao + ", dt_atualizacao="
				+ dt_atualizacao + ", nome=" + nome + ", cpf_cnpj=" + cpf_cnpj + ", email=" + email + ", senha=" + senha
				+ ", acesso=" + acesso + ", usuarioNivel=" + usuarioNivel + "]";
	}
}
