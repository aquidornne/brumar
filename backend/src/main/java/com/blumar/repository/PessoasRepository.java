package com.blumar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blumar.entity.Pessoas;

public interface PessoasRepository extends PagingAndSortingRepository<Pessoas, Long> {
}