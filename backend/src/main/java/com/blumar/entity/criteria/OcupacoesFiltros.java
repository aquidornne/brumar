package com.blumar.entity.criteria;

import com.google.common.base.Strings;

public class OcupacoesFiltros {
	private static final String CAMPO_ORDEM_DEFAULT = "id";
	
	private static final int QTD_LINHAS_TABELA = 50;
	
	private Long quarto_id;
	private Integer nu_quarto;
	private String nm_pessoa;
	
	private Integer pagina;
	private String ordem;
	private Boolean ordem_dir;
	
	public Long getQuarto_id() {
		return quarto_id;
	}
	
	public void setQuarto_id(Long quarto_id) {
		this.quarto_id = quarto_id;
	}
	
	public Integer getNu_quarto() {
		return nu_quarto;
	}
	
	public void setNu_quarto(Integer nu_quarto) {
		this.nu_quarto = nu_quarto;
	}
	
	public String getNm_pessoa() {
		return nm_pessoa;
	}
	
	public void setNm_pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}
	
	public Integer getLinhas() {
		return QTD_LINHAS_TABELA;
	}
	
	public Integer getPagina() {
		return pagina;
	}
	
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	public String getOrdem() {
		if (Strings.isNullOrEmpty(ordem)) {
			return CAMPO_ORDEM_DEFAULT;
		}
		return ordem;
	}
	
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	public Boolean getOrdem_dir() {
		return ordem_dir;
	}
	
	public void setOrdem_dir(Boolean ordem_dir) {
		this.ordem_dir = ordem_dir;
	}
}
