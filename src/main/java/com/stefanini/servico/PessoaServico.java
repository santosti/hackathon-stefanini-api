package com.stefanini.servico;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaDao;
import com.stefanini.exception.NegocioException;
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * 
 * @author joaopedromilhome
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaDao dao;

	@Inject
	private PessoaPerfilServico pessoaPerfilServico;

	@Inject
	private EnderecoServico enderecoServico;

	// Salvar os dados de uma Pessoa
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Pessoa salvar(@Valid Pessoa pessoa) {
		//Salvar endereço unico
		Optional<Endereco> endereco = pessoa.getEnderecos().stream().findFirst();

		// Array para adicionar mais de um endereço a uma pessoa
		/*
		 * List<Endereco> enderecos = new ArrayList<>(); for (Endereco enderecoPessoa :
		 * pessoa.getEnderecos()) { enderecos.add(enderecoPessoa); }
		 */
		/*
		 * for (Endereco salvarEndereco : enderecos) { salvarEndereco.setIdPessoa(id);
		 * enderecoServico.salvar(salvarEndereco); }
		 */

		if (endereco.isPresent()) {
			pessoa.getEnderecos().clear();

			Pessoa salvarPessoa = dao.salvar(pessoa);
			Long id = salvarPessoa.getId();

			endereco.get().setIdPessoa(id);
			enderecoServico.salvar(endereco.get());

			return pessoa;
		}
		return dao.salvar(pessoa);
	}

	// Validando se existe pessoa com email
	public Boolean validarPessoa(@Valid Pessoa pessoa) {
		if (pessoa.getId() != null) {
			Optional<Pessoa> encontrar = dao.encontrar(pessoa.getId());

			if (encontrar.get().getEmail().equals(pessoa.getEmail())) {
				return Boolean.TRUE;
			}
		}
		Optional<Pessoa> pessoa1 = dao.buscarPessoaPorEmail(pessoa.getEmail());
		return pessoa1.isEmpty();
	}

	// Atualizar o dados de uma pessoa
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Pessoa atualizar(@Valid Pessoa entity) {
		return dao.atualizar(entity);
	}

	// Remover uma pessoa pelo id
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void remover(@Valid Long id) throws NegocioException {
		if (pessoaPerfilServico.buscarPessoaPerfil(id, null).count() == 0) {
			dao.remover(id);
			return;
		}
		throw new NegocioException("Não foi possivel remover a pessoa");
	}

	// Buscar uma lista de Pessoa
	// public Optional<List<Pessoa>> getList() { return dao.getList(); }
	 
	// Buscar uma Pessoa pelo ID
	public Optional<Pessoa> encontrar(Long id) {
		return dao.encontrar(id);
	}

	public List<Pessoa> obterPessoaComRelacionamentos() {
		return dao.obterPessoaComRelacionamentos();
	}

	public List<Pessoa> listarPessoasPaginado(Integer pageNumber, Integer pageSize) {
		return dao.listarPessoasPaginado(pageNumber, pageSize);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Pessoa atualizarCaminhoImagemPessoa(Long id, String caminhoImagem) {
		Pessoa pessoa = dao.encontrar(id).get();
		pessoa.setImagem(caminhoImagem);
		return dao.atualizar(pessoa);
	}
}
