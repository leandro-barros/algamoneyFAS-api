package com.algamoneyFAS.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algamoneyFAS.api.model.Lancamento;
import com.algamoneyFAS.api.repository.filter.LancamentoFilter;
import com.algamoneyFAS.api.repository.projection.ResumoLacamento;

public interface LancamentoRepositoryQuery {
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLacamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);

}
