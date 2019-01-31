package com.algamoneyFAS.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algamoneyFAS.api.model.Lancamento;
import com.algamoneyFAS.api.model.Pessoa;
import com.algamoneyFAS.api.repository.LancamentoRepository;
import com.algamoneyFAS.api.repository.PessoaRepository;
import com.algamoneyFAS.api.service.exception.PessoaInexistentOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getId());
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistentOuInativaException(); 
		}
		return lancamentoRepository.save(lancamento);
	}

}
