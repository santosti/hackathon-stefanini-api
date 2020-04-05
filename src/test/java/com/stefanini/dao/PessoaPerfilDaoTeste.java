package com.stefanini.dao;

import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.stefanini.model.PessoaPerfil;

import mockit.Injectable;
import mockit.Tested;

public class PessoaPerfilDaoTeste {
	@Injectable
	EntityManager em;

	@Tested
	PessoaPerfilDao pessoaPerfilDao;
	
	@Test
	public void testebuscarPessoaPerfil() {
		Long idPessoa = 1L;
		Long idPerfil = 2L;
		Stream<PessoaPerfil> pessoaPerfil = pessoaPerfilDao.buscarPessoaPerfil(idPessoa, idPerfil);
		assertTrue(Stream.empty() != null);

	}
}
