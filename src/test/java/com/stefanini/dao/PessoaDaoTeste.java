package com.stefanini.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.stefanini.model.Pessoa;

import mockit.Injectable;
import mockit.Tested;

public class PessoaDaoTeste {
	@Injectable
	EntityManager em;

	@Tested
	PessoaDao pessoaDao;

	@Test
	public void testeBuscarPessoaPorEmail() {
		String email = "email";
		pessoaDao.buscarPessoaPorEmail(email);
		Optional<Pessoa> pessoa = pessoaDao.buscarPessoaPorEmail(email);
		assertTrue(pessoa.isEmpty());

	}

	@Test
	public void testeListarPessoasPaginado() {
		Integer pageNumber = 1;
		Integer pageSize = 5;
		List<Pessoa> pessoa = pessoaDao.listarPessoasPaginado(pageNumber, pageSize);
		assertTrue(pessoa.isEmpty());
	}

	@Test
	public void testeObterPessoasComRelacionamentos() {
		List<Pessoa> pessoa = pessoaDao.obterPessoaComRelacionamentos();
		assertTrue(pessoa.isEmpty());

	}
}
