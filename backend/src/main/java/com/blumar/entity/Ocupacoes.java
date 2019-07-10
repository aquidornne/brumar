package com.blumar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ocupacoes")
public class Ocupacoes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column
	private Date dt_checkin;
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column
	private Date dt_checkout;
	@Column
	private Boolean in_ativo;
	@Column
	private Integer tp_ocupacao;
	@Column
	private Integer qtd_dias;
	
	@JoinColumn(name = "quarto_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Quartos quartos;
	
	@OneToMany(mappedBy = "id")
	@JsonIgnore
    private List<OcupacoesPessoas> ocupacoesPessoas;
	
	public Ocupacoes() {
	}
	
	public Ocupacoes(Long id) {
		super();
		this.id = id;
	}
	
	public Ocupacoes(Long id, Date dt_checkin, Date dt_checkout, Boolean in_ativo, Integer tp_ocupacao,
			Integer qtd_dias, Quartos quartos, List<OcupacoesPessoas> ocupacoesPessoas) {
		super();
		this.id = id;
		this.dt_checkin = dt_checkin;
		this.dt_checkout = dt_checkout;
		this.in_ativo = in_ativo;
		this.tp_ocupacao = tp_ocupacao;
		this.qtd_dias = qtd_dias;
		this.quartos = quartos;
		this.ocupacoesPessoas = ocupacoesPessoas;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDt_checkin() {
		return dt_checkin;
	}
	
	public void setDt_checkin(Date dt_checkin) {
		this.dt_checkin = dt_checkin;
	}
	
	public Date getDt_checkout() {
		return dt_checkout;
	}
	
	public void setDt_checkout(Date dt_checkout) {
		this.dt_checkout = dt_checkout;
	}
	
	public Boolean getIn_ativo() {
		return in_ativo;
	}
	
	public void setIn_ativo(Boolean in_ativo) {
		this.in_ativo = in_ativo;
	}
	
	public Integer getTp_ocupacao() {
		return tp_ocupacao;
	}
	
	public void setTp_ocupacao(Integer tp_ocupacao) {
		this.tp_ocupacao = tp_ocupacao;
	}
	
	public Integer getQtd_dias() {
		return qtd_dias;
	}
	
	public void setQtd_dias(Integer qtd_dias) {
		this.qtd_dias = qtd_dias;
	}
	
	public Quartos getQuartos() {
		return quartos;
	}
	
	public void setQuartos(Quartos quartos) {
		this.quartos = quartos;
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
		result = prime * result + ((dt_checkin == null) ? 0 : dt_checkin.hashCode());
		result = prime * result + ((dt_checkout == null) ? 0 : dt_checkout.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((in_ativo == null) ? 0 : in_ativo.hashCode());
		result = prime * result + ((ocupacoesPessoas == null) ? 0 : ocupacoesPessoas.hashCode());
		result = prime * result + ((qtd_dias == null) ? 0 : qtd_dias.hashCode());
		result = prime * result + ((quartos == null) ? 0 : quartos.hashCode());
		result = prime * result + ((tp_ocupacao == null) ? 0 : tp_ocupacao.hashCode());
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
		Ocupacoes other = (Ocupacoes) obj;
		if (dt_checkin == null) {
			if (other.dt_checkin != null)
				return false;
		} else if (!dt_checkin.equals(other.dt_checkin))
			return false;
		if (dt_checkout == null) {
			if (other.dt_checkout != null)
				return false;
		} else if (!dt_checkout.equals(other.dt_checkout))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (in_ativo == null) {
			if (other.in_ativo != null)
				return false;
		} else if (!in_ativo.equals(other.in_ativo))
			return false;
		if (ocupacoesPessoas == null) {
			if (other.ocupacoesPessoas != null)
				return false;
		} else if (!ocupacoesPessoas.equals(other.ocupacoesPessoas))
			return false;
		if (qtd_dias == null) {
			if (other.qtd_dias != null)
				return false;
		} else if (!qtd_dias.equals(other.qtd_dias))
			return false;
		if (quartos == null) {
			if (other.quartos != null)
				return false;
		} else if (!quartos.equals(other.quartos))
			return false;
		if (tp_ocupacao == null) {
			if (other.tp_ocupacao != null)
				return false;
		} else if (!tp_ocupacao.equals(other.tp_ocupacao))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Ocupacoes [id=" + id + ", dt_checkin=" + dt_checkin + ", dt_checkout=" + dt_checkout + ", in_ativo="
				+ in_ativo + ", tp_ocupacao=" + tp_ocupacao + ", qtd_dias=" + qtd_dias + ", quartos=" + quartos
				+ ", ocupacoesPessoas=" + ocupacoesPessoas + "]";
	}
}
