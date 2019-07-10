package com.blumar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pessoas")
public class Pessoas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String nm_pessoa;
	@Column
	private String telefone;
	@Column
	private String email;
	@Column
	private String nu_cpf;
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column
	private Date dt_nascimento;
	
	@OneToMany(mappedBy = "id")
	@JsonIgnore
    private List<OcupacoesPessoas> ocupacoesPessoas;
	
	public Pessoas() {
	}
	
	public Pessoas(Long id) {
		super();
		this.id = id;
	}
	
	public Pessoas(Long id, String nm_pessoa, String telefone, String email, String nu_cpf,
			Date dt_nascimento, List<OcupacoesPessoas> ocupacoesPessoas) {
		super();
		this.id = id;
		this.nm_pessoa = nm_pessoa;
		this.telefone = telefone;
		this.email = email;
		this.nu_cpf = nu_cpf;
		this.dt_nascimento = dt_nascimento;
		this.ocupacoesPessoas = ocupacoesPessoas;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNm_pessoa() {
		return nm_pessoa;
	}
	
	public void setNm_pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNu_cpf() {
		return nu_cpf;
	}
	
	public void setNu_cpf(String nu_cpf) {
		this.nu_cpf = nu_cpf;
	}
		
	public Date getDt_nascimento() {
		return dt_nascimento;
	}
	
	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	public List<OcupacoesPessoas> getOcupacoesPessoas() {
		return ocupacoesPessoas;
	}
	
	public void setOcupacoesPessoas(List<OcupacoesPessoas> ocupacoesPessoas) {
		this.ocupacoesPessoas = ocupacoesPessoas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dt_nascimento == null) ? 0 : dt_nascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nm_pessoa == null) ? 0 : nm_pessoa.hashCode());
		result = prime * result + ((nu_cpf == null) ? 0 : nu_cpf.hashCode());
		result = prime * result + ((ocupacoesPessoas == null) ? 0 : ocupacoesPessoas.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Pessoas other = (Pessoas) obj;
		if (dt_nascimento == null) {
			if (other.dt_nascimento != null)
				return false;
		} else if (!dt_nascimento.equals(other.dt_nascimento))
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
		if (nm_pessoa == null) {
			if (other.nm_pessoa != null)
				return false;
		} else if (!nm_pessoa.equals(other.nm_pessoa))
			return false;
		if (nu_cpf == null) {
			if (other.nu_cpf != null)
				return false;
		} else if (!nu_cpf.equals(other.nu_cpf))
			return false;
		if (ocupacoesPessoas == null) {
			if (other.ocupacoesPessoas != null)
				return false;
		} else if (!ocupacoesPessoas.equals(other.ocupacoesPessoas))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Pessoas [id=" + id + ", nm_pessoa=" + nm_pessoa + ", telefone=" + telefone + ", email=" + email
				+ ", nu_cpf=" + nu_cpf + ", dt_nascimento=" + dt_nascimento
				+ ", ocupacoesPessoas=" + ocupacoesPessoas + "]";
	}
}
