package com.algamoneyFAS.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algamoneyFAS.api.model.Lancamento;
import com.algamoneyFAS.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
