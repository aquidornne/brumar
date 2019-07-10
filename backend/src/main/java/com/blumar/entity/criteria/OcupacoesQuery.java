package com.blumar.entity.criteria;

import java.util.List;

import javax.persistence.EntityManager;

import com.blumar.entity.Ocupacoes;
import com.blumar.entity.QOcupacoes;
import com.blumar.entity.QOcupacoesPessoas;
import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;

public class OcupacoesQuery {
	private OcupacoesQuery() {
		
	}
	
	/*
	 * Condições
	 */
	private static Predicate condicoes(QOcupacoes Ocupacoes, QOcupacoesPessoas OcupacoesPessoas, OcupacoesFiltros filtros) {
		BooleanBuilder builder = new BooleanBuilder();
		
		if (filtros.getQuarto_id() != null) {
			builder.and(CriteriaUtil.compararLong(Ocupacoes.quartos.id, filtros.getQuarto_id()));
		}
		
		if (filtros.getNu_quarto() != null) {
			builder.and(CriteriaUtil.compararInt(Ocupacoes.quartos.nu_quarto, filtros.getNu_quarto()));
		}
		
		if (filtros.getNm_pessoa() != null && !filtros.getNm_pessoa().equals("")) {
			builder.and(CriteriaUtil.buscaLike(OcupacoesPessoas.pessoas.nm_pessoa, filtros.getNm_pessoa()));
		}
		
		return builder;
	}
	
	/*
	 * Ordem
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static OrderSpecifier<?> orderBy(QOcupacoes Ocupacoes, QOcupacoesPessoas OcupacoesPessoas, Boolean ordem_dir, String field) {
		Expression expression = Ocupacoes.id;
		
		if (!Strings.isNullOrEmpty(field)) {
			switch (field) {
				case "nu_quarto" : expression = Ocupacoes.quartos.nu_quarto; break;
				case "dt_checkin" : expression = Ocupacoes.dt_checkin; break;
				case "dt_checkout" : expression = Ocupacoes.dt_checkin; break;
			}
		}
		
		if(ordem_dir == null) {
			ordem_dir = true;
		}
		
		return new OrderSpecifier<Comparable>(ordem_dir ? Order.ASC : Order.DESC, expression);
	}
	
	/*
	 * Buscar todos
	 */
	public static List<Ocupacoes> buscarPorCriterios(EntityManager em, OcupacoesFiltros filtros) {
		JPAQuery query = new JPAQuery(em);
		QOcupacoes Ocupacoes = new QOcupacoes("o");
		QOcupacoesPessoas OcupacoesPessoas = new QOcupacoesPessoas("op");
		
		Predicate where = condicoes(Ocupacoes, OcupacoesPessoas, filtros);
		
		Integer offset = 0;
		if(filtros.getPagina() != null) {
			offset = filtros.getPagina();
		}
		
		return query.from(Ocupacoes)
				.leftJoin(Ocupacoes.ocupacoesPessoas, OcupacoesPessoas)
				.where(where)
				.offset(offset)
				.orderBy(orderBy(Ocupacoes, OcupacoesPessoas, filtros.getOrdem_dir(), filtros.getOrdem()))
				.limit(filtros.getLinhas())
				.list(Ocupacoes);
	}
	
	/*
	 * Buscar todos contador
	 */
	public static long quantidade(EntityManager em, OcupacoesFiltros filtros) {
		JPAQuery query = new JPAQuery(em);
		QOcupacoes Ocupacoes = new QOcupacoes("o");
		QOcupacoesPessoas OcupacoesPessoas = new QOcupacoesPessoas("op");
		
		Predicate where = condicoes(Ocupacoes, OcupacoesPessoas, filtros);
		
		return query.from(Ocupacoes)
				.leftJoin(Ocupacoes.ocupacoesPessoas, OcupacoesPessoas)
				.where(where)
				.count();
	}
}