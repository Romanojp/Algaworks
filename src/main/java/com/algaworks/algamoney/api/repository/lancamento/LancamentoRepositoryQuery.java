package com.algaworks.algamoney.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.repository.projection.ResumoLancamento;
import com.algaworks.algamoney.api.resource.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable page);
	public Page<ResumoLancamento> resumir (LancamentoFilter lancamentoFilter, Pageable page);
 
}
 