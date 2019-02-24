package com.algamoneyFAS.api.service;

import org.springframework.beans.BeanUtils;
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
		validaPessoa(lancamento);
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Long id, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoExistente(id);
		if (!lancamentoSalvo.getPessoa().equals(lancamento.getPessoa())) {
			validaPessoa(lancamento);
		}

		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");

		return lancamentoRepository.save(lancamentoSalvo);
	}

	public void validaPessoa(Lancamento lancamento) {
		Pessoa pessoa = null;
		if (lancamento.getPessoa().getId() != null) {
			pessoa = pessoaRepository.findOne(lancamento.getPessoa().getId());
		}

		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistentOuInativaException();
		}
	}

	public Lancamento buscarLancamentoExistente(Long codigo) {
		Lancamento lancamentoSalvo = lancamentoRepository.findOne(codigo);
		if (lancamentoSalvo == null) {
			throw new IllegalArgumentException();
		}
		return lancamentoSalvo;
	}

}
