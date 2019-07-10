package com.blumar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blumar.entity.Ocupacoes;

public interface OcupacoesRepository extends PagingAndSortingRepository<Ocupacoes, Long> {
}