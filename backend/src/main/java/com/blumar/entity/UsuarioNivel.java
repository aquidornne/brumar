package com.blumar.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuarios_niveis")
public class UsuarioNivel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@CreationTimestamp
	@Column
	private Date dt_criacao;
	@UpdateTimestamp
	@Column
	private Date dt_atualizacao;
	@Column
	private String ds_descricao;
	
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @OneToMany
    private List<Usuario> usuario;
	
	public UsuarioNivel() {
		super();
	}
	
	public UsuarioNivel(Long id) {
		super();
		this.id = id;
	}
	
	public UsuarioNivel(Long id, Date dt_criacao, Date dt_atualizacao, String ds_descricao, List<Usuario> usuario) {
		super();
		this.id = id;
		this.dt_criacao = dt_criacao;
		this.dt_atualizacao = dt_atualizacao;
		this.ds_descricao = ds_descricao;
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public String getDs_descricao() {
		return ds_descricao;
	}
	
	public void setDs_descricao(String ds_descricao) {
		this.ds_descricao = ds_descricao;
	}
	
	public List<Usuario> getUsuario() {
		return usuario;
	}
	
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ds_descricao == null) ? 0 : ds_descricao.hashCode());
		result = prime * result + ((dt_atualizacao == null) ? 0 : dt_atualizacao.hashCode());
		result = prime * result + ((dt_criacao == null) ? 0 : dt_criacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		UsuarioNivel other = (UsuarioNivel) obj;
		if (ds_descricao == null) {
			if (other.ds_descricao != null)
				return false;
		} else if (!ds_descricao.equals(other.ds_descricao))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UsuarioNivel [id=" + id + ", dt_criacao=" + dt_criacao + ", dt_atualizacao=" + dt_atualizacao
				+ ", ds_descricao=" + ds_descricao + ", usuario=" + usuario + "]";
	}
}
